package pavel.demo.list;

public class MyLinkedList implements NodeList {

    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (newItem == null) {
            return false; // Avoid null insertion
        }

        if (this.root == null) {
            // The list is empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // newItem is greater than currentItem, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // There is no next, so insert at the end of the list
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less than currentItem, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                } else {
                    // The node with no previous is the root, so update root
                    this.root = newItem;
                }
                newItem.setNext(currentItem);
                currentItem.setPrevious(newItem);
                return true;
            } else {
                // Item already exists (equal)
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            return false;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    if (currentItem.previous() != null) {
                        currentItem.previous().setNext(currentItem.next());
                    }
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {
                currentItem = currentItem.previous();
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}
