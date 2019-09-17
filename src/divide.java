public class divide {

    public static int divide(int dividend, int divisor) {
        int temp = divisor;
        int i = 0;
        if (dividend == divisor){
            return 1;
        }
        if (dividend + divisor == 0){
            return -1;
        }
        if (Math.abs(dividend) < Math.abs(divisor) && dividend != Integer.MIN_VALUE){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE){
            System.out.println("here");
            while (-temp > Math.abs(dividend)){
                i++;
                temp -= divisor;
            }
            System.out.println(i);
        }
        else {
            while (Math.abs(temp) < Math.abs(dividend)) {
                i++;
                temp += divisor;
            }
        }
        if(dividend < 0 ^ divisor < 0){
            return -i;
        }
        return Math.abs(i);
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
