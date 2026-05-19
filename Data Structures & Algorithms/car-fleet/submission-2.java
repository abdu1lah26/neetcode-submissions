class Solution {

    class Pair {
        int pos;
        int spd;
        Pair(int pos, int spd) {
            this.pos = pos;
            this.spd = spd;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> detail = new ArrayList<>();
        for(int i=0; i<position.length; i++) {
            detail.add(new Pair(position[i], speed[i]));
        }

        detail.sort((a, b) -> b.pos - a.pos);
        Stack<Double> time = new Stack<>();
        int fleet = 0;
        for(int i=0; i<speed.length; i++) {
            Pair car = detail.get(i);
            double t = (target - car.pos + 0.0) / car.spd;
            while(!time.isEmpty() && time.peek() < t) time.pop();
            if(time.isEmpty()) {
                fleet++;
            }
            time.push(t);
        }
        return fleet;
    }
}
