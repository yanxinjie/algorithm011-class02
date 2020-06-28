package Week_01.MergeSortedArray;

import java.util.Arrays;

/**
 * 将nums2追加到nums1之后
 * 取临时数组tmpArr为 nums1[0:m+n]
 * sort
 * 重新拷贝
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m + n > nums1.length) return;
        if (n >= 0) System.arraycopy(nums2, 0, nums1, 0 + m, n);
        int[] tmpArr = new int[m+n];
        if (m + n >= 0) System.arraycopy(nums1, 0, tmpArr, 0, m + n);
        Arrays.sort(tmpArr);
        if (tmpArr.length >= 0) System.arraycopy(tmpArr, 0, nums1, 0, tmpArr.length);
    }
}
