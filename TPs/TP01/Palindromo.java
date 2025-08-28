
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Palindromo {

    // Método para verificar condição de parada da leitura
    public static boolean isFIM(String s) {
        return s.length() == 3 && s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }


    //Método para verificar se é palindromo
    public static boolean isPalindromo(String palavra) {

        int i = 0, j = palavra.length() - 1;
        while (i < j) {
            if (palavra.charAt(i) != palavra.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            Scanner rc = new Scanner(new InputStreamReader(System.in, "ISO-8859-1"));

            while(rc.hasNext()) {

                String linha = rc.nextLine();

                if (!isFIM(linha)) {
                    if (linha.length() > 0) {
                    if (isPalindromo(linha)) {
                        System.out.println("SIM");
                    } else {
                        System.out.println("NAO");
                    }
                  }
                }   
            }
        
            rc.close();

        } catch (UnsupportedEncodingException e){
            System.err.println("Problema no encoding " + e.getMessage());
        }   
    
    }
}
