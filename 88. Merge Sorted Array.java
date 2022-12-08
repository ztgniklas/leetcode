class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = 0, pt2 = 0;
        int[] merged = new int[m + n];
        int idx = 0;
        while (pt1 < m && pt2 < n) {
            int val;
            if (nums1[pt1] < nums2[pt2]) {
                val = nums1[pt1];
                pt1++;
            } else {
                val = nums2[pt2];
                pt2++;
            }
            merged[idx] = val;
            idx++;
        }
        while (pt1 < m) {
            merged[idx] = nums1[pt1];
            pt1++;
            idx++;
        }
        while (pt2 < n) {
            merged[idx] = nums2[pt2];
            pt2++;
            idx++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
    }
}