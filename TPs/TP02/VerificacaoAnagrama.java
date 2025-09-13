import java.util.Scanner;

public class VerificacaoAnagrama {

    public static boolean isFIM(String s) {
        return s.charAt(0)=='F' && s.charAt(1)=='I' && s.charAt(2)=='M';
    }

    public static String toLower(String str) {

        char array[] = str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 32;
            }
        }

        String toLowerStr = new String(array);

        return toLowerStr;
    }

    public static String selectionSort(String str) {

        char array[] = str.toCharArray();

        for (int i = 0; i < (array.length - 1); i++) {
			int menor = i;
			for (int j = (i + 1); j < array.length; j++){
				if (array[menor] > array[j]){
					menor = j;
				}
			}
        
			char temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
		} 

        String sortedStr = new String(array);

        return sortedStr;
    }

    public static boolean isAnagrama(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        String sortedStr1 = selectionSort(str1);
        String sortedStr2 = selectionSort(str2);

        for (int i = 0; i < str1.length(); i++) {
            if (sortedStr1.charAt(i) != sortedStr2.charAt(i)) return false;
        }

        return true;
    }

    public static int isHifen(String str1) {

        int pos = -1;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '-') 
            pos = i;
        }

        return pos;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        while (!isFIM(str)) {

            int pos = isHifen(str);

            String str2 = "";
            String str3 = "";

            for (int i = 0; i < pos; i++) {
                str2 += str.charAt(i);
            }
            String newStr = toLower(str2);

            for (int i = pos + 1; i < str.length(); i++) {
                str3 += str.charAt(i);
            }
            String newStr2 = toLower(str3);

            if (isAnagrama(newStr, newStr2)) {
                System.out.println("SIM");
            } else {
                System.out.println("N\u00C3O");
            }
            
            str = sc.nextLine();
        }

        sc.close();
    }
}
