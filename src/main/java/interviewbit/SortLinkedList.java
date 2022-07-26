package interviewbit;

import interviewbit.util.LinkedListUtils;
import interviewbit.util.ListNode;

public class SortLinkedList {
    public ListNode<Integer> sortList(ListNode<Integer> A) {
        // base case
        if (A == null || A.next == null) return A;

        ListNode<Integer> middle = getMiddle(A);
        ListNode<Integer> middleNext = middle.next;
        middle.next = null;

        ListNode<Integer> left = sortList(A);
        ListNode<Integer> right = sortList(middleNext);
        ListNode<Integer> sortedList = sortedMerge(left, right);
        return sortedList;
    }

    private ListNode<Integer> sortedMerge(ListNode<Integer> left, ListNode<Integer> right) {
        ListNode<Integer> sorted = new ListNode<>(Integer.MIN_VALUE);
        ListNode<Integer> temp = sorted;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return sorted.next;
    }

    private ListNode<Integer> getMiddle(ListNode<Integer> a) {
        if (a == null) return a;
        ListNode<Integer> slow = a, fast = a;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListUtils<Integer> linkedListUtils = new LinkedListUtils<>();
        ListNode<Integer> head = linkedListUtils.createList(1, 3, 5, 7, 9, 2, 4, 6, 8, 10);
        System.out.println("Normal List: ");
        linkedListUtils.printList(head);
        ListNode<Integer> sorted = new SortLinkedList().sortList(head);
        System.out.println("Sorted List: ");
        linkedListUtils.printList(sorted);

    }
}
