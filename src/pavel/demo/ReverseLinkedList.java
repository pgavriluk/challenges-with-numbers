package pavel.demo;


public class Main {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();

        listNode.val = 1;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode reverse = reverseList(listNode);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }


    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }
    
    public static ListNode reverseList2(ListNode head) {
        ListNode current = head;
        ListNode reversed = null;
        ListNode temp;

        while (current != null) {
            temp = reversed;
            reversed = current;
            current = current.next;
            reversed.next = temp;
        }

        return reversed;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
