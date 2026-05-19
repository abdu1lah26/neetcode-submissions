/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> list) {
        Collections.sort(list, (a, b) -> a.end - b.end);

        for(int i = 1; i < list.size(); i++) {
            Interval prev = list.get(i - 1);
            Interval curr = list.get(i);

            if(prev.end > curr.start) return false;
        }

        return true;
    }
}
