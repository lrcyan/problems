class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend < 0 ^ divisor < 0);
        long longDivisor = (divisor < 0 ? 0 - (long)divisor : divisor);
        long longDividend = (dividend < 0 ? 0 - (long)dividend : dividend);
        
        
        long[] pow2 = new long[32];
        long[] pow2TimesDiv = new long[32];
        
        pow2[0] = 1;
        pow2TimesDiv[0] = longDivisor;
        
        for (int i = 1; i <= 31; i++) {
            pow2[i] = pow2[i - 1] + pow2[i - 1];
            pow2TimesDiv[i] = pow2TimesDiv[i - 1] + pow2TimesDiv[i - 1];
        }
        
        long sum = 0;
        long count = 0;
        for (int i = 31; i >= 0; i--) {
            if (sum + pow2TimesDiv[i] <= longDividend) {
                sum = sum + pow2TimesDiv[i];
                count = count + pow2[i];
            }
        }
        
        if (negative) count = 0 - count;
        if (outOfBounds(count)) return Integer.MAX_VALUE;
        return (int)count;
    }
    
    boolean outOfBounds(long count) {
        return (count < Integer.MIN_VALUE || count > Integer.MAX_VALUE);
    }
}
