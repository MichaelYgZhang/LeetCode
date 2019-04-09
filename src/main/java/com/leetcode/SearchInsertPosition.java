package com.leetcode;

/**
 * Input: 1,3,5,6 5 Output:2
 * Input: 1,3,5,6 2 Output:1
 *
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int height = nums.length -1, low = 0;
        while (low <= height) { //注意这里判断是小于等于，why?
            int mid = (height+low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                height = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
