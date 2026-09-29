class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merge = new ArrayList<>();
        merge.add(list.get(0));

        for(int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            int[] prev = merge.get(merge.size() - 1);

            if(prev[1] >= curr[0])
                merge.get(merge.size() - 1)[1] = Math.max(prev[1], curr[1]);
            else 
                merge.add(curr);
        }

        return merge.toArray(new int[0][]);
    }
}
