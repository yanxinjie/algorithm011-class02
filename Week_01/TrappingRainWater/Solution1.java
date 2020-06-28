package Week_01.TrappingRainWater;

public class Solution1 {
    /**
     * 动态规划：
     * 定义记录左右高度的数组，分别对比左右高度，最小值的和即低洼存水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 定义左右高度数组
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];
        // 获取左右高度数组的值
        int originLeftHeight = 0;
        int originRightHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > originLeftHeight) {
                leftHeight[i] = height[i];
                originLeftHeight = height[i];
            } else {
                leftHeight[i] = originLeftHeight;
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > originRightHeight) {
                rightHeight[i] = height[i];
                originRightHeight = height[i];
            } else {
                rightHeight[i] = originRightHeight;
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length -1 ; i ++) {
            sum += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return sum;
    }
}
