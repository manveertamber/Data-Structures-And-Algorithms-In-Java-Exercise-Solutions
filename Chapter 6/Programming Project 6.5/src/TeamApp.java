public class TeamApp {
    public static void main(String args[]){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        printTeams(5,3,alphabet);
    }


    public static void printTeams(int letters, int choose,String alphabet){
        makeTeams(letters,choose,alphabet.substring(0,letters),"",choose);
    }
    public static void makeTeams(int letters, int choose,String alphabet, String sofar, int ogchoose){
        if(letters == 0|| choose == 0){
            if(sofar.length() == ogchoose)
                System.out.println(sofar);
            return;
        }
        makeTeams(letters-1,choose-1,alphabet,sofar+alphabet.charAt(alphabet.length()-letters),ogchoose);
        makeTeams(letters-1,choose,alphabet,sofar,ogchoose);
    }
}
