#include<stdio.h>
#include<conio.h>
#include<limits.h>
int shortest_path(int c[100][100],int n,int s,int m);
int v[100][100],d[100][100];
int main()
{
int n,i,j,v1,v2,w,p,c[100][100]={0},s,k,vtx,prev,path[100][100];
printf("Enter number of edge and vertex = ");
scanf("%d %d",&n,&vtx);
printf("\nEnter source\n\n");
scanf("%d",&s);
printf("\nEnter vertex of each edge and their weight---\n\n");
for(i=1;i<=n;i++)
{
scanf("%d %d %d",&v1,&v2,&w);
c[v1][v2]=c[v2][v1]=w;
}
for(i=1;i<=vtx;i++)
{
for(j=i;j<=vtx;j++)
{
if(!c[i][j])
c[i][j]=c[j][i]=INT_MAX;
}
}
p=shortest_path(c,n,s,vtx);
for(j=1;j<=vtx;j++)
{
if(j!=s)
{
printf("\n\n\nLength of shortest path between %d and %d =%d",s,j,v[p][j]);
prev=j;
for(i=p;i>=1;i--)
{
if(d[i][prev]!=prev && d[i][prev]!=INT_MAX &&d[i][prev]!=s)
{
path[j][i]=d[i][prev];
prev=d[i][prev];
}
else
{
i--;
break;
}
}
path[j][i+1]=s;
printf("\nShortest path is = ");
for(k=i+1;k<=p;k++)
printf("%d ---> ",path[j][k]);
printf("%d",j);
}
}
return 0;
}
int shortest_path(int c[100][100],int n,int s,int m)
{
int t,i,j,flag=1,temp;
for(i=1;i<=m;i++)
{
if(i==s)
{
v[0][i]=0;
d[0][i]=s;
v[i][i]=0;
}
else
{
v[0][i]=INT_MAX;
d[0][i]=INT_MAX;
v[1][i]=c[s][i];
if(c[s][i]==INT_MAX)
d[1][i]=INT_MAX;
else
d[1][i]=s;
}
v[i][s]=0;
d[i][s]=s;
}
for(t=2;t<=n && flag;t++)
{
flag=0;
for(i=1;i<=m;i++)
{
if(i==s)
continue;
v[t][i]=INT_MAX;
d[t][i]=d[t-1][i];
for(j=1;j<=m;j++)
{
if(j==i || c[j][i]==INT_MAX || v[t-1][j]==INT_MAX)
continue;
temp=v[t-1][j]+c[j][i];
if(temp<v[t][i])
{
v[t][i]=temp;
d[t][i]=j;
}
}
if(v[t][i]!=v[t-1][i])
flag=1;
}
}
return t-2;
}
