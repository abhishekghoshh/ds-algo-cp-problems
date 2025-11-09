#include<stdio.h>
#include<conio.h>
#include<limits.h>
void dfs(int start,int *visited,int *r,int n);
int graph[100][100]={0},k=0;
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
dfs(start,visited,r,n);
printf("\nDFS traversal sequence --->\n\n");
for(i=1;i<=n;i++)
printf("%d ",r[i]);
return 0;
}
void dfs(int start,int *visited,int *r,int n)
{
r[++k]=start;
visited[start]=1;
int i;
for(i=1;i<=n;i++)
{
if(graph[i][start] && !visited[i])
dfs(i,visited,r,n);
}
}
