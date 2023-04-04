//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4357 👎 0


package com.qiuyu.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[] {1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return findMedianSortedArrays20230330002(nums1, nums2);
        }


        public double findMedianSortedArrays20230330001(int[] nums1, int[] nums2) {
            int aStart = 0, bStart = 0;
            int left = -1, right = -1;
            int len = nums1.length + nums2.length;
            for (int i = 0; i <= len / 2; ++i) {
                left = right;
                if (aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] <= nums2[bStart])) {
                    right = nums1[aStart++];
                } else {
                    right = nums2[bStart++];
                }
            }
            if ((len & 1) == 1) {
                return right;
            } else {
                return (left + right) / 2.0d;
            }
        }

        /**
         * 分隔两个数组
         */
        public double findMedianSortedArrays20230330002(int[] nums1, int[] nums2) {
            // i，j为两个数组分割位置
            // i+j为分割后左边的数字个数
            // 数量为偶数时，i+j=len/2；数量为奇数时，i+j=(len+1)/2
            // 因此无论奇偶，i+j=(len+1)/2
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays20230330002(nums2, nums1);
            }
            int len = nums1.length + nums2.length;
            int iMin = 0, iMax = nums1.length;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = (len + 1) / 2 - i;
                if (i > 0 && j < nums2.length && nums1[i - 1] > nums2[j]) {
                    iMax = i - 1;
                } else if (j > 0 && i < nums1.length && nums2[j - 1] > nums1[i]) {
                    iMin = i + 1;
                } else {
                    // 此时i到边界、或者j到边界、或者i与j满足切分条件
                    int maxLeft;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }
                    if ((len & 1) == 1) {
                        return maxLeft;
                    }

                    int minRight;
                    if (i == nums1.length) {
                        minRight = nums2[j];
                    } else if (j == nums2.length) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxLeft + minRight) / 2.0d;
                }
            }
            return 0;
        }


        public double findMedianSortedArrays0000000000(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) {
                throw new IllegalArgumentException("no answer");
            }
            return f(nums1, nums2);
//            int len1 = nums1.length, len2 = nums2.length;
//            int pre = -1, cur = -1;
//            int aStart = 0, bStart = 0;
//            for (int i = 0; i < 1 + (len1 + len2) / 2; ++i) {
//                pre = cur;
//                if (aStart < len1 && (bStart >= len2 || nums1[aStart] < nums2[bStart])) {
//                    cur = nums1[aStart++];
//                } else {
//                    cur = nums2[bStart++];
//                }
//            }
//            if ((len1 + len2) % 2 == 1) {
//                return cur;
//            } else {
//                return (pre + cur) / 2.0;
//            }























//            int len1 = nums1.length, len2 = nums2.length;
//            int first = -1, second = -1;
//            int p1 = 0, p2 = 0;
//            //  遍历的次数
//            for (int i = 0; i < (len1 + len2) / 2 + 1; ++i) {
//                first = second;
//                if (p1 < len1 && (p2 == len2 || nums1[p1] < nums2[p2])) {
//                    second = nums1[p1++];
//                } else {
//                    second = nums2[p2++];
//                }
//            }
//            if ((len1 + len2) % 2 == 0) {
//                return (first + second) / 2.0;
//            } else {
//                return second;
//            }
        }

        /**
         * 分别切割A和B数组
         * 使用二分法
         */
        public double f(int[] A, int[] B) {
            if (A.length == 0 && B.length == 0) {
                throw new IllegalArgumentException("no answer");
            }
            int m = A.length, n = B.length;
            // 对较短的数组进行切割
            if (m > n) {
                return f(B, A);
            }
            // i和j为数组A和B的切割位置
            // 0<=i<=m, 0<=j<=n
            // i和j之间有联动关系
            // 当m+n为偶数时，i+j = (m+n)/2, 由于m+n为偶数，可以转化为 i+j = (m+n+1)/2
            // 当m+n为奇数时，i+j-1 = (m+n)/2, 由于m+n为奇数，也可以转化为 i+j = (m+n+1)/2
            // 比较A[i-1]和B[j]，比较B[j-1]和A[i]
            int iMin = 0, iMax = m;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = (m + n + 1) / 2 - i;
                if (i > 0 && j < n && A[i - 1] > B[j]) {
                    iMax = i - 1;
                } else if (j > 0 && i < m && B[j - 1] > A[i]) {
                    iMin = i + 1;
                } else {
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = B[j - 1];
                    } else if (j == 0) {
                        maxLeft = A[i - 1];
                    } else {
                        maxLeft = Math.max(A[i-1], B[j - 1]);
                    }
                    if (((m + n) & 1) == 1) {
                        return maxLeft;
                    }


                    int minRight = 0;
                    if (i == m) {
                        minRight = B[j];
                    } else if (j == n) {
                        minRight = A[i];
                    } else {
                        minRight = Math.min(A[i], B[j]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }

            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
