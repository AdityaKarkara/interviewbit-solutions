package interviewbit;

import interviewbit.util.LinkedListUtils;
import interviewbit.util.ListNode;

public class MergeTwoSortedLinkedLists<T extends Comparable<T>> {
    public ListNode<T> mergeTwoLists(ListNode<T> A, ListNode<T> B) {
        ListNode<T> merged = null, curr = null;
        ListNode<T> curr1 = A, curr2 = B;
        while (curr1 != null && curr2 != null) {
            if (curr1.val.compareTo(curr2.val) < 0) {
                if (merged == null) {
                    merged = curr1;
                    curr = merged;
                } else {
                    curr.next = curr1;
                    curr = curr.next;
                }
                curr1 = curr1.next;
            } else {
                if (merged == null) {
                    merged = curr2;
                    curr = merged;
                } else {
                    curr.next = curr2;
                    curr = curr.next;
                }
                curr2 = curr2.next;
            }
        }
        if (curr1 != null) {
            curr.next = curr1;
        }
        else if (curr2 != null) {
            curr.next = curr2;
        }
        return merged;
    }

    public static void main(String[] args) {
        ListNode<Integer> one = new LinkedListUtils<Integer>().createList(1, 3, 5, 7, 9);
        ListNode<Integer> two = new LinkedListUtils<Integer>().createList(2, 4, 6, 8, 10);
        ListNode<Integer> merged = new MergeTwoSortedLinkedLists<Integer>().mergeTwoLists(one, two);
    }
}
