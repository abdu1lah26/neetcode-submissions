class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int n = digits.length;
        int carry = 0;
        int sum = 0;

        for(int i = n - 1; i >= 0; i--) {

            if(i == n - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }

            int num = sum % 10;
            list.add(num);

            carry = sum / 10;
        }

        if(carry != 0) list.add(carry);

        int[] ans = new int[list.size()];
        int s = list.size() - 1;

        for(int i : list) {
            ans[s--] = i;
        }        

        return ans;
    }
}
