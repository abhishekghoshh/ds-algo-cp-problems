#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next;
};
void printList(struct node *next){
    struct node *start;
    start=next;
    if(NULL!=start){
        while(NULL!=start){
            printf("data is %d\n",start->data);
            start=start->next;
        }
    }
}
struct node* getOneNode(){
    int data;
    struct node *temp = (struct node*)malloc(sizeof(struct node*));
    scanf("%d",&data);
    temp->data=data;
    temp->next=NULL;
    return temp;
}
struct node* initializeLinkedList(int n){
    struct node *start = NULL,*temp,*travarser=NULL;
    if(n>0){
        for(int i=0;i<n;i++){
            temp=(struct node*)getOneNode();
            if(NULL==start){
                start=temp;
                travarser=temp;
            }else{
                travarser->next=temp;
                travarser=temp;
            }
        }
    }
    return start;
}
int main(){
    int n;
    struct node *start;
    printf("size of your linked list : ");
    scanf("%d",&n);

    start=initializeLinkedList(n);
    printList(start);

    return 0;
}
