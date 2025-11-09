#include<stdio.h>
#include<conio.h>

int bin_src(int num,int left,int right);

int a[100],n;

int main()
{
	int i,num,ans;
	printf("Enter number of elements in array\n\n");
	scanf("%d",&n);
	printf("Enter %d numbers\n\n",n);
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	printf("Enter number to search = ");
	scanf("%d",&num);
	ans=bin_src(num,0,n-1);
	if(ans)
	printf("%d is at position = %d",num,ans);
	else
	printf("%d is not present in array",num,ans);
	return 0;
}

int bin_src(int num,int left,int right)
{
	int mid;
	while(left<=right)
	{
		mid=(left+right)/2;
		if(a[mid]==num)
		return mid+1;
		if(num<a[mid])
		right=mid-1;
		else
		left=mid+1;
	}
	return 0;
}
