package pavel.demo.challenges;

public class AppleStockChallenge {

	public static void main(String[] args) {


		int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};

		System.out.println("Max profit is:" + getMaxProfit(stockPrices));
	}

	private static double getMaxProfit(int[] stockPrices){

		int buyPrice = stockPrices[0];
		int sellPrice = stockPrices[0];

		for (int timeSlot = 1; timeSlot < stockPrices.length; timeSlot++) {
			if(buyPrice > stockPrices[timeSlot]){
				buyPrice = stockPrices[timeSlot];
			}

			if(sellPrice < stockPrices[timeSlot]){
				sellPrice = stockPrices[timeSlot];
			}

		}

		return sellPrice - buyPrice;
	}
}
