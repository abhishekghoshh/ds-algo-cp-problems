#include <conio.h>
#include <limits.h>
#include <stdio.h>
int least(int c);
void mincost(int city);
int a[100][100], visited[100], n, cost = 0;

int main() {
  int i, j;
  printf("Enter No. of Cities: ");
  scanf("%d", &n);
  printf("\nEnter Cost Matrix\n");
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) scanf("%d", &a[i][j]);
    visited[i] = 0;
  }
  printf("\n\nThe Path is:\n\n");
  mincost(0);
  printf("\n\nMinimum cost = %d", cost);
  return 0;
}

void mincost(int city) {
  int i, ncity;
  visited[city] = 1;
  printf("%d -->", city + 1);
  ncity = least(city);
  if (ncity == INT_MAX) {
    ncity = 0;
    printf("%d", ncity + 1);
    cost += a[city][ncity];
    return;
  }
  mincost(ncity);
}
int least(int c) {
  int i, nc = INT_MAX;
  int min = INT_MAX, kmin;
  for (i = 0; i < n; i++) {
    if ((a[c][i] != 0) && (visited[i] == 0))
      if (a[c][i] < min) {
        min = a[i][0] + a[c][i];
        kmin = a[c][i];
        nc = i;
      }
  }
  if (min != INT_MAX) cost += kmin;
  return nc;
}
