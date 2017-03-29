package main.java;

public class Solution {

        private static int get_max_profit(int[] stockPrices) {

            if (stockPrices.length > 1) {
                int maxProfit = 0;
                int minProfit = stockPrices[1] - stockPrices[0];
                for (int outerTime = 0; outerTime < stockPrices.length; outerTime++) {
                    for (int innerTime = 0; innerTime < stockPrices.length; innerTime++) {
                        int earlierTime = Math.min(outerTime, innerTime);
                        int laterTime = Math.max(outerTime, innerTime);

                        int potentialProfit = stockPrices[laterTime] - stockPrices[earlierTime];
                        maxProfit = Math.max(maxProfit, potentialProfit);
                        minProfit = (potentialProfit == 0) ? minProfit : Math.max(minProfit, potentialProfit);
                    }
                }
                return (maxProfit == 0) ? minProfit : maxProfit;
            } else{
                return 0;
            }
        }

        public static void main(String[] args) {
            int[] testInput = {10, 7, 5, 4, 3, 2};
            System.out.println(get_max_profit(testInput));
        }
    }
