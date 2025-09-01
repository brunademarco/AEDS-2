import java.util.Scanner;

public class SortSortSort {

    public static boolean isImpar(int num) {
        return (num % 2 != 0);
    }

    public static boolean comparador(int x, int y, int M) {

        int mod1 = x % M;
        int mod2 = y % M;

        if (mod1 != mod2) {
            return mod1 > mod2;
        }

        boolean paridadeX = isImpar(x);
        boolean paridadeY = isImpar(y);

        if (paridadeX && !paridadeY) {
            return false;
        }

        if (!paridadeX && paridadeY) {
            return true;
        }

        if (paridadeX && paridadeY) {
            return x < y;
        }

        return x > y;  
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int N = 0;
        int M = 0;
        int array[];

        N = sc.nextInt();
        M = sc.nextInt();

        System.out.println(N + " " + M);

        while(N != 0 && M != 0) {
           

            array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            for (int i = 0; i < (N - 1); i++) {
			int menor = i;
			for (int j = (i + 1); j < N; j++){
				if (comparador(array[menor], array[j], M)){
					menor = j;
				}
			}
            
			int temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
		    }      
            
            for (int i = 0; i < N; i++) {
                System.out.println(array[i]);
            }

            N = sc.nextInt();
            M = sc.nextInt();

            System.out.println(N + " " + M);

            
		}
        sc.close();
    }
}


