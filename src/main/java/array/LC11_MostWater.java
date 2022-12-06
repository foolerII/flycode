package array;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 */
public class LC11_MostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }

        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right){
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(min * (right - left), maxArea);
            if (height[left] < height[right]) {
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
}
