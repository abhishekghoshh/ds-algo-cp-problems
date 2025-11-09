#include <malloc.h>
#include <stdio.h>
int V;
void printSolution(int color[]);
int isSafe(int v, int graph[V][V], int color[], int c) {
  int i;
  for (i = 0; i < V; i++)
    if (graph[v][i] && c == color[i]) return 0;
  return 1;
}
int graphColoringUtil(int graph[V][V], int m, int color[], int v) {
  int c;
  if (v == V) return 1;
  for (c = 1; c <= m; c++) {
    if (isSafe(v, graph, color, c)) {
      color[v] = c;
      if (graphColoringUtil(graph, m, color, v + 1) == 1) return 1;
      color[v] = 0;
    }
  }
  return 0;
}
int graphColoring(int graph[V][V], int m) {
  int i, *color = (int *)malloc(sizeof(int) * V);
  for (i = 0; i < V; i++) color[i] = 0;
  if (graphColoringUtil(graph, m, color, 0) == 0) {
    printf("Solution does not exist");
    return 0;
  }
  printSolution(color);
  return 1;
}
void printSolution(int color[]) {
  int i;
  printf(
      "Solution Exists:"
      " Following are the assigned colors \n");
  for (i = 0; i < V; i++) printf(" %d ", color[i]);
  printf("\n");
}
int main() {
  int i, j, m;
  printf("Enter number of vertices = ");
  scanf("%d", &V);
  int graph[V][V];
  printf("Enter the adjacency matrix of the graph\n\n");
  for (i = 0; i < V; i++) {
    for (j = 0; j < V; j++) scanf("%d", &graph[i][j]);
  }
  printf("Enter number of colour = ");
  scanf("%d", &m);
  graphColoring(graph, m);
  return 0;
}
