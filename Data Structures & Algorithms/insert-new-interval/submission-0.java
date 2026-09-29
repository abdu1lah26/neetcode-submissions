class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for(int[] inter : intervals)
            list.add(inter);
        list.add(newInterval);

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merge = new ArrayList<>();
        merge.add(list.get(0));

        for(int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            int[] prev = merge.get(merge.size() - 1);

            if(curr[0] <= prev[1]) {
                merge.get(merge.size() - 1)[1] = Math.max(curr[1], prev[1]);
            }else {
                merge.add(curr);
            }
        }

        return merge.toArray(new int[0][]);
    }
}
