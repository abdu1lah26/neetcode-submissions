class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(map.values());

        int time = 0;
        
        while(!heap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while(cycle > 0 && !heap.isEmpty()) {
                int current = heap.poll();
                if(current > 1) temp.add(current - 1);
                cycle--;
                time++;
            }

            for(int remaining : temp) heap.add(remaining);

            if(!heap.isEmpty()) time += cycle;
        }
    return time;
    }
}
