#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct employee{
    int id;
    float salary;
};
int main(){
    int id;
    float salary;
    struct employee e1;
    struct employee *e2;
    
    printf("Using of structure via pointer refference");
    scanf("%d",&e1.id);
    scanf("%f",&e1.salary);

    printf("e1.id is %d\n",e1.id);
    printf("e1.salary is %f\n",e1.salary);

    printf("Using of structure via pointer refference");
    e2=(struct employee*)malloc(sizeof(struct employee*));
    scanf("%d",&id);
    scanf("%f",&salary);
    e2->id=id;
    e2->salary=salary;

    printf("e1.id is %d\n",e2->id);
    printf("e1.salary is %f\n",e2->salary);
    
    return 0;
}