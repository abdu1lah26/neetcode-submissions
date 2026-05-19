class KthLargest {
    List<Integer> arr;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        arr = new ArrayList<>();
        for(int i : nums) arr.add(i);
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - K);
    }
}
