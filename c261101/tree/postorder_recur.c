#include <stdio.h>
 
struct Node {
    int value;
    struct Node *L, *R;
};
 
int CNT = 0;
int ANS = 0;
 
void POST(struct Node *N) {
    if (!N) return;

    POST(N->L);
    POST(N->R);
    if (++CNT== 3) {
        printf("%d\n", N->value);
        return;
    }
}

void POST_PRINT(struct Node *N) {
    printf("SS__node:%d, cnt:%d\n", N->value, CNT);
    //printf("pointer: %p\n", (void*)&N);
     //printf("pointer: %p\n", (void*)&N->value);
     // printf("pointer: %p\n", (void*)&N->L);
     // printf("pointer: %p\n", (void*)&N->R);
     if (!N) return;
     printf("LL__node:%d, cnt:%d\n", N->value, CNT);
     POST(N->L);
     printf("RR__node:%d, cnt:%d\n", N->value, CNT);
     POST(N->R);
     //if (++CNT == 3) {
     //printf("%d", N->value);
     //return;
     //}
     printf("CC__node:%d, cnt:%d\n", N->value, CNT);
     //++CNT;
     printf("EE__node:%d, cnt:%d\n", N->value, CNT);
}
 
int main() {
    struct Node N5 = {5, 0, 0};
    struct Node N4 = {4, 0, 0};
    struct Node N3 = {3, 0, 0};
    struct Node N2 = {2, &N4, &N5};
    struct Node N1 = {1, &N2, &N3};
 
    //POST(&N1);
    POST_PRINT(&N1);
    return 0;
}