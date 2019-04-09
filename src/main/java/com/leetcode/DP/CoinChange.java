package com.leetcode.DP;


/**
 * 给一些硬币，比如 1, 2, 3, 5, 10 给出一种组合使得加起来等于某个数字，且组合使用的硬币最少
 * 多思考...
 */
public class CoinChange {

    private static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        int[] minNumber = new int[amount + 1];//从1 -> amount

        //i代表当前的金额
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            //j 代表硬币数组 {1, 2, 3, 5, 10}的下标
            for (int j = 0; j < coins.length; j++) {
                int temp = i - coins[j];//当前目标金额减去当前硬币金额
                if (coins[j] < i && minNumber[temp] != Integer.MAX_VALUE) {
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[temp]);
                }
            }
        }
        if (minNumber[amount]  == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minNumber[amount];
        }
    }


}
