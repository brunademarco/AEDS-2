
import java.util.Scanner;

public class SomaDigitosRecursiva {

    public static boolean isFIM(String s) {
        return s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }

    public static int somaDigitos(int n) {

        if (n == 0) {
            return 0;
        }

        return (n % 10) + somaDigitos(n / 10);
    }

    public static int somenteDigitos(String s) {

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n = n * 10 + (c - '0'); 
            }
        }
        return n;
    }
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String numero = sc.nextLine();
            if (!isFIM(numero)) {

                int n = somenteDigitos(numero);
                int result = somaDigitos(n);
                System.out.println(result);
            }
        }
        sc.close();
    }
}
