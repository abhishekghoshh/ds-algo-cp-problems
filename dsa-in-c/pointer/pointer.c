#include<stdio.h>
#include<conio.h>

int main(){
    int value=10;
    int* address;
    address = &value;
    printf("value is %d\n",value);
    printf("*address is %d\n",*address);
    printf("&value is %d in integer format\n",&value);
    printf("&value is %p in hexadecimal format\n",&value);
    printf("address is %d in integer format\n",address);
    printf("address is %p in hexadecimal format\n",address);
    printf("&address is %d in integer format\n",&address);
    printf("&address is %p in hexadecimal format\n",&address);
    return 0;
}