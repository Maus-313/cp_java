#include <stdio.h>

void counter() {
    static int count = 0; // Initialized ONLY ONCE
    int normal = 0;       // Initialized EVERY call
    
    count++;
    normal++;
    
    printf("Static: %d, Normal: %d\n", count, normal);
}

int main() {
    counter();
    counter();
    counter();
    return 0;
}