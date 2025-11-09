#include<stdio.h>
#include<conio.h>

void fibo(int *a,int n);

int main()
{
	int n,arr[100],i;
	printf("Enter the term number = ");
	scanf("%d",&n);
	fibo(arr,n);
	printf("\nFibonacci series upto %d term\n\n",n);
	for(i=0;i<n;i++)
	printf("%d ",arr[i]);
	return 0;
}

void fibo(int *a,int n)
{
	int i;
	a[0]=0;
	a[1]=1;
	for(i=2;i<n;i++)
	a[i]=a[i-1]+a[i-2];
}
