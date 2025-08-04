import java.util.Scanner;

public class recursivo {
    
    public static boolean is_maiuscula(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    public static int conta_maiuscula_recursiva(String str, int i) {

        if (i >= str.length()) {
            return 0;
        }

        if (is_maiuscula(str.charAt(i))) {
            return 1 + conta_maiuscula_recursiva(str, i + 1);
        } else {
            return conta_maiuscula_recursiva(str, i + 1);
        }
    }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        System.out.print("Digite uma string (ou 'FIM' para sair): ");
        str = scanner.nextLine();

        while (!str.equals("FIM")) {
            int total = conta_maiuscula_recursiva(str, 0);
            System.out.println("\nTotal de letras maiúsculas: " + total);

            System.out.print("Digite uma nova string (ou 'FIM' para sair): ");
            str = scanner.nextLine();
        }

        scanner.close();
    }
}
