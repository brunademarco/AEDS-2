import java.util.Date;

class Geracao {
    protected int[] array;
    protected int n;
    protected long contComp;
    protected long contMov;


    public Geracao() {
        array = new int[100];
        n = array.length;
    }

    public Geracao(int tamanho) {
        array = new int[tamanho];
        n = array.length;
    }

    public void crescente() {
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void decrescente() {
        for (int i = 0; i < n; i++) {
            array[i] = n - 1 - i;
        }
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(" (" + i + ")" + array[i]);
        }
        System.out.println("]");
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public long now() {
        return new Date().getTime();
    }

    public boolean isOrdenado() {
        boolean resp = true;
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i - 1]) {
                resp = false;
                break;
            }
        }
        return resp;
    }

    public void sort() {
        System.out.println("Método a ser implementado nas subclasses.");
    }
}
