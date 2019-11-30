import java.util.*;
//春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
//
//给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
//
//若没有金额超过总数的一半，返回0。
//测试样例：
//[1,2,3,2,2],5
//返回：2
public class Demo1{
    public int getValue(int[] gifts, int n) {
        // write code here

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(map.get(gifts[i])==null){
                map.put(gifts[i],1);
            }
            else{
                int number = map.get(gifts[i]).intValue();
                number++;
                if(number>n/2)
                    return gifts[i];
                map.put(gifts[i],number);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,2,2};
        int n =5;
        Demo1 s = new Demo1();
        System.out.println(s.getValue(a,n));
    }
}