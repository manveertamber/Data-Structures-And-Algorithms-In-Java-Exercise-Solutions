import java.util.Scanner;
public class MultiplicatonApp {
    public static void main(String args[]){
        System.out.println(mult(9,1));
        System.out.println(mult(9,2));
        System.out.println(mult(9,3));
        System.out.println(mult(9,4));
        System.out.println(mult(9,5));
        System.out.println(mult(9,6));
        System.out.println(mult(9,7));
        System.out.println(mult(9,8));
        System.out.println(mult(9,9));
        System.out.println(mult(9,10));
    }

    public static int mult(int x, int y){
        if(y<=1){
            return x;
        }
        else{
            return x + mult(x,y-1);
        }
    }
}
