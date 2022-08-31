//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 437 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int n = arr.length;
            if (k >= n) {
                return Arrays.stream(arr).boxed().collect(Collectors.toList());
            }
            int indexForInsert = findIndexForInsert(arr, x);
            List<Integer> res = new ArrayList<>();
            if (indexForInsert == n) {
                for (int i = n - k; i < n; ++i) {
                    res.add(arr[i]);
                }
                return res;
            }
            int left, right;
            int cnt;
            if (arr[indexForInsert] == x) {
                res.add(x);
                left = indexForInsert - 1;
                right = indexForInsert + 1;
                cnt = 1;
            } else {
                left = indexForInsert - 1;
                right = indexForInsert;
                cnt = 0;

            }

            while (cnt != k) {
                if (left < 0) {
                    res.add(arr[right++]);
                } else if (right >= n) {
                    res.add(0, arr[left--]);
                } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    res.add(0, arr[left--]);
                } else {
                    res.add(arr[right++]);
                }
                cnt++;
            }
            return res;



        }

        private int findIndexForInsert(int[] arr, int x) {
            int n = arr.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == x) {
                    right = mid - 1;
                } else if (arr[mid] > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
