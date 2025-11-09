#include<stdio.h>
#include<conio.h>

void qsort(int left,int right);
int partition(int left,int right,int pivot);

int a[100];

int main()
{
	int i,n;
	printf("Enter number of elements in array\n\n");
	scanf("%d",&n);
	printf("Enter %d numbers\n\n",n);
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	qsort(0,n-1);
	printf("\n\n\nArray after quick sort\n\n\t");
	for(i=0;i<n;i++)
	printf("%d ",a[i]);
	return 0;
}

void qsort(int left,int right)
{
	int pivot=a[right],new_pivot;
	if(left<right)
	{
		new_pivot=partition(left,right,pivot);
		qsort(left,new_pivot-1);
		qsort(new_pivot+1,right);
	}
	else
	return;
}

int partition(int left,int right,int pivot)
{
	int left_ptr=left,right_ptr=right-1,temp;
	while(1)
	{
		while(a[left_ptr]<pivot)
		left_ptr++;
		
		while(a[right_ptr]>pivot)
		right_ptr--;
		
		if(left_ptr<right_ptr)
		{
			temp=a[left_ptr];
			a[left_ptr]=a[right_ptr];
			a[right_ptr]=temp;
		}
		else
		break;
	}
	temp=a[left_ptr];
	a[left_ptr]=a[right];
	a[right]=temp;
	return left_ptr;
	}
