package problems.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class NearestGreaterToLeft{
    public static void main(String args[]){
        Integer[] arr = {1,3,2,4,3,3};
        int length = arr.length;
        List<Integer> answer = nearestGreaterToleft(arr, length);
        System.out.println(Arrays.asList(arr));
        System.out.println(answer);
    }

    private static List<Integer> nearestGreaterToleft(Integer[] arr, int length) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<length;i++){
            if(stack.size()==0){
                answer.add(-1);
            }else{
                if(stack.peek()>arr[i]){
                    answer.add(stack.peek());
                }else{
                    while(stack.size()>0 && stack.peek()<=arr[i]){
                        stack.pop();
                    }
                    if(stack.size()==0){
                        answer.add(-1);
                    }else{
                        answer.add(stack.peek());
                    }
                }
            }
            stack.add(arr[i]);
        }
        return answer;
    }
}