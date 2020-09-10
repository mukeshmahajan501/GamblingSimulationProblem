public class GamblingSimulation {
	//declare constant variable
	final int STAKE = 100;
	final int BET = 1;
	final int WINING_CASH = 150;
	final int LOOSING_CASH = 50;
	final int NO_OF_DAYS = 30;

	int winArr[] = new int[NO_OF_DAYS];
	int lostArr[] = new int[NO_OF_DAYS];

	public void checkWinLoose() {

		for (int day = 0; day < NO_OF_DAYS; day++) {
			int winCount = 0;
			int lostCount = 0;
			int result = STAKE;
			while ((result != WINING_CASH) && (result != LOOSING_CASH)) {
				int randomCheck = (int) Math.floor(Math.random() * 10) % 2;

				if (randomCheck == 1) {
					result = result + BET;
					winCount++;

				} else {
					result = result - BET;
					lostCount++;

				}

			}

			if (result == WINING_CASH) {
				System.out.println("you won the game");
				winArr[day] = winCount;
				System.out.println("total Amount won :" + winCount + " in day: " + (day + 1));
			} else {
				System.out.println("you lost the game");
				lostArr[day] = lostCount;
				System.out.println("total Amount lost: " + lostCount + " in day: " + (day + 1));
			}

		}

		int maxWin = 0;

		int luckyDay = 0;
		for (int day = 0; day < NO_OF_DAYS; day++) {
			if (winArr[day] > maxWin && winArr[day] != 0) {
				maxWin = winArr[day];
				luckyDay = day;
			}
		}

		System.out.println("your lukkiest day:" + (luckyDay + 1));

		int maxLost = 0;

		int unLuckyDay = 0;
		for (int day = 0; day < NO_OF_DAYS; day++) {
			if (lostArr[day] > maxLost && lostArr[day] != 0) {
				maxLost = lostArr[day];
				unLuckyDay = day;
			}
		}

		System.out.println("your unlukkiest day:" + (unLuckyDay + 1));

	}

	public static void main(String[] args) {
		GamblingSimulation obj = new GamblingSimulation();
		obj.checkWinLoose();

	}

}
