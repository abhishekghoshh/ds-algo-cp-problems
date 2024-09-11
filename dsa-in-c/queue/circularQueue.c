#include<stdio.h>
#include<stdlib.h>
// #include<conio.h>
struct queue{
    int *items;
    int front;
    int rear;
    int capacity;
};
void insert(struct queue *queue_,int data){
    if(queue_->front == ((queue_->rear+1)%queue_->capacity)){
        printf("Capacity of the queue is %d ,value %d is rejected ,queue Overflow\n",queue_->capacity,data);  
    }else{
        if(queue_->front ==-1 && queue_->rear ==-1){
            queue_->front =0; 
            queue_->rear = 0;
        }else{
            queue_->rear = ((queue_->rear+1)%queue_->capacity);
        }
        queue_->items[queue_->rear]=data;
    }
}
struct queue create(int capacity){
    struct queue queue_;
    queue_.items = (int*) malloc(capacity*sizeof(int*));
    queue_.capacity=capacity;
    queue_.front=-1;
    queue_.rear=-1;
    return queue_;
}
void print(struct queue queue_){
    printf("Capacity of the queue is %d\n",queue_.capacity);
    printf("Value of front is %d\n",queue_.front);
    printf("Value of rear is %d\n",queue_.rear);
    if(!(queue_.front ==-1 && queue_.rear ==-1)){
        printf("The items in queue are : ");
        if(queue_.rear>queue_.front){
            for(int i = queue_.front;i<=queue_.rear;i++){
                printf("%d ",queue_.items[i]);
            }
        }else{
            for(int i = queue_.front;i<queue_.capacity;i++){
                printf("%d ",queue_.items[i]);
            }
            for(int i = 0;i<=queue_.rear;i++){
                printf("%d ",queue_.items[i]);
            }
        }printf("\n");
    }
}
int deleteOne(struct queue *queue_){
    int value = -999999;
    if(queue_->front==-1){
        printf("Queue underflow\n");
    }else{
        value = queue_->items[queue_->front];
        if(queue_->front==queue_->rear){
            queue_->front = -1;
            queue_->rear = -1;
        }else{
            queue_->front = (queue_->front+1)%queue_->capacity;
        }
    }
    return value;
}
int main(){
    int capacity =10;
    struct queue queue_=create(capacity);
    print(queue_);
    for(int i=0;i<11;i++){
        insert(&queue_,rand()%capacity);
    }
    print(queue_);
    printf("Deleting one element from queue is : %d\n",deleteOne(&queue_));
    print(queue_);
    printf("Inserting one element to the circular queue\n");
    insert(&queue_,rand()%capacity);
    print(queue_);
    printf("Inserting one element to the circular queue\n");
    insert(&queue_,rand()%capacity);
    print(queue_);
    return 0;
}