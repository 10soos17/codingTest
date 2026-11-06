#include <stdio.h>
#define MAX 100

struct Node *STACK[MAX];
int TOP = -1;

struct Node {
    int value;
    struct Node *L, *R;
};
void push(struct Node *node) {
    if (TOP < MAX - 1) {
        STACK[++TOP] = node;
    } else {
        printf("스택이 가득 찼습니다.\n");
    }
}
struct Node *pop() {
    if (TOP >= 0) {
        return STACK[TOP--];
    }
    return NULL;
}
struct Node *peek() {
    if (TOP >= 0) {
        return STACK[TOP];
    }
    return NULL;
}
//printf("8바이트 이동 후 주소: %p\n", (void *)offsetNode);
//void *ptr = (void *)0x00000021229FFB80ULL;
void POST(struct Node *N) {
    struct Node *P = N;
    push(N);
    while(N) {
        N = peek();
        N = N->L;
        if(N == 0) {
            N = pop();
            printf("node:%d\n", N->value);
            P = pop();
            int check =  N->value == P->R->value;
            while(check){
                printf("root_Node:%d\n", P->value);
                N = P;
                P = pop();
                if(!P) {
                    printf("exit_Node:%d\n", N->value);
                    return;
                };
                check =  N->value == P->R->value;
            }
            push(P);
            N = P->R;
        }
        push(N);
    };
     //printf("exitnode:%d\n", N->value);
}
int main(void) {
    struct Node N23 = {23, 0, 0};
    struct Node N22 = {22, 0, 0};
    struct Node N21 = {21, 0, 0};
    struct Node N20 = {20, &N22, &N23};
    struct Node N19 = {19, 0, 0};
    struct Node N18 = {18, &N20, &N21};
    struct Node N17 = {17, 0, 0};
    struct Node N16 = {16, &N18, &N19};
    struct Node N15 = {15, &N16, &N17};
    struct Node N14 = {14, 0, 0};
    struct Node N13 = {13, 0, 0};
    struct Node N12 = {12, &N14, &N15};
    struct Node N11 = {11, 0, 0};
    struct Node N10 = {10, 0, 0};
    struct Node N9 = {9, &N12, &N13};
    struct Node N8 = {8, 0, 0};
    struct Node N7 = {7, &N10, &N11};
    struct Node N6 = {6, 0, 0};
    struct Node N5 = {5, 0, 0};
    struct Node N4 = {4, &N8, &N9};
    struct Node N3 = {3, &N6, &N7};
    struct Node N2 = {2, &N4, &N5};
    struct Node N1 = {1, &N2, &N3};
    
    POST(&N1);
};