class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));

        int prevEndTime = list.get(0)[1];
        int cnt = 1;

        for(int i = 0; i < list.size(); i++) {
            int currStartTime = list.get(i)[0];

            if(prevEndTime <= currStartTime) {
                cnt++;
                prevEndTime = list.get(i)[1];
            }
        }

        return list.size() - cnt;
    }
}
