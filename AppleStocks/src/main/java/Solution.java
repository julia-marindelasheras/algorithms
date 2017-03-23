package main.java;

public class Solution {

        public static int get_max_profit(int[] stockPrices) {

            if (stockPrices.length > 1) {
                int maxProfit = 0;
                for (int outerTime = 0; outerTime < stockPrices.length; outerTime++) {
                    for (int innerTime = 0; innerTime < stockPrices.length; innerTime++) {
                        int earlierTime = Math.min(outerTime, innerTime);
                        int laterTime = Math.max(outerTime, innerTime);

                        // and use those to find the earlier and later prices
                        int earlierPrice = stockPrices[earlierTime];
                        int laterPrice = stockPrices[laterTime];

                        // see what our profit would be if we bought at the
                        // min price and sold at the current price
                        int potentialProfit = laterPrice - earlierPrice;

                        // update maxProfit if we can do better
                        maxProfit = Math.max(maxProfit, potentialProfit);
                    }
                }
                return maxProfit;
            } else{
                return 0;
            }
        }

        public static void main(String[] args) {
            int[] testInput = {10, 7, 5, 8, 11, 9};
            System.out.println(get_max_profit(testInput));
        }
    }
