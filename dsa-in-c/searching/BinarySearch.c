#include <stdio.h>
// #include<conio.h>
#include <stdlib.h>
struct array{
    int *items;
    int length;
};
int getRandomElement(int length){
    return rand() % (length * length);
}
void swap(int *first, int *second){
    int temp = *first;
    *first = *second;
    *second = temp;
}
void sortAscend(int *array, int count){
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - 1 - i; j++) {
            if (array[j] > array[j + 1]){
                swap(array + j, array + (j + 1));
            }
        }
    }
}
struct array initialize(int count){
    struct array array_;
    int *items = (int *)malloc(count * sizeof(int *));
    array_.items = items;
    array_.length = count;
    for (int i = 0; i < count; i++){
        items[i] = getRandomElement(i + 1);
    }
    return array_;
}
struct array getSortedArray(int count){
    struct array array_ = initialize(count);
    sortAscend(array_.items, array_.length);
    return array_;
}
void print(struct array *array_){
    printf("The items are : ");
    for (int i = 0; i < array_->length; i++){
        printf("%d ", array_->items[i]);
    }
    printf("\n");
}
int binarySearch(int *array_, int beg, int end, int item){
    int mid;
    if (end >= beg){
        mid = (beg + end) / 2;
        if (array_[mid] == item){
            return mid;
        }else if (array_[mid] < item){
            return binarySearch(array_, mid + 1, end, item);
        }else{
            return binarySearch(array_, beg, mid - 1, item);
        }
    }
    return -1;
}
void search(struct array *array_, int key){
    int index = binarySearch(array_->items,0,array_->length-1,key);
    if(-1 != index){
        printf("item %d is found at index : %d",key,index);
    }else{
        printf("item %d is not found at",key);
    }
}

int main()
{
    int count = 10;
    int key = 24;
    struct array array_ = getSortedArray(count);
    print(&array_);
    search(&array_, key);
    return 0;
}