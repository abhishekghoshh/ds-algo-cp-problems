#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next;
};
struct stack{
    struct node *items;
    int top;
    int capacity;
};
struct node* getNode(int data){
    struct node *temp=(struct node*)malloc(sizeof(struct node*));
    temp->data=data;
    temp->next=NULL;
    return temp;
}
void initialize(struct stack *stack_,int capacity){
    stack_->items=NULL;
    stack_->capacity=capacity;
    stack_->top=-1;
}
void print(struct stack stack_){
    struct node *first = stack_.items;
    printf("Capacity of the stack is %d\n",stack_.capacity);
    printf("Value of top is %d\n",stack_.top);
    if(stack_.top>-1){
        printf("Items of the stack are : ");
        while(NULL!=first){
            printf("%d ",first->data);
            first=first->next;
        }
        printf("\n");
    }
}
void push(struct stack *stack_,int data){
    struct node *temp=NULL;
    if(stack_->top==stack_->capacity-1){
        printf("Capacity of the stack is %d ,value %d is rejected ,stack Overflow\n",stack_->capacity,data);   
    }else{
        temp=getNode(data);
        stack_->top = stack_->top+1;
        temp->next = stack_->items;
        stack_->items=temp;
    }
}
int pop(struct stack *stack_){
    struct node *temp=NULL;
    int value = -999999; 
    if(stack_->top==-1){
        printf("stack Underflow\n");
    }else{
        stack_->top = stack_->top - 1;
        temp=stack_->items;
        value=temp->data;
        stack_->items=temp->next;
        free(temp);
    }
    return value;
}
int peek(struct stack *stack_){
    struct node *temp=NULL;
    int value = -999999; 
    if(stack_->top==-1){
        printf("stack Overflow\n");
    }else{
        temp=stack_->items;
        value=temp->data;
    }
    return value;
}

int main(){
    int capacity =10;
    int random_no = 11;
    struct stack stack_;
    initialize(&stack_,capacity);
    print(stack_);
    printf("pushing %d random elements to the the stack\n",random_no);
    for(int i=0;i<random_no;i++){
        push(&stack_,rand()%random_no);
    }
    print(stack_);
    printf("Pop one element : %d\n",pop(&stack_));
    print(stack_);
    printf("Peek one element : %d\n",peek(&stack_));
    print(stack_);
    return 0;
}