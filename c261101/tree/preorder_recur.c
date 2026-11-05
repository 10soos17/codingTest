#include <stdio.h>

struct Node {
    int value;
    struct Node *L, *R;
};

int CNT = 0;

void PRE(struct Node *N) {
    if (!N) return;

    if (++CNT == 3) {
        printf("%d\n", N->value);
        return;
    }
    PRE(N->L);
    PRE(N->R);
}

void PRE_PRINT(struct Node *N) {
    printf("SS__node:%d, cnt:%d\n", N->value, CNT);
    //printf("pointer: %p\n", (void*)&N);
     //printf("pointer: %p\n", (void*)&N->value);
     // printf("pointer: %p\n", (void*)&N->L);
     // printf("pointer: %p\n", (void*)&N->R);
    if (!N) return;
    //if (++CNT == 3) {
        //printf("%d", N->value);
        //return;
        //}
    printf("CC__node:%d, cnt:%d\n", N->value, CNT);
    //++CNT;
    printf("LL__node:%d, cnt:%d\n", N->value, CNT);
    PRE(N->L);
    printf("RR__node:%d, cnt:%d\n", N->value, CNT);
    PRE(N->R);
    printf("EE__node:%d, cnt:%d\n", N->value, CNT);
}

int main() {
    struct Node N5 = {5, 0, 0};
    struct Node N4 = {4, 0, 0};
    struct Node N3 = {3, 0, 0};
    struct Node N2 = {2, &N4, &N5};
    struct Node N1 = {1, &N2, &N3};

    //PRE(&N1);
    PRE_PRINT(&N1);
    return 0;
}
