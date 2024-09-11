#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

int* create(int count){
    int *array = (int*)malloc(count*sizeof(int));
    for(int i=0;i<count;i++){
        array[i] = rand()%count;
    }
    return array;
}
void print(int *array,int count){
    printf("The array is :\n");
    for(int i=0;i<count;i++){
        printf("%d ",array[i]);
    }
    printf("\n");
}
void swap(int *first,int *second){
    int temp=*first;
    *first=*second;
    *second=temp;
}
void sortAscend(int *array,int count){
    for(int i=0;i<count-1;i++){
        for(int j=0;j<count-1-i;j++){
            if(array[j]>array[j+1]){
                swap(array+j,array+(j+1));
            }
        }
    }
}
void sortDescend(int *array,int count){
    for(int i=0;i<count-1;i++){
        for(int j=0;j<count-1-i;j++){
            if(array[j]<array[j+1]){
                swap(array+j,array+(j+1));
            }
        }
    }
}
int main(){
    int *array;
    int count = 20;
    array = create(count);
    print(array,count);
    sortAscend(array,count);
    print(array,count);
    sortDescend(array,count);
    print(array,count);
}