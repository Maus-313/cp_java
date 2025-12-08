#include <stdio.h>

int main() {
    int arr[] = {10, 20, 30};
    int *p = arr; // p points to 10 (index 0)

    // Case 1
    int a = *p++; 
    // Logic: Use the value at p (10), THEN move p to the next index.
    
    printf("After *p++: a = %d, Current *p = %d\n", a, *p);

    // Reset
    p = arr; 

    // Case 2
    int b = *++p; 
    // Logic: Move p to the next index FIRST, then use that value.

    printf("After *++p: b = %d\n", b);

    // Case 3
    int c = ++*p; 
    // Logic: Look at the value at p, increment the VALUE (not the address).
    
    printf("After ++*p: c = %d\n", c);
    
    return 0;
}