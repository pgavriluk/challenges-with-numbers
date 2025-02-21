package pavel.demo.list;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) { // Move right
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) { // Move left
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                return false; // Duplicate value
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null || this.root == null) {
            return false; // If item is null or tree is empty, return false
        }

        ListItem parent = null;
        ListItem current = this.root;

        while (current != null) {
            int comparison = current.compareTo(item);
            if (comparison < 0) { // Move right
                parent = current;
                current = current.next();
            } else if (comparison > 0) { // Move left
                parent = current;
                current = current.previous();
            } else { // Found the item
                performRemoval(current, parent); // Call `performRemoval()`
                return true;
            }
        }

        return false; // Item was not found
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.previous() == null && item.next() == null) { // Case 1: No children
            if (parent == null) {
                this.root = null;
            } else if (parent.previous() == item) {
                parent.setPrevious(null);
            } else {
                parent.setNext(null);
            }
        } else if (item.previous() == null) { // Case 2: Only right child
            if (parent == null) {
                this.root = item.next();
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                parent.setNext(item.next());
            }
        } else if (item.next() == null) { // Case 3: Only left child
            if (parent == null) {
                this.root = item.previous();
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                parent.setNext(item.previous());
            }
        } else { // Case 4: Two children. Find the smallest node in the right subtree
            ListItem successor = item.next();
            while (successor.previous() != null) {
                parent = successor;
                successor = successor.previous();
            }
            item.setValue(successor.getValue());
            parent.setPrevious(null);
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            return;
        }
        traverse(root.previous());
        System.out.println(root.getValue());
        traverse(root.next());
    }

}

