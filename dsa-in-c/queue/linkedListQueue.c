#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct queue{
    struct node *front;
    struct node *rear;
    int capacity;
    int count;
};
struct node{
    int value;
    struct node *next;
};
struct node* getNode(int value){
    struct node *temp = (struct node*)malloc(sizeof(struct node*));
    temp->value=value;
    temp->next=NULL;
    return temp;
}
void initialize(struct queue *queue_,int capacity){
    queue_->front=NULL;
    queue_->rear=NULL;
    queue_->capacity=capacity;
    queue_->count=0;
}
void print(struct queue queue_){
    struct node *temp = queue_.front;
    printf("Capacity of the queue is %d\n",queue_.capacity);
    printf("Count of the items in queue is %d\n",queue_.count);
    if(queue_.count>0){
        printf("The items in the queue are : ");
        while(NULL!=temp){
            printf("%d ",temp->value);
            temp=temp->next;
        }printf("\n");
    }
}
void insert(struct queue *queue_,int data){
    struct node *temp = getNode(data);
    if(queue_->count==queue_->capacity){
        printf("queue is full, %d is rejected\n",data);
    }else{
        queue_->count=queue_->count+1;
        if(queue_->front==NULL && queue_->front==NULL){
            queue_->front=temp;
            queue_->rear=temp;
        }else{
            queue_->rear->next=temp;
            queue_->rear=temp;            
        }
    }
}
int deleteElement(struct queue *queue_){
    int value=-99999;
    struct node *temp = NULL;
    if(queue_->count==0){
        printf("Queue is empty\n");
    }else{
        queue_->count=queue_->count-1;
        temp=queue_->front;
        queue_->front=temp->next;
        if(queue_->count==1){
            queue_->rear=NULL;
        }
        value=temp->value;
        free(temp);
    }
    return value;
}
int main(){
    struct queue queue_;
    int capacity=10;
    initialize(&queue_,capacity);
    print(queue_);
    for(int i=0;i<capacity+1;i++){
        insert(&queue_,rand()%capacity);
    }
    print(queue_);
    printf("Deleteting 5 elements\n");
    for(int i=0;i<capacity/2;i++){
        printf("Deleted element is %d\n",deleteElement(&queue_));
    }
    print(queue_);
    printf("Adding 3 elements\n");
    for(int i=0;i<capacity/3;i++){
        insert(&queue_,rand()%capacity);
    }
    print(queue_);
    return 0;
}