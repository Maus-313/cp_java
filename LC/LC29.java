public class LC29 {
    public static void main(String[] args) {
        // System.out.println(new LC29().divide(Integer.MIN_VALUE, 2));
        int a = Integer.MIN_VALUE;
        int b = 2;
        System.out.println(new LC29().divide(a, b));
        // System.out.println(a/b);
        // long aa = 1;
        // System.out.println(aa*Math.pow(2, 31));
        // System.out.println(aa*((long)1<<32));
        // long aa = Math.abs((long)Integer.MIN_VALUE);
        // System.out.println(aa);
        // long aa = Integer.MIN_VALUE;
        // System.out.println(Math.abs(aa)/);
    }

    public int divide(int dividend, int divisor) {

    }

    public int s_1ms_cleaner(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(dividend == divisor) return 1;
        if(dividend == 0) return 0;

        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long d = dividend;
        long dd = divisor;

        long ans = 0;
        boolean neg = false;

        if((d < 0 && dd > 0) || (d > 0 && dd < 0)) neg = true;
        // System.out.println(neg);
        d = Math.abs(d);
        dd = Math.abs(dd);

        while(d >= dd){
            // System.out.println("asd");
            long temp = dd;
            long two = 1;

            while(temp <= d){
                temp <<= 1;
                two <<= 1;
                // System.out.println(two);
            }

            // do{
            //     temp <<= 1;
            //     two <<= 1;
            // }while(temp <= d);

            temp >>= 1;
            two >>= 1;

            d -= temp;
            // System.out.println(two);
            ans += two;
        }

        // System.out.println(ans);

        if(neg) ans = -1*ans;
        return (int) ans;
    }

    public int s_2s(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long d = dividend;
        long dd = divisor;

        return help(d, dd);
    }

    static int help(long d, long dd) {
        if (d == dd)
            return 1;
        if (d == 0)
            return 0;
        if (dd == 1)
            return (int) d;

        if (d < 0 && dd < 0)
            return help(Math.abs(d), Math.abs(dd));
        if (d < 0 && dd > 0)
            return -1 * help(Math.abs(d), dd);
        if (d > 0 && dd < 0)
            return -1 * help(d, Math.abs(dd));

        int c = 0;

        while (d >= dd) {
            c++;
            d -= dd;
        }

        return c;
    }

    public int sol1(int dividend, int divisor) {
        // 1ms
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        return dividend / divisor;
    }

    public int s_1ms(int d, int dd) {
        // 1ms
        if (d == Integer.MIN_VALUE && dd == -1)
            return Integer.MAX_VALUE;
        if (d == dd)
            return 1;
        if (d == 0)
            return 0;

        long dividend = (long) d;
        long divisor = (long) dd;
        // System.out.println(dividend);

        // if(d < dd) return 0;

        boolean sign = true;
        if (d < 0 && dd > 0)
            sign = false;
        if (d > 0 && dd < 0)
            sign = false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // System.out.println(dividend);
        // return 0;
        int sum = 0;

        while (dividend >= divisor) {

            int temp = 0;
            while (dividend >= (divisor * ((long) 1 << temp))) {
                // System.out.println(dividend);
                // break;
                temp++;
                if (temp == 31)
                    break;
                // System.out.println(temp);
            }
            temp--;
            dividend = dividend - (divisor * ((long) 1 << temp));
            // System.out.println(dividend);
            sum += 1 << temp;
        }

        if (sum > Integer.MAX_VALUE) {
            if (!sign) {
                return Integer.MIN_VALUE;
            } else
                return Integer.MAX_VALUE;
        }
        //
        return (sum) * ((!sign) ? -1 : 1);
    }
}