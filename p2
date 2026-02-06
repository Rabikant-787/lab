#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char* ltrim(char*);
char* rtrim(char*);
char** split_string(char*);

int parse_int(char*);

/*
 * Complete the 'migratoryBirds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

int migratoryBirds(int arr_count, int* arr) {
    int freq[6] = {0};   // bird types 1 to 5

    for (int i = 0; i < arr_count; i++) {
        freq[arr[i]]++;
    }

    int maxCount = 0;
    int result = 1;

    for (int i = 1; i <= 5; i++) {
        if (freq[i] > maxCount) {
            maxCount = freq[i];
            result = i;
        }
    }

    return result;
}

int main() {
    int arr_count = parse_int(ltrim(rtrim(readline())));

    char** arr_temp = split_string(rtrim(readline()));

    int* arr = malloc(arr_count * sizeof(int));

    for (int i = 0; i < arr_count; i++) {
        arr[i] = parse_int(arr_temp[i]);
    }

    int result = migratoryBirds(arr_count, arr);

    printf("%d\n", result);

    return 0;
}

/* ------------------ Helper Functions ------------------ */

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) break;

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n')
            break;

        alloc_length <<= 1;
        data = realloc(data, alloc_length);
    }

    if (data[data_length - 1] == '\n')
        data[data_length - 1] = '\0';

    return data;
}

char* ltrim(char* str) {
    if (!str) return NULL;

    while (*str && isspace(*str))
        str++;

    return str;
}

char* rtrim(char* str) {
    if (!str) return NULL;

    char* end = str + strlen(str) - 1;

    while (end >= str && isspace(*end))
        end--;

    *(end + 1) = '\0';

    return str;
}

char** split_string(char* str) {
    char** splits = NULL;
    char* token = strtok(str, " ");
    int count = 0;

    while (token) {
        splits = realloc(splits, sizeof(char*) * ++count);
        splits[count - 1] = token;
        token = strtok(NULL, " ");
    }

    return splits;
}

int parse_int(char* str) {
    char* endptr;
    int value = strtol(str, &endptr, 10);

    if (endptr == str || *endptr != '\0') {
        exit(EXIT_FAILURE);
    }

    return value;
}
