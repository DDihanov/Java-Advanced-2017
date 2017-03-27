package iterators_and_comparators.p09_custom_linked_list_traversing.models;

public class ListNode<T> {
    private T value;
    private ListNode<T> nextNode;
    private ListNode<T> prevNode;

    protected ListNode(T value) {
        this.setValue(value);
    }

    protected ListNode(T value, ListNode<T> nextNode, ListNode<T> prevNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    protected T getValue() {
        return value;
    }

    private void setValue(T value) {
        this.value = value;
    }

    protected ListNode<T> getNextNode() {
        return nextNode;
    }

    protected void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    protected ListNode<T> getPrevNode() {
        return prevNode;
    }

    protected void setPrevNode(ListNode<T> prevNode) {
        this.prevNode = prevNode;
    }
}
