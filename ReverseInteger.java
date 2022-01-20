class ReverseInteger {
    //x=0,x=120,x=-2,-123
    public int reverse(int x) {
        long ret = 0;//0,0,0,0
        long X = x;//-123
        boolean negative = (X < 0);//false,false,true,true
        if (negative) X *= -1;//not run,nr,x=2,X=123
        
        while (X > 0) {//not run,x=120 -> x=12 -> x=1 -> x=0,x=2->x=0, x=123 -> 12 -> 1 -> 0
            ret *= 10;//0->0->20,0, ret=10*0=0->30 -> 320
            ret += X % 10;//0+0->0+2->20+1,0+2, ret = 0 + 123%10=3->30+2=32 -> 321
            X /= 10;//12->1->0,0, X=12 -> 1 -> 0
        }
        
        if (negative) ret *= -1;// true so ret = 321*-1=-321
        
        if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) return 0;
        return (int)ret;//return ret=0, return ret=21, return -ret=-2
    }
}
