class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m+n];
        double med = 0;
        int p1 = 0, p2 = 0;
        int k = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1] < nums2[p2]) {
                temp[k++] = nums1[p1];
                p1++;
            }else {
                temp[k++] = nums2[p2];
                p2++;
            }
        }

        while(p1 < m) {
            temp[k++] = nums1[p1];
            p1++;
        }

        while(p2 < n) {
            temp[k++] = nums2[p2];
            p2++;
        }

        int len = m + n;

        if(len%2 == 0) {
            med = ((temp[len/2]) + (temp[(len/2) - 1]))/2.0;
        }else {
            med = temp[len/2];
        }

        return med;
    }
}
