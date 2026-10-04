class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> list = new ArrayList<>();

        for (int[] triple : triplets) {
            if (triple[0] <= target[0] && triple[1] <= target[1] && triple[2] <= target[2])
                list.add(triple);
        }

        boolean first = false;
        boolean second = false;
        boolean third = false;

        for(int[] triple : list) {
            if(!first && triple[0] == target[0])
                first = true;

            if(!second && triple[1] == target[1])
                second = true;

            if(!third && triple[2] == target[2])
                third = true;
        }

        return (first && second && third);
    }
}
