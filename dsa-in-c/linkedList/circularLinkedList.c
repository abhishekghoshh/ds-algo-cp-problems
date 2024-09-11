#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
int array[]={1,2,3,4,5};

struct circularLinkedList{
    struct node *head;
    int length;
};

struct node{
    int data;
    struct node *next;
};
void printList(struct circularLinkedList list){
    struct node *start;
    start=list.head;
    printf("The list is : ");
    if(NULL!=start){
        while(NULL!=start){
            printf("%d ",start->data);
            start=start->next;
        }
    }printf("\n");
}
struct node* getOneNode(int data){
    struct node *temp = (struct node*)malloc(sizeof(struct node*));
    temp->data=data;
    temp->next=NULL;
    return temp;
}   
struct circularLinkedList initializeLinkedList(int *array,int count){
}
void insertAtBegin(struct circularLinkedList *list,int data){
}
void insertAtEnd(struct circularLinkedList *list,int data){
}
int deleteFromBegin(struct circularLinkedList *list){
}
int deleteFromEnd(struct circularLinkedList *list){
}
void insertAtN(struct circularLinkedList *list,int position,int data){
}
int deleteAtN(struct circularLinkedList *list,int position){
}
void reverse(struct circularLinkedList *list){
}
struct circularLinkedList initialize(){
}
int main(){
    struct circularLinkedList list;
    return 0;
}