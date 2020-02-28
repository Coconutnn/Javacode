public class quickSort {
    public static void main(String[] args) {
        int[] array = {9,5,14,35,6,84,71,21,1};
        quickSortInternal(array,0,array.length-1);
        for(int a:array)
        System.out.print(a+" ");
    }
    public static void quickSortInternal(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        int base = portition(array,left,right);
        quickSortInternal(array,left,base-1);
        quickSortInternal(array,base+1,right);
    }
    public static int portition(int[]array,int left,int right){
        int begin = left;
        int end = right;
        int base = array[left];
        while (begin<end){
            while(begin<end&&array[end]>=base)end--;
            while(begin<end&&array[begin]<=base)begin++;
            swap(array,begin,end);
        }
        swap(array,left,begin);
        return begin;
    }
    public static void swap(int[]array,int a,int b){
        int temp=0;
        temp = array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
