import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.reflect.Field;

class Principal {

    // Lê contadores contComp/contMov herdados de Geracao via reflection
    private static long[] lerContadoresViaReflection(Geracao alg) {
        long comp = -1L, mov = -1L;
        try {
            // contadores estão declarados em Geracao (superclasse)
            Class<?> sup = alg.getClass().getSuperclass();
            Field fComp = sup.getDeclaredField("contComp");
            Field fMov  = sup.getDeclaredField("contMov");
            fComp.setAccessible(true);
            fMov.setAccessible(true);
            Object vComp = fComp.get(alg);
            Object vMov  = fMov.get(alg);
            if (vComp instanceof Long) comp = ((Long) vComp).longValue();
            if (vMov  instanceof Long) mov  = ((Long)  vMov).longValue();
        } catch (Exception ignore) {
            // Se não existir/for inacessível, mantém -1 (sem contagem)
        }
        return new long[]{comp, mov};
    }

    public static void main(String[] args) throws Exception {
        // Parâmetros com defaults:
        String algoritmoArg = args.length > 0 ? args[0].toLowerCase() : "all";        // all | insercao | selecao | quicksort
        int n               = args.length > 1 ? Integer.parseInt(args[1]) : 10000;
        String ordem        = args.length > 2 ? args[2].toLowerCase() : "aleatorio";  // aleatorio | crescente | decrescente
        String dist         = args.length > 3 ? args[3].toLowerCase() : "uniforme";   // uniforme | duplicados
        long seed           = args.length > 4 ? Long.parseLong(args[4]) : 42L;
        int reps            = args.length > 5 ? Integer.parseInt(args[5]) : 10;
        int warmups         = args.length > 6 ? Integer.parseInt(args[6]) : 3;
        String outCsv       = args.length > 7 ? args[7] : "resultados.csv";

        PrintWriter pw = new PrintWriter(outCsv);
        pw.println("algoritmo,n,ordem,dist,rep,tempo_ms,comp,mov,ok");

        // Quais algoritmos rodar
        List<String> algs = new ArrayList<>();
        if (algoritmoArg.equals("all")) {
            algs.add("insercao");
            algs.add("selecao");
            algs.add("quicksort");
        } else {
            algs.add(algoritmoArg);
        }

        Random rng = new Random(seed);

        for (int rep = 1; rep <= reps; rep++) {

            // 1) Gera vetor base conforme distribuição
            int[] base = new int[n];
            if (dist.equals("duplicados")) {
                int max = 100; // força muitos valores repetidos
                for (int i = 0; i < n; i++) base[i] = rng.nextInt(max);
            } else {
                // uniforme em [0, n]
                for (int i = 0; i < n; i++) base[i] = rng.nextInt(n + 1);
            }

            // 2) Aplica ordem inicial
            if (ordem.equals("crescente")) {
                Arrays.sort(base);
            } else if (ordem.equals("decrescente")) {
                Arrays.sort(base);
                for (int i = 0, j = n - 1; i < j; i++, j--) {
                    int tmp = base[i]; base[i] = base[j]; base[j] = tmp;
                }
            } // aleatório = deixa como gerado

            // 3) Executa para cada algoritmo
            for (String nomeAlg : algs) {
                Geracao alg;
                if (nomeAlg.equals("insercao"))       alg = new Insercao();
                else if (nomeAlg.equals("selecao"))   alg = new Selecao();
                else if (nomeAlg.equals("quicksort")) alg = new Quicksort();
                else throw new IllegalArgumentException("Algoritmo desconhecido: " + nomeAlg);

                // WARM-UPS (aquecimento do JIT/GC)
                for (int w = 0; w < warmups; w++) {
                    int[] a = base.clone();
                    alg.array = a;  // campos protected em Geracao => acessíveis no mesmo pacote
                    alg.n = n;
                    alg.sort();
                }

                // MEDIÇÃO
                int[] a = base.clone();
                alg.array = a;
                alg.n = n;

                long t0 = System.nanoTime();
                alg.sort();
                long t1 = System.nanoTime();
                double tempoMs = (t1 - t0) / 1_000_000.0;

                // Lê contadores (se existirem)
                long[] cm = lerContadoresViaReflection(alg);
                long comp = cm[0];
                long mov  = cm[1];

                boolean ok = alg.isOrdenado();

                // Grava CSV
                pw.printf("%s,%d,%s,%s,%d,%.3f,%d,%d,%b%n",
                          nomeAlg, n, ordem, dist, rep, tempoMs, comp, mov, ok);
            }
        }

        pw.close();
        System.out.println("OK! Resultados em: " + outCsv);
    }
}
