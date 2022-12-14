package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接："https://leetcode.cn/problems/3sum"
 */
public class LC15_3Sum {
    public static void main(String[] args) {
        int[] a = {-1,0,1,2,-1,-4};
//        int[] a = {-1,-1,0,0,0,2};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>(16);
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <length; i++) {
            // -1,-1,-1,2
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = length-1;
            while (left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> innerList = Arrays.asList(nums[i], nums[left], nums[right]);
                    sumList.add(innerList);
                    left++;
                    right--;
                    // 0, 0, 0, 0
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else{
                    right--;
                }
            }
        }
        return sumList;
    }
}
