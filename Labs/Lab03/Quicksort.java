/**
 * Algoritmo de ordenacao Quicksort
 * @author Max do Val Machado
 * @version 3 08/2020
 */
class Quicksort extends Geracao {


	/**
	 * Construtor.
	 */
   public Quicksort(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Quicksort(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Quicksort.
	 */
   @Override
   public void sort() {
      
      contComp = 0;
      contMov  = 0;

      quicksort(0, n-1);

      System.out.println(contMov);  
      System.out.println(contComp);
   }

	/**
	 * Algoritmo de ordenacao Quicksort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
	 */
    private void quicksort(int esq, int dir) {
         contComp = 0L;
         contMov  = 0L;
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i] < pivo) {
               i++;
               contComp++;
            }
            while (array[j] > pivo) {
               j--;
               contComp++;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
                contMov++;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
}