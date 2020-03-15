/*1.冒泡排序
冒泡的过程只涉及相邻数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为O(1)，是一个原地排序算法。
相同大小的数据在排序前后不会改变顺序，所以冒泡排序是稳定的 排序算法。
最好情况下，时间复杂度是O(n);而最坏的情况，时间复杂度是O(n^2)
*/
public void bubbleSort(int[]a ,int n){
	for(int i=0;i<n;i++){
		//提前退出冒泡循环标志位
		boolean flag = false;
		for(int j=0;j<n-i-1;j++){
			if(a[j]>a[j+1]){
				int tmp = a[j];
				a[j]=a[j-1];
				a[j-1] = tmp;
				flag = true;//发生交换
			}
		}
		if(!flag)break;//没有数据交换，提前退出
	}
}
/*2.插入排序
插入排序算法的运行并不需要额外的存储空间，所以空间复杂度是O(1)，是一个原地排序算法。
插入排序是稳定的排序算法。
最好情况下，时间复杂度是O(n);而最坏的情况，时间复杂度是O(n^2)
**/
public static void insertSort(int[] a){
	for(int i =1;i<a.length;i++){
		int key = a[i];
		int j;
		for(int j =i-1;j>=0&&a[j]>key;j--){
			a[j+1]=a[j];
		}
		a[j+1] = key;
	}
}

/*3.希尔排序
希尔排序是对直接插入排序的优化。
时间复杂度最好O(n) 平均O(n^1.3) 最坏O(n^2),空间复杂度O(1)
希尔排序不稳定
*/
public static void shellSort(int[] array){
	int gap =array.length;
	while(true){
		gap = (gap/3)+1;
		insertSortGap(array,gap);
		if(gap==1)
			break;
	}
}
public static void insertSort(int[] array,int gap){
	for(int i =gap;i<array.length;i++){
		int key = array[i];
		int j;
		for(j=i-gap;j>=0&&array[j]>key;j=j-gap){
			array[j+gap]=array[j];
		}
		array[j+gap]=key;
	}
}

/*4.选择排序
时间复杂度为O(n^2),空间复杂度为O(1)
选择排序不稳定
*/
//在无序区间选出最大的放到有序区间最前
public static void selectSort(int[] array){
	//有序区间[0，array.length-i)
	//无序区间[array.length-i,array.length)
	for(int i =0;i<array.length-1;i++){
		int max = 0;
		for(int j =1;j<array.length-i-1;j++){
			if(array[j]>array[max]){
				max = j;
			}
		}
		int t =array[max];
		array[max] =array[array.length-i-1];
		array[array.length-i-1]=t;
	}
}

//在无序区间选出最小的放到有序区间最后
public static void selectSort(int[] array){
	for(int i =0;i<array.length-1;i++){
		min = 0;
		for(int j =1;j<array.length;j++){
			if(array[j]<array[min]){
				min = j;
			}
		}
		int t =array[min];
		array[min]=array[i];
		array[i]=t;
	}
}

/*5.快速排序
时间复杂度最好O(n*log(n)),平均O(n*log(n))，最坏O(n^2)
空间复杂度最好O(log(n))，平均O(log(n))，最坏O(n)
快速排序不稳定
*/
public static void quickSort(int[] array){
	quickSortInternal(array,0,array.length-1);
}
//[left,right]为待排序区间
//当原数组本来就有序有可能left>right
private static void quickSortInternal(int[]array,int left,int right){
	if(left>=right)
		return;
	int base = partition(array,left,right);
	quickSortInternal(array,left,index-1);
	quickSortInternal(array,index+1,right);
}
public static int partition(int[] array,int left,int right){
	int begin = left;
	int end = right;
	int base = array[left];
	while(begin<end){
		while(begin<end&&array[end]>=base)end--;
		while(begin<end&&array[begin]<=base)begin++;
		swap(array,begin,end);
	}
	swap(array,left,begin);
	return begin;
}
public static void swap(int[]array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

/*6.堆排序
时间复杂度O(n*log(n)),空间复杂度O(1)
堆排序不稳定
*/

private static void createHeapBig(int[] array){
	//向下调整建大堆
	for(int i =(size-1)/2;i>=0;i--){
		shiftDownBig(array,i,array.length);
	}
}
public static void shiftDownBig(int[]array,int size,int index){
	int left = index*2+1;
	while(left<size){
		int max = left;
		int right = left+1;
		if(right<size&&array[left]<array[right]){
			max = right;
		}
		if(array[index]>array[max]){
			return;
		}
		swap(array,index,max);
		index = max;
	}
}
public static void heapSort(int [] array){
	createHeapBig(array);
	for(int i =0;i<array.length-1;i++){
		// 交换前
        // 无序区间: [0, array.length - i)        
        // 有序区间: [array.length-i, array.length) 
		swap(array,0,array.length-i-1);//把最大的放在末尾
		// 交换后        
        // 无序区间: [0, array.length - i - 1)        
        // 有序区间: [array.length - i - 1, array.length)
		shiftDownBig(array,array.length-i-1,0);//重新对根进行向下调整
	}
}
private void swap(int[] array, int i, int j){
	int t = array[i]; 
	array[i] = array[j]; 
	array[j] = t; 
}


/*7.归并排序
时间复杂度O(n * log(n)) 空间复杂度O(n)
稳定
*/
public static void mergeSort(int[] array) {
      mergeSortInter(array,0,array.length);
}


private static void mergeSortInter(int[] array, int low, int high) {
	if(low>=high-1){
		return;
	}
	int mid =(low+high)/2;
	mergeSortInter(array,low,mid);//[low,mid)
	mergeSortInter(array,mid,high);[mid,high)
	merge(array,low,mid,high);
}

private static void merge(int[] array, int low, int mid, int high) {
	int i =low;
	int j =mid;
	int length =high-low;
	int[] extra = new int[length];
	int k = 0;
	//选择小的放入extra
	while(i<mid&&j<high){
		if(array[i]<array[j]){
			extra[k++]=array[i++]
		}else{
			extra[k++]=array[j++];
		}
	}
	//将剩余元素放入extra
	while(i<mid)
		extra[k++]=array[i++];
	while(j<high)
		extra[k++]=array[j++];
	//从extra搬移回array
	for(int t=0;t<length;t++){
		array[low+t]=extra[t];
	}
}
















