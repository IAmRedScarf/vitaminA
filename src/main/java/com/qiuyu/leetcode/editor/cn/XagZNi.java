//给定一个整数数组 asteroids，表示在同一行的小行星。 
//
// 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰
//撞。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 示例 4： 
//
// 
//输入：asteroids = [-2,-1,1,2]
//输出：[-2,-1,1,2]
//解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
//
// 
//
// 注意：本题与主站 735 题相同： https://leetcode-cn.com/problems/asteroid-collision/ 
// Related Topics 栈 数组 👍 39 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class XagZNi {
    public static void main(String[] args) {
        Solution solution = new XagZNi().new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{5, 10, -5})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            List<Integer> res = new ArrayList<>();
            int i = 0;
            for (; i < asteroids.length; ++i) {
                if (asteroids[i] > 0) {
                    break;
                }
                if (asteroids[i] < 0) {
                    res.add(asteroids[i]);
                }
            }
            Deque<Integer> stack = new LinkedList<>();
            for (; i < asteroids.length; ++i) {
                int cur = asteroids[i];
                if (cur  < 0) {
                    if (stack.isEmpty()) {
                        res.add(cur);
                    } else {
                        boolean flag = true;
                        while (!stack.isEmpty()) {
                            int top = stack.peekLast();
                            if (top == Math.abs(cur)) {
                                stack.pollLast();
                                flag = false;
                                break;
                            } else if (top < Math.abs(cur)) {
                                stack.pollLast();
                            } else {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            res.add(cur);
                        }
                    }
                } else if (cur > 0) {
                    stack.addLast(cur);
                }
            }
            while (!stack.isEmpty()) {
                res.add(stack.pollFirst());
            }
            int[] arrayRes = new int[res.size()];
            for (int j = 0; j < arrayRes.length; ++j) {
                arrayRes[j] = res.get(j);
            }
            return arrayRes;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
