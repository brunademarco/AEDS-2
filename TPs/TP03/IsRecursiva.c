#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isFim (char *s) {
    if (s[0] == 'F' && s[1] == 'I' && s[2] == 'M' && s[3] == '\0') return true;

    return false;
}

bool isVogal (char c) {
    return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' 
    || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
}

bool soVogais(char str[], int i) {

    if (str[i] == '\0') return i > 0;

    if (!isVogal(str[i])) return false;

    return soVogais(str, i + 1);
}   

bool soConsoantes(char str[], int i) {

    if (str[i] == '\0') return i > 0;

    if (isVogal(str[i])) return false;

    return soConsoantes(str, i + 1);
}

bool soInteiros(char str[], int i) {

    if (str[i] == '\0') return i > 0;

    if (str[i] < '0' || str[i] > '9') return false;

    return soInteiros(str, i + 1);
}

bool soReais(char str[], int i, int pontos) {

    if (str[i] == '\0') return (pontos == 1);

    if (str[i] == '.') {
        if (pontos == 1) return false;

        return soReais(str, i + 1, pontos + 1);
    } 

    if (str[i] < '0' || str[i] > '9') return false;

    return soReais(str, i + 1, pontos); 
}


int main(void){
    char *str = malloc(256);
    if (!str) return 1;

    while (scanf(" %255[^\n]", str) != EOF && !isFim(str)){
        bool vogal     = soVogais(str, 0);
        bool consoante = soConsoantes(str, 0);
        bool inteiro   = soInteiros(str, 0);
        bool real      = soReais(str, 0, 0);

        if (vogal) {
            printf("SIM ");
        } else {
            printf("NAO ");
        }

        if (consoante) {
            printf("SIM ");
        } else {
            printf("NAO ");
        }

        if (inteiro) {
            printf("SIM ");
        } else {
            printf("NAO ");
        }      

        if (real) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

    }

    free(str);
    return 0;
}