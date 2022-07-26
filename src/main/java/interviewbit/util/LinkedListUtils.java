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

    public void printList(ListNode<T> head) {
        StringBuilder sb = new StringBuilder();
        while (head.next != null) {
            sb.append(head.val.toString());
            sb.append(" -> ");
            head = head.next;
        }
        sb.append(head.val);
        System.out.println(sb);
    }
}
