#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct stack{
    int *items;
    int top;
    int capacity;
};
struct stack create(int capacity){
    struct stack stack_;
    stack_.capacity=capacity;
    stack_.top=-1;
    stack_.items=(int*)malloc(capacity*sizeof(int*));
    return stack_;
}
void print(struct stack stack_){
    printf("Capacity of the stack is %d\n",stack_.capacity);
    printf("Value of top is %d\n",stack_.top);
    if(stack_.top>-1){
        printf("Items of the stack are : ");
        for(int i=stack_.top;i>=0;i--){
            printf("%d ",stack_.items[i]);
        }
        printf("\n");
    }
}
void push(struct stack *stack_,int data){
    if(stack_->top==stack_->capacity-1){
        printf("Capacity of the stack is %d ,value %d is rejected ,stack Overflow\n",stack_->capacity,data);   
    }else{
        stack_->top = stack_->top+1;
        stack_->items[stack_->top]= data;
    }
}
int pop(struct stack *stack_){
    int value = -999999; 
    if(stack_->top==-1){
        printf("stack Underflow\n");
    }else{
        stack_->top = stack_->top - 1;
        value = stack_->items[stack_->top+1];
    }
    return value;
}
int peek(struct stack *stack_){
    int value = -999999; 
    if(stack_->top==-1){
        printf("stack Underflow\n");
    }else{
        value = stack_->items[stack_->top];
    }
    return value;
}
int main(){
    int capacity =10;
    int random_no = 11;
    struct stack stack_;
    stack_=create(capacity);
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