package interviewbit;

import interviewbit.util.Interval;

import java.util.ArrayList;

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // My solution, doesn't work on InterviewBit for some reason :(
        /*if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }

        int newStart = newInterval.start;
        int newEnd = newInterval.end;

        Interval start = null, end = null;
        for (int i = 0; i < intervals.size(); i++) {
           if (intervals.get(i).start <= newStart) {
               start = intervals.get(i);
           }
           if (intervals.get(i).start > newEnd) {
               end = intervals.get(i - 1);
               break;
           }
        }
        //Interval doesn't require merging
        if (end == null) {
            intervals.add(newInterval);
        } else if (start == end) {
            // new interval can be merged in one single interval
            start.start = Math.min(start.start, newStart);
            start.end = Math.max(start.end, newEnd);
        } else {
            // remove all intervals in between start and end
            ArrayList<Interval> removedIntervals = new ArrayList<>();
            newStart = Math.min(newStart, start.start);
            newEnd = Math.max(newEnd, end.end);
            boolean add = false;
            for (Interval interval : intervals) {
                if (interval == start) {
                    add = true;
                }
                if (interval == end) {
                    removedIntervals.add(interval);
                    add = false;
                }
                if (add) {
                    removedIntervals.add(interval);
                }
            }
            intervals.removeAll(removedIntervals);
            Interval toBeAdded = new Interval(newStart, newEnd);
            int toBeAddedIndex = -1;
            for (int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i).end < toBeAdded.start) {
                    toBeAddedIndex = i + 1;
                    break;
                }
            }
            intervals.add(toBeAddedIndex, toBeAdded);
        }
        return intervals;*/

        // solution from InterviewBit
        int start, end;
        int startIndex, endIndex;
        int i;

        start = newInterval.start;
        end = newInterval.end;
        i = 0;

        startIndex = endIndex = -1;

        for (Interval in : intervals) {

            if (start >= in.start && start <= in.end)
                startIndex = i;

            if (end >= in.start && end <= in.end)
                endIndex = i;

            i++;
        }

        if (startIndex == -1 && endIndex == -1) {

            startIndex = 0;

            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }

            endIndex = intervals.size() - 1;

            for (i = intervals.size() - 1; i >= 0; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }

            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }

            intervals.add(startIndex, newInterval);

            return intervals;
        }

        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }

        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }

        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);

        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;

        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }

        return intervals;
    }

    public static void main(String[] args) {
        String input = "(6037774, 6198243) (6726550, 7004541) (8842554, 10866536) (11027721, 11341296) (11972532, 14746848) (16374805, 16706396) (17557262, 20518214) (22139780, 22379559) (27212352, 28404611) (28921768, 29621583) (29823256, 32060921) (33950165, 64859907) (65277782, 65296274) (67497842, 68386607) (70414085, 73339545) (73896106, 75605861) (79672668, 84539434) (84821550, 86558001) (91116470, 92198054) (96147808, 98979097)";
        ArrayList<Interval> intervals = Interval.getIntervalsFromInput(input);
        Interval newInterval = new Interval(36210193, 61984219);
        ArrayList<Interval> mergedIntervals = new MergeIntervals().insert(intervals, newInterval);
    }
}
