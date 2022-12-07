package array;

import java.util.Arrays;

/**
 * 整数数组的一个排列就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 "下一个排列" 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的下一个排列就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 */
public class LC31_NextPermutation_star {
    public static void main(String[] args) {
        int[] nums = {5,6,4,3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int index = nums.length -2;
        while (index >= 0 && nums[index] >= nums[index+1]){
            index--;
        }

        if(index >= 0){
            int right = nums.length -1;
            while (right > 0 && nums[index] >= nums[right]){
                right--;
            }
            swap(nums, index, right);
        }

        reverse(nums, index +1);
    }

    private static void swap(int[] nums, int index, int right){
        int temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;
    }

    private static void reverse(int[] nums, int index){
        int right = nums.length-1;
        while (index < right){
            swap(nums, index, right);
            index++;
            right--;
        }
    }
}
