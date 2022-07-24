package interviewbit;

import java.util.*;

public class MedianOfTwoSortedLists {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int len = a.size() + b.size();
        int first = findKth(a, 0, b, 0, len / 2 + 1);
        if (len % 2 == 1) return first;
        else
            return (findKth(a, 0, b, 0, len / 2) + first) / 2.0;
    }

    public int findKth(final List<Integer> a, int aStart, final List<Integer> b, int bStart, int k) {
        if (aStart >= a.size()) return b.get(bStart + k - 1);
        if (bStart >= b.size()) return a.get(aStart + k - 1);
        if (k == 1) return Math.min(a.get(aStart), b.get(bStart));

        int aKey = aStart + k / 2 - 1 < a.size() ? a.get(aStart + k / 2 - 1) : Integer.MAX_VALUE;
        int bKey = bStart + k / 2 - 1 < b.size() ? b.get(bStart + k / 2 - 1) : Integer.MAX_VALUE;

        if (aKey < bKey) {
            return findKth(a, aStart + k / 2, b, bStart, k - k / 2);
        } else {
            return findKth(a, aStart, b, bStart + k / 2, k - k / 2);
        }
    }
}
