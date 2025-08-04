#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool is_maiuscula(char c) {
    if (c >= 'A' && c <= 'Z') {
        return true;
    }
    return false;
}

int conta_maiusculas(char *str) {
    int count = 0;
    for (int i = 0; str[i] != '\0'; i++) {
        if (is_maiuscula(str[i])) {
            count++;
        }
    }
    return count;
}

int main() {
    char str[100];

    FILE *entrada = fopen("pub.in.txt", "w");
    FILE *saida = fopen("pub.out.txt", "w");

    if(entrada == NULL) {
        printf("ERRO AO ABRIR ARQUVO\n");
        return 1;
    }

    printf("Digite uma string (ou 'FIM' para sair): ");
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = 0;

    while (strcmp(str, "FIM") != 0) {
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = 0;
        fprintf(entrada, str);
        fprintf(entrada, "\n");

        int total = conta_maiusculas(str);
        printf("\nTotal de letras maiusculas: %d\n", total);
        fprintf(saida, "total de letras maisuculas: %d\n", total);
    }

    fclose(entrada);
    fclose(saida);

    return 0;
}