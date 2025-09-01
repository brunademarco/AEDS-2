#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isMaiuscula (char c) {
    return (c >= 'A' && c <= 'Z');
}

bool isVogal (char str[]) {

    int size = strlen(str) - 1;

    for (int i = 0; i < size; i++) {
        if (!isMaiuscula(str[i])) {
            if (str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U') return true;
        } else {
            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') return true;
        }
    }

    return false;
}

bool isConsoante (char str[]) {

    int size = strlen(str) - 1;

    for (int i = 0; i < size; i++) {
        if (!isMaiuscula(str[i])) {
            if (str[i] != 'A' || str[i] != 'E' || str[i] != 'I' || str[i] != 'O' || str[i] != 'U') return true;
        } else {
            if (str[i] != 'a' || str[i] != 'e' || str[i] != 'i' || str[i] != 'o' || str[i] != 'u') return true;
        }
    }

    return false;
}

bool isInteiro (char str[]) {

    int size = strlen(str) - 1;

    for (int i = 0; i < size; i++) {
        if (str[i] < '0' && str[i] > '9') return false;
    }

    return true;
}

bool isDouble (char str[]) {

    
}

int main(void) {


    return 0;
}