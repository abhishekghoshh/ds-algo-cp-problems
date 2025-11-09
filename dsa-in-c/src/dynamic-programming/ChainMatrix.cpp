#include <conio.h>
#include <limits.h>
#include <stdio.h>
int chain_matrix(int n, int arr[]);
int main() {
  int n, i, ans;
  printf("Enter number of matrix\n\n");
  scanf("%d", &n);
  int arr[n + 1];
  printf("Enter the orders of %d matrix (%d numbers)\n\n", n, n + 1);
  for (i = 0; i <= n; i++) scanf("%d", &arr[i]);
  ans = chain_matrix(n, arr);
  printf("\nMinimum cost = %d", ans);
  return 0;
}
int chain_matrix(int n, int arr[]) {
  int i, j, k, m[n + 1][n + 1], temp, x;
  for (i = 1; i <= n; i++) m[i][i] = 0;
  for (x = 2; x <= n; x++) {
    for (i = 1; i <= n - x + 1; i++) {
      j = i + x - 1;
      m[i][j] = INT_MAX;
      for (k = i; k < j; k++) {
        temp = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[j] * arr[k];
        if (temp < m[i][j]) m[i][j] = temp;
      }
    }
  }
  return m[1][n];
}
