class Solution {
    public int[] twoSum(int[] num, int target) {
        int low = 0, high = num.length-1;

        while(low < high) {

            if(num[low] + num[high] < target) low++;
            
            else if(num[low] + num[high] > target) high--;

            else return new int[]{low+1, high+1};
        }
        return new int[]{};
    }
}
