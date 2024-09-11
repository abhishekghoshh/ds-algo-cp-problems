#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
// int array[]={1,2,3,4,5};
#define INVALID -99999

struct doublyLinkedList{
    struct node *start;
    struct node *last;
    int length;
};

struct node{
    int data;
    struct node *next;
    struct node *prev;
};
void printList(struct doublyLinkedList list){
    struct node *start;
    start=list.start;
    printf("The list is : ");
    if(NULL!=start){
        while(NULL!=start){
            printf("%d ",start->data);
            start=start->next;
        }
    }printf("\n");
}
void printListwithAddress(struct doublyLinkedList list){
    struct node *start;
    start=list.start;
    printf("The list is :\n");
    if(NULL!=start){
        while(NULL!=start){
            printf("prev addr = %p , data = %d, address = %p  ,next addr = %p\n",start->prev,start->data,start,start->next);
            start=start->next;
        }
    }printf("\n");
}
struct node* getOneNode(int data){
    struct node *temp = (struct node*)malloc(sizeof(struct node*));
    temp->data=data;
    temp->next=NULL;
    temp->prev=NULL;
    return temp;
} 
struct doublyLinkedList initialize(){
    struct doublyLinkedList list;
    list.start= NULL;
    list.start=NULL;
    list.length=0;
    return list;
}  
struct doublyLinkedList initializeLinkedList(int *array,int count){
    struct doublyLinkedList list = initialize();
    struct node *start = NULL,*last=NULL,*prev=NULL;
    for(int i=0;i<count;i++){
        last = getOneNode(array[i]);
        if(NULL==start){
            start= last;
            prev=last;
        }else{
            prev->next=last;
            last->prev=prev;
            prev=last;
        }
    }
    list.start=start;
    list.length=count;
    list.last=last;
    return list;
}
void here(){
    printf("\nI am here\n");
}
void insertAtBegin(struct doublyLinkedList *list,int data){
    if(NULL!=list){
        struct node *temp=getOneNode(data);
        list->length=list->length+1;
        if(NULL!=list->start){
            temp->next=list->start;
            list->start->prev=temp;
        }else{
            list->last=temp;
        }
        list->start=temp;
    }
}
void insertAtEnd(struct doublyLinkedList *list,int data){
    if(NULL!=list){
        struct node *temp=getOneNode(data);
        list->length=list->length+1;
        if(NULL!=list->start){
            list->last->next=temp;
            temp->prev=list->last;
        }else{
            list->start=temp;
        }
        list->last=temp;
    }
}
int deleteFromBegin(struct doublyLinkedList *list){
    int data = INVALID;
    if(NULL!=list){
        if(NULL!=list->start){
            struct node *temp =list->start;
            data=temp->data;
            list->start=temp->next;
            if(NULL==temp->next){
                list->last=NULL;
            }
            free(temp);
            list->length=list->length-1;
            list->start->prev=NULL;
        }
    }
    return data;
}
int deleteFromEnd(struct doublyLinkedList *list){
    int data = INVALID;
    if(NULL!=list){
        if(NULL!=list->start){
            struct node *temp=list->start;
            while(NULL!=temp->next){
                temp=temp->next;
            }
            if(NULL==temp->next && NULL==temp->prev){
                list->start=NULL;
                list->last=NULL;
            }else{
                list->last=temp->prev;
                list->last->next=NULL;
            }
            data=temp->data;
            free(temp);
            list->length=list->length-1;
        }
    }
    return data;
}
// void insertAtN(struct doublyLinkedList *list,int position,int data){
// }
// int deleteAtN(struct doublyLinkedList *list,int position){
// }
// void reverse(struct doublyLinkedList *list){
// }

int main(){
    struct doublyLinkedList list = initialize();
    int array[] = {1,2,3,4,5};
    // int count = ((sizeof(array))/sizeof(int));
    // list=initializeLinkedList(array,count);
    insertAtBegin(&list,6);
    insertAtEnd(&list,7);
    printList(list);
    printListwithAddress(list);
    printf("delete from begining : %d\n",deleteFromBegin(&list));
    // printList(list);
    // printListwithAddress(list);
    printf("delete from end : %d\n",deleteFromEnd(&list));
    printList(list);
    printListwithAddress(list);
    return 0;
}