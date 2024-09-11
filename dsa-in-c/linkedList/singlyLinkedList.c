#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
int array[]={1,2,3,4,5};

struct singlyLinkedList{
    struct node *start;
    int length;
};

struct node{
    int data;
    struct node *next;
};
void printList(struct singlyLinkedList list){
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
struct node* getOneNode(int data){
    struct node *temp = (struct node*)malloc(sizeof(struct node*));
    temp->data=data;
    temp->next=NULL;
    return temp;
}
struct singlyLinkedList initializeLinkedList(int *array,int count){
    struct singlyLinkedList list;
    struct node *start = NULL,*temp,*travarser=NULL;
    printf("Initializing linked list with array elements\n");
    for(int i=0;i<count;i++){
        temp=(struct node*)getOneNode(array[i]);
        if(NULL==start){
            start=travarser=temp;
        }else{
            travarser->next=temp;
            travarser=temp;
        }
    }
    list.start=start;
    list.length = count;
    printList(list);
    return list;
}
void insertAtBegin(struct singlyLinkedList *list,int data){
    struct node *temp = getOneNode(data);
    temp->next=list->start;
    list->start=temp;
    list->length = list->length +1;
}
void insertAtEnd(struct singlyLinkedList *list,int data){
    struct node *temp = getOneNode(data);
    struct node *start = list->start;
    list->length = list->length +1;
    if(NULL!=start){
        while(NULL!=start->next){
            start=start->next;
        }
        start->next=temp;
    }else{
        list->start = temp;
    }
}
int deleteFromBegin(struct singlyLinkedList *list){
    int data =-99999;
    struct node *start=list->start;
    if(NULL!=start){
        list->start=start->next;
        data=start->data;
        free(start);
        list->length=list->length -1;
    }
    return data;
}
int deleteFromEnd(struct singlyLinkedList *list){
    int data =-99999;
    struct node *start=list->start;
    struct node* parent=start;
    if(NULL!=start){
        while(NULL!=start->next){
            parent=start;
            start= start->next;
        }
        if(parent==list->start){
            list->start = NULL;
        }else{
            parent->next=start->next;
        }
        data=start->data;
        free(start);
        list->length=list->length -1;
    }
    return data;
}
int getCount(struct node *start){
    int count =0;
    if(NULL!=start){
        while(NULL!=start){
            count++;
            start=start->next;
        }
    }
    return count;
}
void insertAtN(struct singlyLinkedList *list,int position,int data){
    struct node *temp = NULL;
    struct node *newNode=NULL;
    struct node *start = list->start;
    printf("Insertion of %d at %dth position\n",data,position);
    if(position >= 0){
        if(position==0){
            insertAtBegin(list,data);
        }else if(position>=list->length){
            insertAtEnd(list,data);
        }else{
            temp = start;
            newNode=getOneNode(data);
            if(NULL==temp){
                list->start=newNode;
            }else{
                for(int i=0;i<position;i++){
                    if(NULL != temp){
                        temp = temp->next;
                    }
                }
                newNode->next = temp->next;
                temp->next = newNode;
                list->length = list->length +1;
            }
        }
    }
    printList(*list);
}
int deleteAtN(struct singlyLinkedList *list,int position){
    int data = -99999;
    struct node *start =NULL;
    struct node *parent =NULL;
    printf("Deleting from %dth position\n",position);
    if(NULL!=list->start){
        if(0==position){
            data=deleteFromBegin(list);
        }else if(position>=list->length-1){
            data = deleteFromEnd(list);
        }else{
            start=list->start;
            parent = start;
            for(int i=0;i<position-1;i++){
                parent = start;
                start=start->next;
            }
            parent->next=start->next;
            data=start->data;
            free(start);
            list->length=list->length -1;
        }
        
    }
    printf("Deleted data is : %d\n",data);
    printList(*list);
    return data;
}
void reverse(struct singlyLinkedList *list){
    struct node *reverse =NULL;
    struct node *intermediate = NULL;
    struct node *start = list->start;
    printf("reversing the list\n");
    while(NULL != start){
        intermediate = start;
        start = start->next;
        intermediate->next=reverse;
        reverse=intermediate;
    }
    list->start =reverse;
    printList(*list);
}
struct singlyLinkedList initialize(){
    struct singlyLinkedList list;
    list.start=NULL;
    list.length=0;
    printList(list);
    return list;
}
int main(){
    struct singlyLinkedList list = initialize();
    deleteAtN(&list,0);
    int count = ((sizeof(array))/sizeof(int));
    list=initializeLinkedList(array,count);
    insertAtN(&list,0,1);
    deleteAtN(&list,3);
    insertAtN(&list,25,2);
    insertAtN(&list,3,25);
    deleteAtN(&list,3);
    reverse(&list);
    return 0;
}
