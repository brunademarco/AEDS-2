import java.util.Scanner;

class SequenciaEspelho {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int inicio = sc.nextInt();
            int fim = sc.nextInt();

            for (int i = inicio; i <= fim; i++) {
                System.out.print(i);
            }

            for (int j = fim; j >= inicio; j--) {
                int num = j;
                while (num > 0) {
                    System.out.print(num % 10);
                    num /= 10;
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
