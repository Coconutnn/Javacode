import java.util.Arrays;

public class Demo2 {
    //生成格雷码 （在一组数的编码中
    // 若任意两个相邻的代码只有一位二进制数不同， 则
    // 称这种编码为格雷码(Gray Code)
    // 请编写一个函数，使用递归的方法生成N位的格雷码。）
    public static void main(String[] args) {
        Demo2 a = new Demo2();
        a.getGray(6);
    }
    public String[] getGray(int n){
        String[] result = new String[(int)Math.pow(2,n)];
        if(n==1){
            result[0]="0";
            result[1]="1";
            return result;
        }
        String[] last = getGray(n-1);
        System.out.println(Arrays.toString(last));
        for(int i = 0;i<last.length;i++){
            result[i] = "0"+last[i];
            result[result.length-i-1] = last[i]+"1";

        }
        return result;
    }

}
