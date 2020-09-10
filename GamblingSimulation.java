
import java.util.Scanner;

public class GamblingSimulation {

	// constant variable declartion
	final int STAKE = 100;
	final int BET = 1;
	final int NO_OF_DAYS = 30;
	final int WINING_CASH = 150;
	final int LOOSING_CASH = 50;

	// array declaration
	int winArr[] = new int[NO_OF_DAYS];
	int lostArr[] = new int[NO_OF_DAYS];

	int totalAmount = 0;
	int sumOfWinCount = 0;
	int sumOfLostCount = 0;

	// get lukkiest and Unlukkiest days
	public void getLukyUnlukyDay() {
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
				System.out.println("total Amount won :" + winCount + "in day: " + (day + 1));
			} else {
				System.out.println("you lost the game");
				lostArr[day] = lostCount;
				System.out.println("total Amount lost: " + lostCount + "in day: " + (day + 1));
			}

		}

		int maxWin = 0;

		int luckyDay = 0;
		for (int day = 0; day < NO_OF_DAYS; day++) {
			if (winArr[day] > maxWin && winArr[day] != 0) {
				maxWin = winArr[day];
				luckyDay = day;
				sumOfWinCount = sumOfWinCount + winArr[day];
			}
		}

		System.out.println("your lukkiest day:" + (luckyDay + 1));

		int maxLost = 0;

		int unLuckyDay = 0;
		for (int day = 0; day < NO_OF_DAYS; day++) {
			if (lostArr[day] > maxLost && lostArr[day] != 0) {
				maxLost = lostArr[day];
				unLuckyDay = day;
				sumOfLostCount = sumOfLostCount + lostArr[day];
			}
		}

		System.out.println("your unlukkiest day:" + (unLuckyDay + 1));
		System.out.println();

		totalAmount = sumOfWinCount - sumOfLostCount;

		if (totalAmount > 0) {
			System.out.println("you won the total amount " + totalAmount);
		} else {
			System.out.println("you lost total amount: " + totalAmount);
		}
	}

	public void contionueGambling() {

		int totalMonth = 12;
		int month = 1;
		while (month != totalMonth) {
			Scanner sc = new Scanner(System.in);
			if (totalAmount < 0) {
				System.out.println("stop gambling!!you cant play!!");
				break;
			} else {
				System.out.println("Enter 1 to playe more Or enter any other number to stop playing");
				int num = sc.nextInt();

				if (num == 1) {
					totalAmount = 0;
					getLukyUnlukyDay();
				} else {
					System.out.println("exit");
				}
			}

			month++;
		}

	}

	public static void main(String[] args) {
		GamblingSimulation obj = new GamblingSimulation();
		obj.getLukyUnlukyDay();
		obj.contionueGambling();

	}

}
