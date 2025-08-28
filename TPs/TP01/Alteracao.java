
import java.util.*;


public class Alteracao {

    public static boolean isFIM(String s) {
        return s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }

    public static String alteracao(String str, Random gerador){
        String novaString = "";

        
        int intA = 0, intB = 0;

        intA = (int) ('a' + Math.abs(gerador.nextInt()%26));
        intB = (int) ('a' + Math.abs(gerador.nextInt()%26));

        for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == (char) intA) {
                    novaString += (char) intB;
                }else{
                    novaString += str.charAt(i);
                }
            
        }

        return novaString;
    }
    public static void main(String[] args) {

            Random gerador = new Random();
            gerador.setSeed(4);


            Scanner input = new Scanner(System.in);
            String str = input.nextLine();

            while(!isFIM(str)){
                System.out.println(alteracao(str, gerador));
                str = input.nextLine();
            }

        input.close();
    }   
}

