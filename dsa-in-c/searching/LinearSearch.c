#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
struct array{
    int *items;
    int length;
};
int getRandomElement(int length){
    return rand()%(length*length);
}
struct array initialize(int count){
    struct array array_;
    int *items = (int*)malloc(count*sizeof(int*));
    array_.items=items;
    array_.length=count;
    for(int i=0;i<count;i++){
        items[i]=getRandomElement(i+1);
    }
    return array_;
}
void print(struct array *array_){
    printf("The items are : ");
    for(int i=0;i<array_->length;i++){
        printf("%d ",array_->items[i]);
    }printf("\n");
}
void search(struct array *array_,int key){
    int found = 0;
    int index = 0;
    for(int i=0;i<array_->length;i++){
        if(key == array_->items[i] && found == 0){
            found=1;
            index =i;
        }
    }
    if(found){
        printf("item %d is found at index : %d",key,index);
    }else{
        printf("item %d is not found at",key);
    }
}
int main(){
    int count =10;
    int key = 2;
    struct array array_ = initialize(count);
    print(&array_);
    search(&array_,key);
    return 0;
}