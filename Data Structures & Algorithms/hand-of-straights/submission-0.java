class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();

            for (int i = 0; i < gs; i++) {
                int card = first + i;

                if (!map.containsKey(card))
                    return false;

                int count = map.get(card);

                if (count == 1)
                    map.remove(card);
                else
                    map.put(card, count - 1);
            }
        }

        return true;
    }
}
