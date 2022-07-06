package interviewbit;

import interviewbit.util.LinkedListUtils;
import interviewbit.util.ListNode;

public class RemoveNthNodeFromEndOfLinkedList<T> {
    public ListNode<T> removeNthFromEnd(ListNode<T> A, int B) {
        if (A == null || B == 0) return A;
        int length = length(A);
        if (B >= length) return A.next;
        int rem = length - B;
        int count = 1;
        ListNode<T> curr = A;
        while (count < rem) {
            curr = curr.next;
            count++;
        }
        curr.next = curr.next.next;
        return A;
    }

    public int length(ListNode<T> head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new LinkedListUtils<Integer>().createList(20, 380, 349, 322, 389, 424, 429, 120, 64, 691, 677, 58, 327, 631, 916, 203, 484, 918, 596, 252, 509, 644, 33, 460);
        int B = 82;
        ListNode<Integer> finalList = new RemoveNthNodeFromEndOfLinkedList<Integer>().removeNthFromEnd(list, B);
    }
}
