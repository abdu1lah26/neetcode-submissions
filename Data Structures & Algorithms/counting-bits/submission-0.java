class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            ans[i] = countBit(i);
        }

        return ans;
    }

    public int countBit(int i) {
        int cnt = 0;
        while(i != 0) {
            if((i & 1) == 1) cnt++;
            i = i >> 1;
        }

        return cnt;
    }
}
