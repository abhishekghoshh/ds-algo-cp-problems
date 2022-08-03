package problems.stack;

import java.util.Stack;

public class CustomMinStackWithoutSpace {
    public static void main(String[] args){
        CustomMinStackWithoutSpace stack = new CustomMinStackWithoutSpace();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(3);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }

    private Stack<Integer> stack = new Stack<>();
    private Integer minElement;
    public Integer peek(){
        if(stack.size()==0){
            return -1;
        }
        return stack.peek();
    } 
    public Integer min(){
        if(stack.size()==0){
            return -1;
        }
        return minElement;
    }
    public Integer pop(){
        if(stack.size()==0){
            return -1;
        }
        if(stack.peek()>minElement){
            return stack.pop();
        }else{
            Integer tempMinElement=minElement;
            minElement=2*minElement-stack.peek();
            stack.pop();
            return tempMinElement;
        }
    }
    public void push(Integer item){
        if(stack.size()==0){
            minElement=item;
            stack.add(item);
        }else if(item>minElement){
            stack.add(item);
        }else{
            stack.add(2*item-minElement);
            minElement=item;
        }
    }
    @Override
    public String toString(){
        return "stack "+stack +" \nminElement "+minElement;
    }
}
