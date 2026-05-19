class Solution {
    public int[] twoSum(int[] num, int target) {
       for(int i=0; i<num.length; i++) {
        for(int j=i+1; j<num.length; j++) {
            if(num[i] + num[j] == target) {
                return new int[]{i+1, j+1};
            }
        }
       }
       return new int[]{}; 
    }
}
