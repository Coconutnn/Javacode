/*题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。*/
//如数组样式如下： 
// 1 2 3 4 
// 2 3 4 5 
// 3 4 5 6
//采取右上角比较，一次排除一整列一整行。
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array==null){
            return false;
        }
        int i = 0;
        int j = array[0].length-1;
        while( i<array.length && j>=0 ){
            if(target<array[i][j]){
                j--;
            }else if(target>array[i][j]){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}