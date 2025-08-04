import java.util.Scanner;

class iterativo {

    public static boolean is_maiscula(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static int conta_maiusculas(String str) {
        int cont = 0;

        for (int i = 0; i < str.length(); i++) {
            if (is_maiscula(str.charAt(i))) {
                cont++;
            }
        }

        return cont;
    }

    public static boolean is_fim(String str) {
        return str.equals("FIM");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase;

        System.out.println("Digite uma frase (ou 'FIM' para sair): ");
        frase = scanner.nextLine();

        while (!is_fim(frase)) {
            int total = conta_maiusculas(frase);
            System.out.println("Total de letras maiúsculas: " + total);

            System.out.println("\nDigite outra frase (ou 'FIM' para sair): ");
            frase = scanner.nextLine();
        }

        scanner.close();
    }
}
