class TimeMap {

    class Pair {
       String v;
       int t;
       Pair( int t, String v) {
        this.v = v;
        this.t = t;
       } 
    }

    public Optional<Pair> bs(ArrayList<Pair> lt, int target) {
        int left = 0; 
        int right = lt.size() - 1;
        int index = -1;
        while(left <= right) {
            int mid = (left + right)/2;
            Pair curr = lt.get(mid);

            if(curr.t < target) {
                index = mid;
                left = mid + 1;
            }else if(curr.t > target) {
                right = mid - 1;
            }else {
                return Optional.of(curr);
            }
        }
        if(index == -1) {
            return Optional.empty();
        }
        return Optional.of(lt.get(index));
    }

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map =  new HashMap<>();
    }
    
    public void set(String key, String value, int time) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        ArrayList<Pair> list = map.get(key);
        list.add(new Pair(time ,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        ArrayList<Pair> lt = map.get(key);

        Optional<Pair> ans = bs(lt, timestamp);

        if(ans.isEmpty()) return "";
        return ans.get().v;
    }
}
