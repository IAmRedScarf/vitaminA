//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
// 滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1133 👎 0


package com.qiuyu.leetcode.editor.cn;


import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{1, -1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            return maxSlidingWindow202304040000000(nums, k);
        }

        public int[] maxSlidingWindow202304040000000(int[] nums, int k) {
            // 存储的是下标
            Deque<Integer> minStack = new LinkedList<>();
            for (int i = 0; i < k; ++i) {
                while (!minStack.isEmpty() && nums[minStack.peekLast()] <= nums[i]) {
                    minStack.pollLast();
                }
                minStack.add(i);
            }
            int[] res = new int[nums.length - k + 1];
            res[0] = nums[minStack.peekFirst()];
            for (int i = k; i < nums.length; ++i) {
                while (!minStack.isEmpty() && nums[minStack.peekLast()] <= nums[i]) {
                    minStack.pollLast();
                }
                minStack.add(i);
                while (!minStack.isEmpty() && minStack.peekFirst() < i - k + 1) {
                    minStack.pollFirst();
                }
                res[i - k + 1] = nums[minStack.peekFirst()];
            }
            return res;

        }




        public int[] maxSlidingWindow20230404(int[] nums, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr2[1] - arr1[1]);
            for (int i = 0; i < k; ++i) {
                pq.add(new int[]{i, nums[i]});
            }
            int[] res = new int[nums.length - k + 1];
            res[0] = pq.peek()[1];
            for (int i = k; i < nums.length; ++i) {
                while (!pq.isEmpty() && pq.peek()[0] < i - k + 1) {
                    pq.poll();
                }
                pq.add(new int[]{i, nums[i]});
                res[i - k + 1] = pq.peek()[1];
            }
            return res;
        }


        public int[] maxSlidingWindow_20220512_a(int[] nums, int k) {
            Deque<int[]> queue = new LinkedList<>();
            for (int i = 0; i < k; ++i) {
                while (!queue.isEmpty()) {
                    int tail = queue.peekLast()[1];
                    if (nums[i] > tail) {
                        queue.pollLast();
                    } else {
                        break;
                    }
                }
                queue.addLast(new int[]{i, nums[i]});
            }
            int[] res = new int[nums.length - k + 1];
            res[0] = queue.peekFirst()[1];
            int j = 1;
            for (int i = k; i < nums.length; ++i) {
                while (!queue.isEmpty()) {
                    int tail = queue.peekLast()[1];
                    if (nums[i] > tail) {
                        queue.pollLast();
                    } else {
                        break;
                    }
                }
                queue.addLast(new int[]{i, nums[i]});

                while (!queue.isEmpty() && queue.peekFirst()[0] < i - k + 1) {
                    queue.pollFirst();
                }
                res[j++] = queue.peekFirst()[1];
            }
            return res;

        }


        public int[] maxSlidingWindow_20220512(int[] nums, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            for (int i = 0; i < k; ++i) {
                pq.add(new int[]{i, nums[i]});
            }
            int[] res = new int[nums.length - k + 1];
            res[0] = pq.peek()[1];
            int j = 1;
            for (int i = k; i < nums.length; ++i) {
                pq.add(new int[]{i, nums[i]});
                while (!pq.isEmpty() && pq.peek()[0] < i - k + 1) {
                    pq.poll();
                }
                res[j++] = pq.peek()[1];
            }
            return res;
        }


        public int[] maxSlidingWindow_old(int[] nums, int k) {
            if (nums.length == 0 || k <= 0 || k > nums.length) {
                return new int[0];
            }
            PriorityQueue<IndexValue> pq = new PriorityQueue<>(IndexValue::compareTo);

            for (int i = 0; i < k - 1; ++i) {
                pq.offer(new IndexValue(i, nums[i]));
            }
            int[] result = new int[nums.length - k + 1];
            int j = 0;
            for (int i = k - 1; i < nums.length; ++i) {
                pq.offer(new IndexValue(i, nums[i]));
                while (!pq.isEmpty()) {
                    IndexValue cur = pq.peek();
                    if ((cur.index >= i - k + 1) && cur.index <= i) {
                        result[j++] = cur.value;
                        break;
                    } else {
                        pq.poll();
                    }
                }
            }
            return result;
        }

        class IndexValue implements Comparable {
            public Integer index;
            public Integer value;

            public IndexValue(Integer index, Integer value) {
                this.index = index;
                this.value = value;
            }

            @Override
            public int compareTo(Object o) {
                IndexValue obj = (IndexValue) o;
                if (this.value < obj.value) {
                    return 1;
                } else if (this.value.equals(obj.value)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
