package pavel.demo.challenges;

public class AppleStockChallenge {

	public static void main(String[] args) {


		int[] stockPrices = new int[] {10, 7, 3, 8, 10, 9, 1, 3, 5, 9};

		System.out.println("Max profit is: " + getMaxProfit(stockPrices));
		System.out.println("Max profit is: " + getMaxProfit2(stockPrices));
	}

	private static double getMaxProfit(int[] stockPrices){

		int buyPrice = stockPrices[0];
		int potentialBuyPrice = 0;
		int sellPrice = stockPrices[1];

		for (int timeSlot = 1; timeSlot < stockPrices.length-1; timeSlot++) {
			if(buyPrice > stockPrices[timeSlot]){
				potentialBuyPrice = stockPrices[timeSlot];
			}

			int potentialSellPrice = stockPrices[timeSlot+1];

			if(sellPrice < potentialSellPrice){
				sellPrice = potentialSellPrice;
				if(potentialBuyPrice < buyPrice){
					buyPrice = potentialBuyPrice;
				}
			} else if(potentialBuyPrice < buyPrice){
				if(potentialSellPrice - potentialBuyPrice > sellPrice - buyPrice){
					buyPrice = potentialBuyPrice;
					sellPrice = potentialSellPrice;
				}
			}

		}

		int profit = sellPrice - buyPrice;
		return profit > 0 ? profit : 0;
	}


	private static int getMaxProfit2(int[] stockPrices) {

		if (stockPrices.length < 2) {
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}

		// we'll greedily update minPrice and maxProfit, so we initialize
		// them to the first price and the first possible profit
		int minPrice = stockPrices[0];
		int maxProfit = stockPrices[1] - stockPrices[0];

		// start at the second (index 1) time
		// we can't sell at the first time, since we must buy first,
		// and we can't buy and sell at the same time!
		// if we started at index 0, we'd try to buy *and* sell at time 0.
		// this would give a profit of 0, which is a problem if our
		// maxProfit is supposed to be *negative*--we'd return 0.
		for (int i = 1; i < stockPrices.length; i++) {
			int currentPrice = stockPrices[i];

			// see what our profit would be if we bought at the
			// min price and sold at the current price
			int potentialProfit = currentPrice - minPrice;

			// update maxProfit if we can do better
			maxProfit = Math.max(maxProfit, potentialProfit);

			// update minPrice so it's always
			// the lowest price we've seen so far
			minPrice = Math.min(minPrice, currentPrice);
		}

		return maxProfit;
	}
}
