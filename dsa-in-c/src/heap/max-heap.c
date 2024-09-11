#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
struct heap{
    int heapSize;
    int *items;
    int length;
};
struct heap create(int length){
    struct heap heap_;
    heap_.items=(int*)malloc(length*sizeof(int*));
    heap_.heapSize=length;
    heap_.length=length;
    for(int i=0;i<length;i++){
        heap_.items[i]=rand()%length;
    }
    return heap_;
}
void swap(int *first ,int *second){
    int temp = *first;
    *first=*second;
    *second=temp;
}
int getParent(int key){
    return (key/2)-1;
}
int getRightChild(int key){
    return 2*key+2;
}
int getLeftChild(int key){
    return 2*key+1;
}

void maxHeapify(struct heap *heap_,int start){
    int left = getLeftChild(start);
    int right = getRightChild(start);
    int largest;
    if(left < heap_->heapSize && heap_->items[left]>heap_->items[start]){
        largest=left;
    }else{
        largest=start;
    }
    if(right < heap_->heapSize && heap_->items[right]>heap_->items[largest]){
        largest=right;
    }
    if(largest!=start){
        swap(&(heap_->items[start]),&(heap_->items[largest]));
        maxHeapify(heap_,largest);
    }
}
void buildHeap(struct heap *heap_){
    int i=((heap_->heapSize)/2)-1;
    while(i>=0){
        maxHeapify(heap_,i);
        i--;
    }
}
int extractMax(struct heap *heap_){
    int max = -99999;
    if(heap_->heapSize>0){
        max=heap_->items[0];
        heap_->items[0]=heap_->items[heap_->heapSize-1];
        heap_->heapSize=heap_->heapSize-1;
        maxHeapify(heap_,0);
    }
    return max;
}
void print(struct heap heap_){
    printf("Items in the heap are : ");
    for(int i=0;i<heap_.heapSize;i++){
        printf("%d ",heap_.items[i]);
    }printf("\n");
}

void increase(struct heap heap_,int key,int value){
    if(key<heap_.heapSize){
        heap_.items[key]=value;
        while(key>0 && heap_.items[key]>heap_.items[getParent(key)]){
            swap(&(heap_.items[key]),&(heap_.items[getParent(key)]));
            key = getParent(key);
        }
    }
}

void decrease(struct heap heap_,int key,int value){
    if(key<heap_.heapSize){
        heap_.items[key]=value;
        while(key<heap_.heapSize && heap_.items[key]<heap_.items[getRightChild(key)]){
            swap(&(heap_.items[key]),&(heap_.items[getRightChild(key)]));
            key = getRightChild(key);
        }
    }
}
void printByLength(struct heap heap_){
    printf("Items in the heap are : ");
    for(int i=0;i<heap_.length;i++){
        printf("%d ",heap_.items[i]);
    }printf("\n");
}
void heapSort(struct heap *heap_){
    buildHeap(heap_);
    printByLength(*heap_);
    for(int i=heap_->heapSize-1;i>=1;i--){
        swap(&(heap_->items[i]),&(heap_->items[0]));
        heap_->heapSize=heap_->heapSize-1;
        maxHeapify(heap_,0);
    }
    printByLength(*heap_);
}

int main(){
    int length=7;   
    struct heap heap_;
    heap_ = create(length);
    print(heap_);
    buildHeap(&heap_);
    print(heap_);
    increase(heap_,6,200);
    print(heap_);
    decrease(heap_,0,4);
    print(heap_);
    printf("Extracting the max element %d\n",extractMax(&heap_));
    print(heap_);
    heap_=create(15);
    print(heap_);
    heapSort(&heap_);
    return 0;
}