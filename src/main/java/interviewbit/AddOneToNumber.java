package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int zeroIndex = 0;
        for (int i : A) {
            if (i != 0)
                break;
            zeroIndex++;
        }
        while (zeroIndex > 0) {
            A.remove((int) --zeroIndex);
        }
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            int one = A.get(i);
            if (carry != 0) {
                one += carry;
                carry = one / 10;
                one %= 10;
            }
            resultList.add(0, one);
        }
        if (carry > 0) resultList.add(0, carry);
        return resultList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 6, 0, 6, 4, 8, 8, 1));
        ArrayList<Integer> resultList = new AddOneToNumber().plusOne(list);
    }
}
