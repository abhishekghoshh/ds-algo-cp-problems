// #include <conio.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
    const int arr[] = {1, 2, 3, 4, 5};
    // scanf("%d",&arr[i]) and scanf("%d",(arr+i)) both are same
    // similarly *(arr+i) and arr[i] are same
    for (int i = 0; i < 5; i++)
    {
        printf("arr[%d] = %d ", i, arr[i]);
    }
    printf("\n");

    for (int i = 0; i < 5; i++)
    {
        printf("*(arr+%d) = %d ", i, *(arr + i));
    }
    printf("\n");

    // we can dynamically build array with malloc
    //  this way array size can be taken from user
    printf("Dynamically making an array with malloc\n");
    printf("size of the array : ");
    int n;
    scanf("%d", &n);
    int* arr_d = malloc(sizeof(int*));
    for (int i = 0; i < n; i++)
    {
        scanf("%d", (arr_d + i));
    }
    for (int i = 0; i < n; i++)
    {
        printf("*(arr_d+%d) is %d and arr_d[%d] is %d\n", i, *(arr_d + i), i, arr_d[i]);
    }

    return 0;
}
