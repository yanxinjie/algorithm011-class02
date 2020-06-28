package Week_01.RotateArray;

/**
 * 遍历：和Solution1类似，每次取出数组最后的值
 * 数组中每个值往后移动
 * 数组0下标，变更取出的值
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return;
        int n = nums.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
