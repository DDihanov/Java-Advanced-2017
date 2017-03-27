package iterators_and_comparators.p09_custom_linked_list_traversing.models;

import iterators_and_comparators.p09_custom_linked_list_traversing.interfaces.CustomLinkedList;

import java.util.Iterator;

public class CustomLinkedListImpl<T> implements CustomLinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int count;


    @Override
    public void addLast(T element) {
        if (this.count == 0) {
            this.head = new ListNode<T>(element);
            this.tail = this.head;
        } else {
            ListNode<T> newTail = new ListNode<>(element);
            newTail.setNextNode(this.tail);
            this.tail.setPrevNode(newTail);
            this.tail = newTail;
        }
        this.count++;
    }

    @Override
    public void addFirst(T element) {
        if (this.count == 0) {
            this.head = new ListNode<T>(element);
            this.tail = this.head;
        } else {
            ListNode<T> newHead = new ListNode<>(element);
            newHead.setNextNode(this.head);
            this.head.setPrevNode(newHead);
            this.head = newHead;
        }
        this.count++;

    }

    @Override
    public boolean remove(T elementToRemove) {
        if (this.count == 0) {
            return false;
        }

        ListNode<T> element = this.head;
        while (element != null) {
            if (element.getValue().equals(elementToRemove)) {

                if (element.equals(this.head)) {
                    this.head = element.getPrevNode();
                    this.head.setNextNode(null);
                    count--;
                    return true;
                }

                if (element.equals(this.tail)) {
                    this.tail = element.getNextNode();
                    this.tail.setPrevNode(null);
                    count--;
                    return true;
                }
                ListNode<T> prev = element.getPrevNode();
                ListNode<T> next = element.getNextNode();

                prev.setNextNode(next);
                next.setPrevNode(prev);
                count--;
                return true;
            }
            element = element.getPrevNode();
        }

        return false;
    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator();
    }

    private final class CustomLinkedListIterator implements Iterator<T> {
        private ListNode<T> currentElement = head;

        public CustomLinkedListIterator() {
        }

        @Override
        public boolean hasNext() {
            return this.currentElement != null;
        }

        @Override
        public T next() {
            T nextElement = this.currentElement.getValue();
            this.currentElement = this.currentElement.getPrevNode();
            return nextElement;
        }
    }
}
