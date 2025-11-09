#include <conio.h>
#include <limits.h>
#include <stdio.h>
void apsp();
int min(int a, int b);
int graph[100][100], n, e, d[100][100][100];
int main() {
  int x, y, i, j, start, w;
  printf("Enter number of vertices and edges = ");
  scanf("%d %d", &n, &e);
  int visited[100] = {0}, r[n + 1];
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) graph[i][j] = (i == j ? 0 : INT_MAX);
  }
  printf("\nEnter start and end vertices and weight of %d edges--->\n\n", e);
  for (i = 1; i <= e; i++) {
    scanf("%d %d %d", &x, &y, &w);
    graph[x][y] = graph[y][x] = w;
  }
  apsp();
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) {
      printf("\nShortest path between %d and %d vertices =%d", i, j,
             d[i][j][n]);
    }
  }
  return 0;
}
void apsp() {
  int i, j, k;
  for (i = 1; i <= n; i++) {
    for (j = i; j <= n; j++) d[i][j][0] = d[j][i][0] = graph[i][j];
  }
  for (k = 1; k <= n; k++) {
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= n; j++) {
        if (d[i][k][k - 1] == INT_MAX || d[j][k][k - 1] == INT_MAX)
          d[i][j][k] = d[i][j][k - 1];
        else
          d[i][j][k] = min(d[i][j][k - 1], d[i][k][k - 1] + d[k][j][k - 1]);
      }
    }
  }
}
int min(int a, int b) { return (a < b ? a : b); }
