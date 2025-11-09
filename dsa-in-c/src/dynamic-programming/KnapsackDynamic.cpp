#include<stdio.h>
#include<conio.h>

int knapsack(int w[],int v[],int n,int x);

int main()
{
	int x,n,i,ans;
	printf("Enter number of weights = ");
	scanf("%d",&n);
	
	printf("\nEnter bag capacity = ");
	scanf("%d",&x);
	
	int w[n+1],v[n+1];
	
	printf("\nEnter %d weights\n\n",n);
	for(i=1;i<=n;i++)
	scanf("%d",&w[i]);
	
	printf("\nEnter values of %d weights\n\n",n);
	for(i=1;i<=n;i++)
	scanf("%d",&v[i]);
	
	ans=knapsack(w,v,n,x);
	printf("\nMaximum value = %d",ans);
	return 0;
}

int knapsack(int w[],int v[],int n,int x)
{
	int m[n+1][x+1],i,j;
	for(i=0;i<=n;i++)
	m[i][0]=0;
	for(i=0;i<=x;i++)
	m[0][i]=0;
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=x;j++)
		if(w[i]>j || m[i-1][j]>m[i-1][j-w[i]]+v[i])
		m[i][j]=m[i-1][j];
		else
		m[i][j]=m[i-1][j-w[i]]+v[i];
	}
	return m[n][x];
}
