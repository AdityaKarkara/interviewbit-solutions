package interviewbit;

import interviewbit.util.LinkedListUtils;
import interviewbit.util.ListNode;

public class SwapListNodesInPairs<T> {
    public ListNode<T> swapPairs(ListNode<T> A) {
        if (A == null || A.next == null) return A;
        ListNode<T> temp = A;
        ListNode<T> prev = null;
        while (temp.next != null) {
            ListNode<T> next = temp.next;
            if (prev == null) {
                A = next;
            } else {
                prev.next = next;
            }

            temp.next = temp.next.next;
            next.next = temp;
            prev = temp;
            if (temp.next != null)
                temp = temp.next;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new LinkedListUtils<Integer>().createList(28, 34, 48, 74, 42, 49, 37, 59, 97, 96, 73, 44, 39, 50, 80, 30, 95, 26, 94, 88, 87, 84, 57, 47, 100, 56, 69, 27, 58, 2, 64, 86, 8, 43, 41, 32, 67, 51, 53, 101, 7, 76, 92, 45, 83, 6, 46, 40, 16, 66, 91, 1, 63, 89, 90, 4, 52, 65, 3, 70, 62, 29, 71, 15, 22, 93, 24, 25, 61, 82, 54, 60, 81, 14, 33, 85, 13, 17, 20, 31, 18, 79, 68, 10, 38, 11, 78, 72, 55, 36, 19, 99, 77, 5, 12, 35, 23, 21, 98);
        SwapListNodesInPairs<Integer> listNodesInPairs = new SwapListNodesInPairs<>();
        ListNode<Integer> reversePairs = listNodesInPairs.swapPairs(head);
        System.out.println(reversePairs);
    }
}
