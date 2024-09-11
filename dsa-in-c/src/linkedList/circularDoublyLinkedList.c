#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
int array[]={1,2,3,4,5};

struct circularDoublyLinkedList{
    struct node *head;
    struct node *last;
    int length;
};

struct node{
    int data;
    struct node *next;
    struct node *prev;
};
void printList(struct circularDoublyLinkedList list){
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
void printListwithAddress(struct circularDoublyLinkedList list){
    struct node *start;
    start=list.head;
    printf("The list is :\n");
    if(NULL!=start){
        while(NULL!=start){
            printf("prev addr = %p , data = %d next addr = %p\n",start->data);
            start=start->next;
        }
    }
}
struct node* getOneNode(int data){
    struct node *temp = (struct node*)malloc(sizeof(struct node*));
    temp->data=data;
    temp->next=NULL;
    temp->prev=NULL;
    return temp;
}   
struct circularDoublyLinkedList initializeLinkedList(int *array,int count){
}
void insertAtBegin(struct circularDoublyLinkedList *list,int data){
}
void insertAtEnd(struct circularDoublyLinkedList *list,int data){
}
int deleteFromBegin(struct circularDoublyLinkedList *list){
}
int deleteFromEnd(struct circularDoublyLinkedList *list){
}
void insertAtN(struct circularDoublyLinkedList *list,int position,int data){
}
int deleteAtN(struct circularDoublyLinkedList *list,int position){
}
void reverse(struct circularDoublyLinkedList *list){
}
struct circularDoublyLinkedList initialize(){
}
int main(){
    struct circularDoublyLinkedList list;
    return 0;
}