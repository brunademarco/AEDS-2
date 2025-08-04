#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool is_maiuscula_recursivo(char c) {
    return (c >= 'A' && c <= 'Z');
}

int conta_maiuscula_recursivo(char *str) {

    if (*str == '\0') {
        return 0;
    }

    return is_maiuscula_recursivo(*str) + conta_maiuscula_recursivo(str + 1);
}

int main() {

    char str[100];
    printf("Digite uma string (ou 'FIM' para sair): ");
    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = 0;

    while (strcmp(str, "FIM") != 0) {

        int total = conta_maiuscula_recursivo(str);
        printf("\nTotal de letras maiusculas: %d\n", total);

        printf("Digite uma nova string (ou 'FIM' para sair): ");
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = 0;
    }

    return 0;
}