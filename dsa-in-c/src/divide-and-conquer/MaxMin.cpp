#include <conio.h>
#include <limits.h>
#include <stdio.h>
void min_max(int start, int end);
int a[100], min, max, i = 0;

int main() {
  int i, n;
  printf("Enter number of elements in array\n\n");
  scanf("%d", &n);
  printf("Enter %d numbers\n\n", n);
  for (i = 0; i < n; i++) scanf("%d", &a[i]);
  min_max(0, n - 1);
  printf("\n\nMaximum element = %d\nMinimum element = %d", max, min);
  return 0;
}

void min_max(int start, int end) {
  if (start == end) {
    min = a[start];
    max = a[start];
  } else if (start == end - 1) {
    if (a[start] < a[end]) {
      min = a[start];
      max = a[end];
    } else {
      min = a[end];
      max = a[start];
    }
  } else {
    int mid = (start + end) / 2;

    min_max(start, mid);

    int temp_max = max;
    int temp_min = min;

    min_max(mid + 1, end);

    if (temp_max > max) max = temp_max;

    if (temp_min < min) min = temp_min;
  }
}
