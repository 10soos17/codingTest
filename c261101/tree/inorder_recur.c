#include <stdio.h>
 
struct Node {
    int value;
    struct Node *L, *R;
};
 
int CNT = 0;
int ANS = 0;
 
void INORDER(struct Node *N) {
    if (!N) return;

    INORDER(N->L);
    if (++CNT== 3) {
        printf("%d\n", N->value);
        return;
    }
    INORDER(N->R);
}

void INORDER_PRINT(struct Node *N) {
    printf("SS__node:%d, cnt:%d\n", N->value, CNT);
     if (!N) return;
     printf("LL__node:%d, cnt:%d\n", N->value, CNT);
     INORDER(N->L);
     printf("RR__node:%d, cnt:%d\n", N->value, CNT);
     INORDER(N->R);
     printf("CC__node:%d, cnt:%d\n", N->value, CNT);
     printf("EE__node:%d, cnt:%d\n", N->value, CNT);
}
 
int main() {
    struct Node N5 = {5, 0, 0};
    struct Node N4 = {4, 0, 0};
    struct Node N3 = {3, 0, 0};
    struct Node N2 = {2, &N4, &N5};
    struct Node N1 = {1, &N2, &N3};
 
    INORDER_PRINT(&N1);
    return 0;
}