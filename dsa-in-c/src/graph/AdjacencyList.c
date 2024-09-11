#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>

struct graph{
    int count;
    int edge;
    struct vertex **items;
};
struct vertex{
    int point;
    struct vertex *next;
};
struct vertex* getOneVertex(int point){
    struct vertex *vertex_ = (struct vertex*)malloc(sizeof(struct vertex*));
    vertex_->point=point;
    vertex_->next=NULL;
    return vertex_;
}
struct graph createGraph(int vertex){
    struct graph graph_;
    graph_.count=vertex;
    graph_.items = (struct vertex**)malloc(vertex*sizeof(struct vertex**));
    for(int i=0;i<vertex;i++){
        graph_.items[i]=getOneVertex(i);
    }
    return graph_;
}
void print(struct graph graph_){
    struct vertex *vertex_=NULL;
    printf("The graph is \n");
    for(int i=0;i<graph_.count;i++){
        vertex_=graph_.items[i];
        while(NULL != vertex_){
            printf("%d --> ",vertex_->point);
            vertex_=vertex_->next;
        }printf("\n");
    }
}

void addEdge(struct vertex *vertex_,int end){
    if(NULL!= vertex_){
        while(NULL!=vertex_->next){
            if(vertex_->point == end){
                return;
            }
            vertex_=vertex_->next;
        }
        vertex_->next = getOneVertex(end);
    }
}

void makeUndirectedEdge(struct graph graph_,int start,int end){
    if(start<graph_.count && end<graph_.count){
        addEdge(graph_.items[start],end);
        addEdge(graph_.items[end],start);
    }
}
void makeDirectedEdge(struct graph graph_,int start,int end){
    if(start<graph_.count && end<graph_.count){
        addEdge(graph_.items[start],end);
    }
}
void initializeGraph(struct graph graph_,int edge){
    graph_.edge=edge;
    for(int i=0;i<edge;i++){
        makeUndirectedEdge(graph_,rand()%edge,rand()%edge);
    }
}
int main(){
    int vertex=10;
    int edge=15;
    struct graph graph_ = createGraph(vertex);
    print(graph_);
    initializeGraph(graph_,edge);
    print(graph_);
    return 0;
}