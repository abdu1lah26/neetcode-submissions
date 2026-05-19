class MedianFinder {
    List<Integer> stream;
    int sum;
    public MedianFinder() {
        stream = new ArrayList<>();
        sum = 0;
    }
    
    public void addNum(int num) {
        stream.add(num);
        Collections.sort(stream);
    }
    
    public double findMedian() {
        return (stream.size()%2 == 0) ? (stream.get(stream.size()/2) + stream.get((stream.size()/2) - 1))/2.0 : stream.get(stream.size()/2);
    }
}
