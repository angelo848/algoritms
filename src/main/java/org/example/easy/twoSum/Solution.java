package org.example.easy.twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> targetDiff = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (targetDiff.containsKey(nums[i])) {
        return new int[] { i, targetDiff.get(nums[i]) };
      }
      targetDiff.put(target - nums[i], i);
    }

    return new int[] {};
  }

  public static void main(String[] args) {
    int[] array = {3, 2, 4};
    System.out.println(Arrays.toString(twoSum(array, 6)));
  }
}
