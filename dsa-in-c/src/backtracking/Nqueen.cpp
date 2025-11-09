#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

bool place(int *x, int k, int i) {
  for (int j = 1; j <= k - 1; j++) {
    if ((x[j] == i) || abs(x[j] - i) == abs(j - k)) return false;
  }
  return true;
}
void Nqueen(int *x, int k) {
  for (int i = 1; i <= 8; i++) {
    if (place(x, k, i)) {
      x[k] = i;
      if (k == 8) {
        printf("placing is done \n");
        for (int i = 1; i <= 8; i++) {
          printf("  %d  ", x[i]);
        }
        printf("\n\n");
        for (int m = 1; m <= 8; m++) {
          for (int n = 1; n <= 8; n++) {
            if (x[m] == n)
              printf("  Q  ");
            else
              printf("  *  ");
          }
          printf("\n\n");
        }
        //	exit(0);
      } else
        Nqueen(x, k + 1);
    }
  }
}
int main() {
  int x[9], m;
  Nqueen(x, 1);

  return 0;
}
