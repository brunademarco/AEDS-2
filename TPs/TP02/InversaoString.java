
import java.util.Scanner;

public class InversaoString {
    
    // Método para verificar condição de parada da leitura
    public static boolean isFIM(String s) {
        return s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }

    public static String inverteString(String str){
        String novaString = "";
        for(int i = str.length() - 1; i>= 0; i--){
            novaString += str.charAt(i);
        }
        return novaString;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        while(input.hasNextLine()){
            if(!isFIM(str)){
                String invertido = inverteString(str);
                System.out.println(invertido);
                str = input.nextLine();
            }   
        }

        input.close();
    }
}
