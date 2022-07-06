package interviewbit;

import interviewbit.util.LinkedListUtils;
import interviewbit.util.ListNode;

public class RemoveDuplicatesFromSortedLinkedList<T> {

    public ListNode<T> deleteDuplicates(ListNode<T> A) {
        ListNode<T> tempOne = A, tempTwo = A;
        while (tempTwo != null && tempTwo.next != null) {
            if (tempOne.val.equals(tempTwo.val)) {
                tempTwo = tempTwo.next;
            } else {
                tempOne.next = tempTwo;
                tempOne = tempOne.next;
                tempTwo = tempTwo.next;
            }
        }
        tempOne.next = tempOne.val.equals(tempTwo.val) ? null : tempTwo;
        return A;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new LinkedListUtils<Integer>().createList(2, 3, 8, 10, 11, 12, 15, 18, 19);
        ListNode<Integer> finalList = new RemoveDuplicatesFromSortedLinkedList<Integer>().deleteDuplicates(list);
    }
}
