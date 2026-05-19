class TimeMap {
    class Pair {
        String value;
        int time;
        Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        List<Pair> list = map.get(key);
        list.add(new Pair(value, timestamp)); 
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> search = map.get(key);

        int low = 0;
        int high = search.size()-1;
        int index = -1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(search.get(mid).time <= timestamp) {
                index = mid;
                low = mid+1;
            }else {
                high = mid - 1;
            }
        }
        return (index == -1) ? "" : search.get(index).value;
    }
}
