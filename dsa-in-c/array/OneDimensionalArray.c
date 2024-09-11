#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

int main(){
    int arr[]={1,2,3,4,5};
    int n,*arr_d;

    //scanf("%d",&arr[i]) and scanf("%d",(arr+i)) both are same
    printf("scanf(\"%%d\",&arr[i]) and scanf(\"%%d\",(arr+i)) both are same\n");
    //similarly *(arr+i) and arr[i] are same
    printf("similarly *(arr+i) and arr[i] are same\n");

    for(int i=0;i<5;i++){
        printf("arr[%d] = %d ",i,arr[i]);
    }printf("\n");

    for(int i=0;i<5;i++){
        printf("*(arr+%d) = %d ",i,*(arr+i));
    }printf("\n");

    //we can dynamically build array with malloc 
    // this way array size can be taken from user
    printf("Dynamically making an array with malloc\n");
    printf("size of the array : ");
    scanf("%d",&n);
    arr_d = (int*)malloc(sizeof(int*));
    for(int i=0;i<n;i++){
        scanf("%d",(arr_d+i));
    }
    for(int i=0;i<n;i++){
        printf("*(arr_d+%d) is %d and arr_d[%d] is %d\n",i,*(arr_d+i),i,arr_d[i]);
    }

    return 0;
}