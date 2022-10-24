package Collections;

import java.util.*;

public class Stack_ {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);
        stack.push(8);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop())-> error
        stack.push(5);
        stack.push(8);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }
}
