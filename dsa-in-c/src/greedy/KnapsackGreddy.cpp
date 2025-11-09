#include <conio.h>
#include <stdio.h>
float knapsack(int w[], int v[], int n, int max_limit);
void sort(float *p, int *v, int *w, int n);
void swap(float *a, float *b);
int min(int a, int b);
float f[100] = {0};
int main() {
  int x, n, i;
  float ans;
  printf("Enter number of weights = ");
  scanf("%d", &n);
  printf("\nEnter bag capacity = ");
  scanf("%d", &x);
  int w[n + 1], v[n + 1];
  printf("\nEnter %d weights\n\n", n);
  for (i = 1; i <= n; i++) scanf("%d", &w[i]);
  printf("\nEnter values of %d weights\n\n", n);
  for (i = 1; i <= n; i++) scanf("%d", &v[i]);
  ans = knapsack(w, v, n, x);
  printf("\nMaximum value = %f", ans);
  printf("\nArray of weight fraction\n\n\t");
  for (i = 1; i <= n; i++) printf("%0.2f ", f[i]);
  return 0;
}
float knapsack(int w[], int v[], int n, int max_limit) {
  int i, current = 0, a;
  float p[n], val = 0;
  for (i = 1; i <= n; i++) p[i] = (float)v[i] / w[i];
  sort(p, v, w, n);
  for (i = 1; i <= n && current < max_limit; i++) {
    a = min(w[i], max_limit - current);
    f[i] = (a == w[i] ? 1 : (float)(max_limit - current) / w[i]);
    current += a;
    val += f[i] * v[i];
  }
  return val;
}
void sort(float *p, int *v, int *w, int n) {
  int i, j;
  for (i = 1; i < n; i++) {
    for (j = i + 1; j <= n; j++) {
      if (p[j] > p[i]) {
        swap(&p[i], &p[j]);
        swap(&v[i], &v[j]);
        swap(&w[i], &w[j]);
      }
    }
  }
}
void swap(float *a, float *b) {
  float temp = *a;
  *a = *b;
  *b = temp;
}
int min(int a, int b) { return (a < b ? a : b); }
