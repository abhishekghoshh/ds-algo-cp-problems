#include<stdlib.h>
#include<stdio.h>
// #include<conio.h>
struct node{
    int data;
    struct node *left;
    struct node *right;
};
struct node* getNode(int data){
    struct node* temp=(struct node*)malloc(sizeof(struct node*));
    temp->data=data;
    temp->left=NULL;
    temp->right=NULL;
    return temp;
}
void preOrder(struct node *start){
    if(NULL!=start){
        printf("%d ",start->data);
        preOrder(start->left);
        preOrder(start->right);
    }
}
void postOrder(struct node *start){
    if(NULL!=start){
        postOrder(start->left);
        postOrder(start->right);
        printf("%d ",start->data);
    }
}
void inOrder(struct node *start){
    if(NULL!=start){
        inOrder(start->left);
        printf("%d ",start->data);
        inOrder(start->right);
    }
}
void printNodeAddress(struct node *start){
    printf("pointer is %p\n",start);
    printf("pointer is %p\n",&start);
    if(NULL!=start){
        printf("data is %d\n",start->data);
    }
}
void insert(struct node **start,int data){
    if(NULL!=(*start)){
        if(data<=(*start)->data){
            if(NULL==(*start)->left){
                (*start)->left=getNode(data);
            }else{
                insert(&((*start)->left),data);
            }
        }else{
            if(NULL==(*start)->right){
                (*start)->right=getNode(data);
            }else{
                insert(&((*start)->right),data);
            }
        }
    }else{
        (*start)=getNode(data);
    }
}
int search(struct node *start,int key){
    if(NULL!=start){
        if(key==start->data){
            return 1;
        }else if(key<start->data){
            return search(start->left,key);
        }else{
            return search(start->right,key);
        }
    }else{
        return 0;
    }
}
int getCount(struct node *start){
    if(NULL!=start){
        return 1 + getCount(start->left) + getCount(start->right);
    }else{
        return 0;
    }
}
int getMinimum(struct node *start){
    int min=-99999;
    if(NULL!=start){
        while(NULL!=start->left){
            start=start->left;
        }
        min=start->data;
    }
    return min;
}
int getMaximum(struct node *start){
    int max=99999;
    if(NULL!=start){
        while(NULL!=start->right){
            start=start->right;
        }
        max=start->data;
    }
    return max;
}
int getLevel(struct node *start){
    int leftLevel,rightLevel;
    if(NULL!=start){
        leftLevel = getLevel(start->left);
        rightLevel = getLevel(start->right);
        return 1 + (leftLevel > rightLevel ? leftLevel : rightLevel);
    }else{
        return 0;
    }
}
void getParentChildAddress(struct node **child,struct node **parent,struct node *start,int data){
    
}
void deleteFromTree(struct node **start,int data){
    struct node *child = NULL;
    struct node *parent = NULL;
    getParentChildAddress(&child,&parent,*start,data);
    

}
int main(){
    struct node *start=NULL;
    printNodeAddress(start);
    int arr[]={4,12,1,2,6,5,7,-1,3};
    for(int i=0;i<(sizeof(arr)/sizeof(int));i++){
        insert(&start,arr[i]);
    }
    printf("Preorder is : ");
    preOrder(start);
    printf("\n");
    printf("Postorder is : ");
    postOrder(start);
    printf("\n");
    printf("Inorder is : ");
    inOrder(start);
    printf("\n");
    printNodeAddress(start);
    if(search(start,5)){
        printf("5 is in the array\n");
    }else{
        printf("5 is not in the array\n");
    }
    if(search(start,100)){
        printf("100 is in the array\n");
    }else{
        printf("100 is not in the array\n");
    }
    printf("Count of node in tree %d\n",getCount(start));
    printf("Maximum element of tree is %d\n",getMaximum(start));
    printf("Minimum element of tree is %d\n",getMinimum(start));
    printf("Height of the tree is %d\n",getLevel(start));
    deleteFromTree(start,5);
    deleteFromTree(start,500);
    return 0;
}
