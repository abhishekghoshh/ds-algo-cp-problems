package problems.stack;

import java.util.Stack;

public class CustomMinStackWithSpace {
    public static void main(String[] args){
        MinStackWithSpace minStackWithSpace = new MinStackWithSpace();
        minStackWithSpace.push(5);
        minStackWithSpace.push(6);
        minStackWithSpace.push(7);
        minStackWithSpace.push(3);
        minStackWithSpace.push(3);
        System.out.println(minStackWithSpace);
        minStackWithSpace.pop();
        minStackWithSpace.pop();
        minStackWithSpace.pop();
        System.out.println(minStackWithSpace);
    }




    public static class MinStackWithSpace{
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();
        public Integer peek(){
            if(stack.size()==0){
                return -1;
            }
            return stack.peek();
        } 
        public Integer min(){
            if(minStack.size()==0){
                return -1;
            }
            return minStack.peek();
        }
        public Integer pop(){
            if(stack.size()==0){
                return -1;
            }
            if(stack.peek()==minStack.peek()){
                minStack.pop();
            }
            return stack.pop();
        }
        public void push(Integer item){
            if(minStack.size()==0 || item<=minStack.peek()){
                minStack.push(item);
            }
            stack.push(item);
        }
        @Override
        public String toString(){
            return "stack "+stack +" \nminStack"+minStack;
        }
    }
    
    
}
