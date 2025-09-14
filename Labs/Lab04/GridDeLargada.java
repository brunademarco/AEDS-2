import java.util.Scanner;

public class GridDeLargada {
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {

            int N = sc.nextInt();

            int ordemLargada[] = new int[N];
            int ordemChegada[] = new int[N];
            int posChegada[] = new int[N + 1];

            int ultrapassagens = 0;

            //O(N)
            for (int i = 0; i < N; i++) ordemLargada[i] = sc.nextInt();
            for (int i = 0; i < N; i++) ordemChegada[i] = sc.nextInt();
            
            //O(N)
            for (int i = 0; i < N; i++) {
                posChegada[ordemChegada[i]] = i + 1;
            };

            //for duplo O(N²)
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    //O(1) comparacoes
                    if (posChegada[ordemLargada[i]] > posChegada[ordemLargada[j]]) {
                        ultrapassagens++;
                    }
            }

        }

        System.out.println(ultrapassagens);
    }

        sc.close();
    }
}
