package interviewbit;

import interviewbit.util.LinkedListUtils;
import interviewbit.util.ListNode;

public class IntersectionOfTwoLinkedLists<T> {
    public ListNode<T> getIntersectionNode(ListNode<T> a, ListNode<T> b) {
        int lengthA = length(a);
        int lengthB = length(b);

        while (lengthA < lengthB) {
            b = b.next;
            lengthB--;
        }
        while (lengthA > lengthB) {
            a = a.next;
            lengthA--;
        }
        while (a != b) {
            a = a == null ? b : a.next;
            b = b == null ? a : b.next;
        }
        return a;
    }

    public int length(ListNode<T> head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
