/*题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
//选出奇数头插到前面，偶数后移
public class Solution {
    public void reOrderArray(int [] array) {
        int k=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                int temp = array[i];
                int j = i;
                while(j>k){
                    array[j]=array[j-1];
                    j--;
                }
                array[k++]=temp;
            }
        }
    }
}

//选出偶数排到最后，奇数前移
public class Solution {
    public void reOrderArray(int [] array) {
        int k=array.length-1;
        for(int i=array.length-1;i>=0;i--){
            if(array[i]%2==0){
                int temp = array[i];
                int j = i;
                while(j<k){
                    array[j]=array[j+1];
                    j++;
                }
                array[k--]=temp;
            }
        }
    }
}