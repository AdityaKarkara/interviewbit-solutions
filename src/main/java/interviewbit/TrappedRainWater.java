package interviewbit;

import java.util.Arrays;
import java.util.List;

public class TrappedRainWater {
    public int trap(final List<Integer> A) {
        int lMax = 0, rMax = 0;
        int trappedWater = 0;
        int start = 0, end = A.size() - 1;
        while (start < end) {
            if (A.get(start) < A.get(end)) {
                if (A.get(start) > lMax)
                    lMax = A.get(start);
                else
                    trappedWater += lMax - A.get(start);
                start++;
            } else {
                if (A.get(end) > rMax)
                    rMax = A.get(end);
                else
                    trappedWater += rMax - A.get(end);
                end--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        System.out.println(new TrappedRainWater().trap(list) == 6);
    }
}
