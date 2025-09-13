#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool isFim (char *s) {
    if (s[0] == 'F' && s[1] == 'I' && s[2] == 'F' && s[3] == '\0') return true;

    return false;
}


bool recursivePalindromo(char *inicio, char *fim) {

    if (inicio >= fim) return true; //caso base

    if (*inicio != *fim) return false; //se for diferente n e palindromo

    return recursivePalindromo(inicio + 1, fim - 1); 
}

bool isPalindromo(char *s) {

    if (*s == '\0') return true;

    char *fim = s;
    while (*fim != 0) fim++;
    if (fim == s) return true;
    fim--;

    return recursivePalindromo(s, fim);
}


int main() {


    char *palavra = (char *)malloc(256*sizeof(char));
    while(scanf(" %255[^\n]", palavra) != EOF && !isFim(palavra)) {
        if (isPalindromo(palavra)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    free(palavra);
    return 0;
}