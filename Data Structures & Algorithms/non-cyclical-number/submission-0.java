class Solution {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        
        while(n != 1) {
            int sum = sqSum(n);
            if(sum == 1) return true;
            if(set.contains(sum)) return false;
            else set.add(sum);
            n = sum;
        }
        return true;
    }

    public int sqSum(int n) {
        int sum = 0;

        while(n != 0) {
            int x = n % 10;
            sum = sum + (x * x);
            n = n / 10;
        }

        return sum;
    }
}
