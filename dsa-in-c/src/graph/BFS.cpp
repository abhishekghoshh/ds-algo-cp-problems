#include<stdio.h>
#include<conio.h>
#include<limits.h>
void bfs(int start,int *visited,int *r,int n);
void enqueue(int u);
int queue_is_empty();
int dequeue();
int graph[100][100]={0},k=0,queue[100],front=-1,rear=-1;
int main()
{
int n,x,y,i,j,e,start;
printf("Enter number of vertices and edges = ");
scanf("%d %d",&n,&e);
int visited[100]={0},r[n+1];
printf("\nEnter start and end vertices of %d edges--->\n\n",e);
for(i=1;i<=e;i++)
{
scanf("%d %d",&x,&y);
graph[x][y]=graph[y][x]=1;
}
printf("\nEnter the start vertex = ");
scanf("%d",&start);
bfs(start,visited,r,n);
printf("\nBFS traversal sequence --->\n\n");
for(i=1;i<=n;i++)
printf("%d ",r[i]);
return 0;
}
void bfs(int start,int *visited,int *r,int n)
{
enqueue(start);
visited[start]=1;
int i,item;
while(!queue_is_empty())
{
item=dequeue();
r[++k]=item;
for(i=1;i<=n;i++)
{
if(!visited[i] && graph[item][i])
{
enqueue(i);
visited[i]=1;
}
}
}
}
void enqueue(int u)
{
if(front==-1 && rear==-1)
front=0;
queue[++rear]=u;
}
int queue_is_empty()
{
return (front==-1 && rear==-1)?1:0;
}
int dequeue()
{
int item=queue[front];
if(front==rear)
front=rear=-1;
else
front++;
return item;
}
