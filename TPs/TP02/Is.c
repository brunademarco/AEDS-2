#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isFim (char *s) {
    if (s[0] == 'F' && s[1] == 'I' && s[2] == 'M' && s[3] == '\0') return true;

    return false;
}

bool isMaiuscula (char c) {
    return (c >= 'A' && c <= 'Z');
}

bool isVogal (char c) {
    return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' 
    || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
}

bool isConsoante(char c) {
    return (!isVogal(c));
}

bool isInteiro (char str[]) {

    int size = strlen(str);
    for (int i = 0; i < size; i++) {
        if (str[i] < '0' || str[i] > '9') return false;
    }

    return true;
}

bool isReal (char str[]) {

    int size = strlen(str);
    int ponto = 0;

    int i = 0;
    while (str[i] != '\0') {
        if (str[i] == '.') {
            ponto++;
            if (ponto > 1) {
                return false;  
            }
        } else if (str[i] < '0' || str[i] > '9') {
            return false; 
        }
        i++;
    }
    return ponto == 1;
}

int main(void) {

    char *str = (char *)malloc(256*sizeof(char));
    int count = 0;

    int size = strlen(str);
    bool vogal = false;
    bool consoante = false;
    bool inteiro = false; 
    bool real = false;

    while(scanf(" %255[^\n]", str) != EOF && !isFim(str)) {

    for (int i = 0; i < size; i++) {

        if (isVogal(str[i])) {
            vogal = true;
        };
        
        if (!isConsoante(str[i])) {
            consoante = true;
        }
    
        if(isInteiro(str[i])) {
            inteiro = true;
        }

        if(isReal(str[i])) {
            real = true;
        }

        printf("\n");

        scanf(" %255[^\n]", str);
    }

    if(vogal == true) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    if (consoante == true) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    if (inteiro == true) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    if (inteiro == true) {
        printf("SIM ");
    } else {
        printf("NAO ");
    }

    printf("\n");

    }

    free(str);
    return 0;
}


