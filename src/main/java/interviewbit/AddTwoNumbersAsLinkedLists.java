package interviewbit;

import interviewbit.util.ListNode;

public class AddTwoNumbersAsLinkedLists {
    public ListNode<Integer> addTwoNumbers(ListNode<Integer> A, ListNode<Integer> B) {
        int carry = 0;
        ListNode<Integer> tempA = A, prevA = null;
        while (A != null && B != null) {
            int sum = carry + A.val + B.val;
            carry = sum / 10;
            sum %= 10;
            A.val = sum;
            prevA = A;
            A = A.next;
            B = B.next;
        }
        while (A != null) {
            int sum = carry + A.val;
            carry = sum / 10;
            sum %= 10;
            A.val = sum;
            A = A.next;
        }
        ListNode<Integer> tempB = B;
        while (B != null) {
            int sum = carry + B.val;
            carry = sum / 10;
            sum %= 10;
            B.val = sum;
            B = B.next;
        }
        if (tempB != null) {
            prevA.next = tempB;
        }
        if (carry != 0) {
            while (prevA.next != null)
                prevA = prevA.next;
            prevA.next = new ListNode<>(carry);
        }
        return tempA;
    }
}
