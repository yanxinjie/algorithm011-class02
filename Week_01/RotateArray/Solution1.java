package Week_01.RotateArray;

/**
 * 首先对k取余，减少递归层次
 * 采用递归方式
 * 递归内部增加了一个for循环来移动数组内元素
 */
class Solution1 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        nums = rotateInK(nums, k);
    }

    private int[] rotateInK(int[] nums, int k){
        if (k == 0) return nums;
        nums = rotateInK(nums, k-1);
        int rotateValue = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i --){
            nums[i] = nums[i-1];
        }
        nums[0] = rotateValue;
        return nums;
    }
}
