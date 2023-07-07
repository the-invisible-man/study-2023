package Leet.Easy;

public class BuySellStock {
    public static void main(String[] args)
    {
        int[] prices = new int[]{2,4,1};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices)
    {
        int highestProfit = 0;
        int pist;
        int lowest = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            }

            pist = price - lowest;

            if (highestProfit < pist) {
                highestProfit = pist;
            }
        }

        return highestProfit;
    }
}
