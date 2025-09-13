#include <stdio.h>
#include <stdbool.h>

bool isFim (char *s) {
    if (s[0] == 'F' && s[1] == 'I' && s[2] == 'F' && s[3] == '\0') return true;

    return false;
}

int somaDigitosRecursivo(int n) {

    if (n == 0) {
        return 0;
    }

    return (n % 10) + somaDigitosRecursivo(n / 10);
}


int main() {

    char *numero = (char *)malloc(256*sizeof(char));
    while(scanf(" %255[^\n]", numero) != EOF && !isFim(numero)) {

        int n = 0;
        for (int i = 0; numero[i] != '\0'; i++) { 
            n = n * 10 + (numero[i] - '0');
        }

        int result = somaDigitosRecursivo(n);
        printf("%d\n", result);

    }

    free(numero);
    

    return 0;
}