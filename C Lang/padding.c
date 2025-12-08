#include <stdio.h>

struct NoPadding {
    int a;      // 4 bytes
    int b;      // 4 bytes
};

struct WithPadding {
    char c;     // 1 byte
    int i;      // 4 bytes
};

struct Reordered {
    char c1;    // 1 byte
    char c2;    // 1 byte
    int i;      // 4 bytes
};

int main() {
    printf("Size of NoPadding (4+4): %lu\n", sizeof(struct NoPadding));
    printf("Size of WithPadding (1+4): %lu\n", sizeof(struct WithPadding));
    printf("Size of Reordered (1+1+4): %lu\n", sizeof(struct Reordered));
    return 0;
}