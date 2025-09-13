
import java.util.Scanner;

public class InversaoStringRecursiva {
    
    public static boolean isFIM(String s) {
        return s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }

    public static String inverteRecArr(String s) {
    if (s == null) return null;
    char[] out = new char[s.length()];
    inverterParaArray(s, s.length() - 1, out, 0);
    return new String(out);
    }

    private static void inverterParaArray(String s, int i, char[] out, int j) {
        if (i < 0) return;                 
        out[j] = s.charAt(i);              
        inverterParaArray(s, i - 1, out, j + 1); 
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            
            String linha = sc.nextLine();

            if (!isFIM(linha)) {
                String invertida = inverteRecArr(linha);
                System.out.println(invertida);
            }
        }
        sc.close();
    }
}
