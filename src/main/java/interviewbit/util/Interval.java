package interviewbit.util;

import java.util.ArrayList;

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static ArrayList<Interval> getIntervalsFromInput(String input) {
        input = input.trim();
        ArrayList<Interval> intervals = new ArrayList<>();
        int start = -1, end = -1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                start = i;
            }
            if (c == ')') {
                end = i;
                StringBuilder interval = new StringBuilder(input.substring(start, end + 1));
                int spaceIndex = interval.indexOf(" ");
                int intervalStart = Integer.parseInt(interval.substring(interval.indexOf("(") + 1, spaceIndex - 1));
                int intervalEnd = Integer.parseInt(interval.substring(spaceIndex + 1, interval.indexOf(")")));
                intervals.add(new Interval(intervalStart, intervalEnd));
            }
        }
        return intervals;
    }
}
