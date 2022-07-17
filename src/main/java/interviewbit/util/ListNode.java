package interviewbit.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}
