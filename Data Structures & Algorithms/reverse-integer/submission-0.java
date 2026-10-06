class Solution {
    public int reverse(int x) {

        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;


        while(x != 0) {
            int digit = x % 10;
            
            if(res > max / 10 || res == max / 10 && digit > max % 10) {
                return 0;
            } else if (res < min / 10 || res == min / 10 && digit < min % 10) {
                return 0;
            }

            x = x / 10;

            res = res * 10 + digit;
        }

        return res;
    }
}
