// we will divide each array into 2 parts, left part and right part.
// the number of the elements in two left parts should equal to that
// in two right parts. Then we can find median on the cutting edges.
// we do binary search in the shorter array, and calculate where to divide
// the other array to satisfy the equivalent segmentation. if there exists
// number in left parts larger than number in right parts (should happen in
// cutting edges since arrays are all sorted), we have to adjust the division
// location. Repeate the process, until we find the correct division
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        // make sure nums1 is the longer one.
        if (len1 < len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (len2 == 0) {
            return ((double)(nums1[(len1 - 1) / 2] + nums1[len1 / 2])) / 2;
        }

        int start1 = 0, start2 = 0, end1 = nums1.length - 1, end2 = nums2.length - 1;
        while (start2 <= end2) {
            int mid2 = (start2 + end2) / 2;
            int mid1 = (nums1.length + nums2.length) / 2 - mid2 - 2;
            int l1 = mid1 >= 0 ? nums1[mid1] : Integer.MIN_VALUE, r1 = nums1[mid1 + 1];
            int l2 = nums2[mid2], r2 = mid2 < nums2.length - 1 ? nums2[mid2 + 1] : Integer.MAX_VALUE;
            if (l1 > r2) {
                start2 = mid2 + 1;
            } else if (l2 > r1) {
                end2 = mid2 - 1;
            } else {
                return (nums1.length + nums2.length) %  2 == 0 ? ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2 : Math.min(r1, r2);
            }
        }
        // [1,3] [2]
        if (end2 < 0) {
            if ((nums1.length + nums2.length) %  2 == 0) {
                int cand1 = 0;
                // [4] [1,2,3]
                if ((len1 + len2) / 2 >= nums1.length) {
                    cand1 = nums2[0];
                } else {
                    cand1 = Math.min(nums2[0], nums1[(len1 + len2) / 2]);
                }
                return ((double)(cand1 + nums1[(len1 + len2) / 2 - 1])) / 2;
            } else {
                return Math.min(nums2[0], nums1[(len1 + len2) / 2]);
            }
        }
        return -1;
    }
}