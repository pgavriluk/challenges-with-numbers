package pavel.demo;


import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.push(6);
        queue.push(7);
        queue.pop();
        queue.empty(); // returns false
    }

    static class MyQueue {

        Stack<Integer> stack;
        Stack<Integer> reversedStack;


        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            reversedStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(reversedStack.isEmpty()){
                while (!stack.isEmpty()){
                    reversedStack.push(stack.pop());
                }
            }

            return reversedStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(!reversedStack.isEmpty()){
                return reversedStack.peek();
            }
            return stack.isEmpty() ?  Integer.MIN_VALUE : stack.get(0);
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.empty() && reversedStack.isEmpty();
        }
    }
}
