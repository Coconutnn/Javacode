/*连续子数组的最大和*/
//O（N^2)
public static void maxSum(int arr[]){
	int max=0;
	int sum=0;
	for(int i=0;i<arr.length;i++){
		sum=0;
		for(int j=i;j<arr.legth;j++{
			sum+=arr[j];
			max=Math.max(sum,max);
		}
	}
	System.out.println(max);
}
//动态规划，时间复杂度O(N)
public static void maxSum(int arr[]){
	int max=0;
	int sum=0;
	for(int i=0;i<arr.length;i++){
		if(sum<=0){
			sum=arr[i];
		}else{
			sum+=arr[i];
		}
		max=Math.max(sum,max);
	}
	System.out.println(max);
}