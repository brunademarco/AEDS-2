
import java.util.Scanner;

public class CiframentodeCesar {
    
    // Método para verificar condição de parada da leitura
    public static boolean isFIM(String s) {
        return s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }

    
    public static String criptografia(String str){

        int chave = 3;
        String novaString = "";

        

        for(int i = 0; i < str.length(); i++){
            char c = ' ';
            int cInt = (int) str.charAt(i);
            if ((char)(str.charAt(i) + 3) >= 32 && (char)(str.charAt(i)) + 3 <= 126) {
                c = (char) (cInt + chave);
            } else {
                c = (char) cInt;
            }

            novaString += c;

        }

        return novaString;
    }

    public static void main(String args[]) {
    
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        while (in.hasNext()) {
            if (!isFIM(str)) {
              String result = criptografia(str);
              System.out.println(result);
              str = in.nextLine();
            }
        }

        in.close();
        
    }
}
