class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(temp[i] < temp[j]) {
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}
