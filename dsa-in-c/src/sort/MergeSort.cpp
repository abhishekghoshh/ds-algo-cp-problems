#include<stdio.h>
#include<conio.h>

void split(int start,int end);
void merge(int start,int mid,int end);

int a[100],b[100];

int main()
{
	int i,n;
	printf("Enter number of elements in array\n\n");
	scanf("%d",&n);
	printf("Enter %d numbers\n\n",n);
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	split(0,n-1);
	printf("\n\n\nArray after merge sort\n\n\t");
	for(i=0;i<n;i++)
	printf("%d ",a[i]);
	return 0;
}

void split(int start,int end)
{
	int mid=(start+end)/2;
	if(start<end)
	{
	split(start,mid);
	split(mid+1,end);
	merge(start,mid,end);
	}
	else
	return;
}

void merge(int start,int mid,int end)
{
	int i,j,k;
	for(i=start,j=mid+1,k=start;i<=mid&&j<=end;k++)
	{
		if(a[i]<a[j])
		b[k]=a[i++];
		else
		b[k]=a[j++];
	}
	while(i<=mid)
	b[k++]=a[i++];
	while(j<=end)
	b[k++]=a[j++];
	
	for(i=start;i<=end;i++)
	a[i]=b[i];
}
