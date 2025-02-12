package pavel.demo;


import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.top();   // returns 4
        stack.pop();  // returns 4
        stack.pop();  // returns 4
        stack.pop();  // returns 4
        stack.pop();  // returns 4
        stack.pop();  // returns 4
        stack.push(5);
        stack.push(6);
        stack.top();   // returns 6
        stack.pop();  // returns 6
        stack.empty(); // returns false
    }

    static class MyStack {

        Queue<Integer> queue;
        Integer last;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            last = x;
            queue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int remove = last;
            if (queue.remove(last)) {
                if (queue.size() > 0) {
                    last = (Integer) queue.toArray()[queue.size() - 1];
                } else {
                    last = Integer.MIN_VALUE;
                }

                return remove;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            return last;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
