#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
int main(){
    int row =3,column=4;
    int i =0,j=0;
    int count =0;

    //array of pointer 
    int *arr[row];
    for (i=0; i<row; i++){
         arr[i] = (int *)malloc(column * sizeof(int)); 
    }

    //pointer of pointer
    int **arr = (int **)malloc(row * sizeof(int *)); 
    for (i=0; i<row; i++){
         arr[i] = (int *)malloc(column * sizeof(int)); 
    } 

    //accessing the element 
    count = 0; 
    for (i = 0; i <  row; i++){
        for (j = 0; j < column; j++){
            arr[i][j] = ++count; // Or *(*(arr+i)+j) = ++count 
        }
    }
      
  
    for (i = 0; i <  row; i++){
        for (j = 0; j < column; j++){
            printf("%d ", arr[i][j]); 
        }
    } 
         
}