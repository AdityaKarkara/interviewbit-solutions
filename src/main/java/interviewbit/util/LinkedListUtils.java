package interviewbit.util;

public class LinkedListUtils<T> {
    public ListNode<T> createList(T... data) {
        if (data == null || data.length == 0) return null;
        ListNode<T> head = new ListNode<>(data[0]);
        ListNode<T> curr = head;
        for (int i = 1; i < data.length; i++) {
            curr.next = new ListNode<>(data[i]);
            curr = curr.next;
        }
        return head;
    }
}
