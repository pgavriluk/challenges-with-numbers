package pavel.demo.list;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        // Step 1: Create a LinkedList with an initial node
        MyLinkedList linkedList = new MyLinkedList(new Node("Apple"));

        // Step 2: Add Items to the LinkedList
        linkedList.addItem(new Node("Banana"));
        linkedList.addItem(new Node("Cherry"));
        linkedList.addItem(new Node("Mango"));
        linkedList.addItem(new Node("Grapes"));

        System.out.println("🔹 Linked List After Additions:");
        linkedList.traverse(linkedList.getRoot()); // Expected: Apple, Banana, Cherry, Grapes, Mango

        // Step 3: Try adding a duplicate item (should not be added)
        boolean added = linkedList.addItem(new Node("Banana"));
        System.out.println("🔹 Trying to add duplicate 'Banana': " + added); // Expected: false

        // Step 4: Remove a middle item
        System.out.println("\n🔹 Removing 'Cherry'...");
        linkedList.removeItem(new Node("Cherry"));
        linkedList.traverse(linkedList.getRoot()); // Expected: Apple, Banana, Grapes, Mango

        // Step 5: Remove the first item (root)
        System.out.println("\n🔹 Removing 'Apple' (Root)...");
        linkedList.removeItem(new Node("Apple"));
        linkedList.traverse(linkedList.getRoot()); // Expected: Banana, Grapes, Mango

        // Step 6: Remove the last item
        System.out.println("\n🔹 Removing 'Mango' (Last Node)...");
        linkedList.removeItem(new Node("Mango"));
        linkedList.traverse(linkedList.getRoot()); // Expected: Banana, Grapes

        // Step 7: Try removing an item that doesn't exist
        boolean removed = linkedList.removeItem(new Node("Pineapple"));
        System.out.println("\n🔹 Trying to remove 'Pineapple' (Non-existent): " + removed); // Expected: false

        // Step 8: Traverse the final list state
        System.out.println("\n🔹 Final Linked List:");
        linkedList.traverse(linkedList.getRoot()); // Expected: Banana, Grapes

        SearchTree tree = new SearchTree(new Node(50));

        tree.addItem(new Node(30));
        tree.addItem(new Node(70));
        tree.addItem(new Node(20));
        tree.addItem(new Node(40));
        tree.addItem(new Node(60));
        tree.addItem(new Node(80));

        tree.traverse(tree.getRoot()); // Prints: 20, 30, 40, 50, 60, 70, 80

        tree.removeItem(new Node(50)); // Removes root (50)

        tree.traverse(tree.getRoot()); // Prints: 20, 30, 40, 60, 70, 80

    }
}
