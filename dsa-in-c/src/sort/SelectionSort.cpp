#include<stdio.h>
#include<conio.h>
void swap(int* a,int imin,int i)
{
	int temp=a[i];
	a[i]=a[imin];
	a[imin]=temp;
}
int min(int* a,int i)
{
	int minimum=i,j;
	for(j=i+1;j<10;j++)
	{
		if(a[minimum]>=a[j])
		minimum=j;
	}
	return minimum;
}
void SelectionSort(int* a,int n)
{
	int iminimum,i;
	for(i=0;i<n-1;i++)
	{
		iminimum=min(a,i);
		swap(a,iminimum,i);
	}	
}
int main()
{
	int a[10],i,minimum;
	for(i=0;i<10;i++)
	{
		scanf("%d",(a+i));
	}
	SelectionSort(a,10);
	for(i=0;i<10;i++)
	{
		printf("%d ",*(a+i));
	}
	return 0;
}
