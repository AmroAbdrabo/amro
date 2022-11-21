//I want to compute S=x^0 + x + x^2 + x^3 + x^4 + ... + x^N (where x is a floating point number, N an integer), how would you do that?
// 
public class t{
    public static void main(String[] args){
        int n = 1000;
        double x = 3;
        double res = 0;
        /*for (int i = 0; i <= n; ++i){
         
        }*/
        double eps = 10e-6;
        if (x + eps > 1 && x - eps < 1){
            res = n + 1;
            System.out.println(res);
        }
        else {
            res = (1 -  Math.pow(x, n+1) )/ (1-x) ;
            System.out.println(res);
        }
    }


}