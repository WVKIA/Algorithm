package MathAl;

/**
 * @author wukai
 * @date 2019/5/9
 */
public class q008_StringToInteger {

    public static int myAtoi(String str) {
        if (null == str) {
            return 0;
        }
        //移除空格
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }
        double result = 0;

        //判断是否是负数
        boolean negative = false;
        int startIndex=0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            startIndex++;
        }
        if (str.charAt(0) == '-') {
            negative = true;
        }

        for (int i = startIndex; i < str.length(); i++) {
            //碰到非数字字符，退出
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            result = result * 10 + (str.charAt(i) - '0');

        }
        if (negative) {
            result = -result;
        }
        //处理超过integer的数值
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String[] list = new String[]{"   -42", "42", "sdf", "23asdf", "", "-3456784567467567"};
        for (String s : list) {
            System.out.println(myAtoi(s));
        }

    }

}
