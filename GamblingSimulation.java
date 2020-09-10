public class GamblingSimulation {
	// declare constant variable
	final int STAKE = 100;
	final int BET = 1;
	final int WINING_CASH = 150;
	final int LOOSING_CASH = 50;
	final int NO_OF_DAYS = 20;
	final int STAKE_PERCENTAGE = 50;
	int result;
	int dayResult = 0;

	public void getTotalAmountWinOrLost() {

		for (int day = 1; day <= NO_OF_DAYS; day++) {
			result = STAKE;
			while ((result != WINING_CASH) && (result != LOOSING_CASH)) {
				int randomCheck = (int) Math.floor(Math.random() * 10) % 2;

				if (randomCheck == 1) {
					result = result + BET;

				} else {
					result = result - BET;
				}

			}

			if (result == WINING_CASH) {
				dayResult = dayResult + 1;
				System.out.println("total Amount won in day:" + day + ": " + result);

			} else {
				dayResult = dayResult - 1;
				System.out.println("total amount lost in days:" + day + ": " + +result);
			}

		}
		int totalAmount = dayResult * STAKE_PERCENTAGE;

		if (totalAmount == 0) {
			System.out.println("---------------------------------------");
			System.out.println("No lost No win: "+totalAmount);
		} else if (totalAmount > 0) {
			System.out.println("---------------------------------------");

			System.out.println("you won total amount: " + totalAmount);
		} else {
			System.out.println("---------------------------------------");

			System.out.println("you lost total amount: " + Math.abs(totalAmount));
		}

	}

	public static void main(String[] args) {
		GamblingSimulation obj = new GamblingSimulation();
		obj.getTotalAmountWinOrLost();
	}

}
