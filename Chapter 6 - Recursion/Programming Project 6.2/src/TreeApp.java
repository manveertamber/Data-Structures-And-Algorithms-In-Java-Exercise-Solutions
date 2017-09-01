public class TreeApp {
    public static void main(String args[]){
        startDrawing(7);
    }

    public static void drawBranch(char sym[][],int linenumber,int lines, int start, int end){
        if(start>end || linenumber > lines-1){
            return;
        }
        int change = (start+end)/2;
        sym[linenumber][change] = 'X';
        drawBranch(sym,linenumber+1,lines,start,change);
        drawBranch(sym,linenumber+1,lines,change,end);
    }

    public static void startDrawing(int lines){
        int size = (int)Math.pow(2,lines-1);
        char screen[][] = new char[lines][size];
        for(int count = 0;count < screen.length;count++){
            for(int count1 = 0;count1 < screen[count].length;count1++){
                screen[count][count1] = '-';
            }
        }
        drawBranch(screen,0,lines,0,screen[0].length);
        display(screen);
    }

    public static void display(char arr[][]){
        for(int count = 0;count < arr.length;count++){
            for(int count1 = 0;count1 < arr[count].length;count1++){
                System.out.print(arr[count][count1] + " ");
            }
            System.out.println();
        }
    }

}


