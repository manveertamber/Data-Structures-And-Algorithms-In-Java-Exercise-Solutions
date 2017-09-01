import java.util.Scanner;
public class KnapsackApp {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the target weight");
        int targetWeight = input.nextInt();
        System.out.println("Enter the number of weights available");
        int numWeights = input.nextInt();
        System.out.println("Enter the number of values of the weights");
        int weightsList[] = new int[numWeights];
        for(int count = 0;count < numWeights;count++){
            weightsList[count] = input.nextInt();
        }
        boolean used[] = new boolean[numWeights];
        boolean possible[] = {false};
        reachTarget(targetWeight,weightsList,0, "",possible);
        if(possible[0])
            System.out.println(" ... are the possible weights");
        else
            System.out.println("There is no possible combination");
    }
    public static void reachTarget(int target, int weights[], int index, String used, boolean possible[]){
        if(target <0) {
            return;
        }
        if(target == 0){
            possible[0] = true;
            System.out.println(used);
            return;
        }
        else if(index == weights.length){
            return;
        }
        reachTarget(target,weights,index+1,used,possible);
        reachTarget(target-weights[index],weights,index+1,used + " " +  weights[index],possible);

    }
}