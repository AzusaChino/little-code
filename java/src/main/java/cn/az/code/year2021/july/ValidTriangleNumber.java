package cn.az.code.year2021.july;

import java.util.Arrays;

/**
 * @author az
 * @since 2021-07-15
 */
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
