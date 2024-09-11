#include<stdio.h>
// #include<conio.h>
#include<stdlib.h>
struct graph{
    int **graph;
    int vertex;
    int edge;
};
struct graph createGraph(int vertex){
    struct graph graph_;
    int **graph= (int**)malloc(vertex * sizeof(int**)); ;

    for(int i=0;i<vertex;i++){
        graph[i] = (int*)malloc(sizeof(int*));
    }
    for(int i=0;i<vertex;i++){
        for(int j=0;j<vertex;j++){
            graph[i][j] = (i==j);
        }
    }
    graph_.graph=graph;
    graph_.vertex=vertex;
    graph_.edge=0;
    return graph_;
}
void print(struct graph graph_){
    printf("The graph is : \n");
    for(int i=0;i<graph_.vertex;i++){
        for(int j=0;j<graph_.vertex;j++){
            printf("%d ",graph_.graph[i][j]);
        }printf("\n");
    }printf("\n");
}
void makeUndirectedEdge(struct graph graph_,int start,int end){
    if(start<graph_.vertex && end<graph_.vertex){
        graph_.graph[start][end]=1;
        graph_.graph[end][start]=1;
    }
}
void makeDirectedEdge(struct graph graph_,int start,int end){
    if(start<graph_.vertex && end<graph_.vertex){
        graph_.graph[start][end]=1;
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
