#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *combinador(const char *str1, const char *str2) {
    size_t tam1 = strlen(str1), tam2 = strlen(str2);
    size_t tam  = tam1 + tam2;

    char *newString = (char *)malloc(tam + 1); 
    if (!newString) return NULL;

    size_t i = 0, j = 0, k = 0;
    while (i < tam1 || j < tam2) {
        if (i < tam1) newString[k++] = str1[i++];
        if (j < tam2) newString[k++] = str2[j++];
    }

    newString[k] = '\0';
    return newString;
}

int main() {
    char str1[100], str2[100];

    while (scanf("%s %s", str1, str2) == 2) {

        char *result = combinador(str1, str2);
        if (!result) return 1;

        printf("%s\n", result);
        free(result);

    };

    return 0;
}
