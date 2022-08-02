package interviewbit;

import java.util.Arrays;
import java.util.List;

public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int petrol = 0;
        int min = 0;
        int lastPos = 0;
        int n = gas.size();
        for (int i = 0; i < n; i++) {
            petrol += gas.get(i);
            petrol -= cost.get(i);
            lastPos = Math.max(petrol, gas.get(i) - cost.get(i) + lastPos);
            if (lastPos >= 0) {
                if (min == -1)
                    min = i;
            } else {
                min = -1;
            }
            lastPos = Math.max(0, lastPos);
        }
        if (petrol < 0)
            return -1;
        return min;
    }

    public static void main(String[] args) {
        List<Integer> gas = Arrays.asList(1, 2);
        List<Integer> cost = Arrays.asList(2, 1);
        int res = new GasStation().canCompleteCircuit(gas, cost);
    }
}
