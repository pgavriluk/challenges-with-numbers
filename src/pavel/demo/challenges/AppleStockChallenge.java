package pavel.demo.challenges;

public class AppleStockChallenge {

	public static void main(String[] args) {


		int[] stockPrices = new int[] {10, 7, 3, 8, 10, 9, 1, 3, 5, 9};

		System.out.println("Max profit is: " + getMaxProfit(stockPrices));
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
}
