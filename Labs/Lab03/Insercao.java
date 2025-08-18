/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 3 01/2020
 */

class Insercao extends Geracao {

	/**
	 * Construtor.
	 */
   public Insercao(){
      super();
   }

	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Insercao(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao por insercao.
	 */
   @Override
   public void sort() {

      contComp = 0L;
      contMov  = 0L;

		for (int i = 1; i < n; i++) {
			int tmp = array[i];
         int j = i - 1;

         while ((j >= 0) && (array[j] > tmp)) {
            contComp++;
            contMov++;
            array[j + 1] = array[j];
            j--;
         }
         contMov++;
         array[j + 1] = tmp;
      }

	}

    public long getContComp() { return contComp; }
    public long getContMov()  { return contMov;  }
}