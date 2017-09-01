public class PowerApp {
    public static void main(String args[]){
        System.out.println(power(3,20));
    }

    public static long power(long x, long y){
        if(y == 1){
            return x;
        }
        else{
            if(y%2 == 0)
                return power(x*x,y/2);
            else
                return x * power(x*x,y/2);
        }
    }
}
