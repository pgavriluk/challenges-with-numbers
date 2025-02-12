package pavel.demo;


public class ReverseLinkedListBetween {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();

        listNode.val = 1;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode reverse = reverseBetween(listNode, 2, 4);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }


    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (m < n) {
            ListNode current = head;
            ListNode beforeM = null;
            ListNode afterN;
            ListNode prev;
            ListNode next;

            int i = 1;

            while (i < m) {
                beforeM = current;
                current = current.next;

                i++;
            }

            afterN = current;
            next = current.next;

            while (i < n) {
                prev = current;
                current = next;
                next = current.next;
                current.next = prev;

                i++;
            }

            if (m < 2) {
                head = current;
            } else {
                beforeM.next = current;
            }
            afterN.next = next;

        }

        return head;


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
