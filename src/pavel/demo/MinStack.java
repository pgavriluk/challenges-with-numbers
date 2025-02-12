package pavel.demo;


public class MinStack {

    public static void main(String[] args) {

        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    static class MinStack1 {

        /**
         * initialize your data structure here.
         */
        private static class Node {
            int val;
            int minVal;
            Node next;

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public void setMinVal(int minVal) {
                this.minVal = minVal;
            }

            public int getMinVal() {
                return this.minVal;
            }

        }

        private Node top;

        public MinStack1() {
            top = null;
        }

        public void push(int x) {
            Node newNode = new Node(x, null);
            if (top == null || getMin() > x) {
                newNode.setMinVal(x);
            } else {
                newNode.setMinVal(getMin());
            }
            newNode.next = top;
            top = newNode;
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.getMinVal();
        }
    }
}
