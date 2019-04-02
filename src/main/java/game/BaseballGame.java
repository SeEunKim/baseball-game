import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	public static final int MAXNUMBER = 3;

	public static void main(String args[]) {

		while (true) {

			int strikeNum = 0;
			int[] input = new int[] { 0, 0, 0 };
			int[] answer = new int[] { 0, 0, 0 };
			int tmp;

			answer = createAnswer();
			System.out.printf("answer %d, %d, %d: \n", answer[0], answer[1], answer[2]);
			System.out.println("===== 새로운 게임 ===== \n");

			while (strikeNum != MAXNUMBER) {
				int ballNum = 0;
				tmp = isInvalid();
				input[0] = tmp / 100;
				input[1] = (tmp / 10) % 10;
				input[2] = tmp % 10;

				strikeNum = countStrike(answer, input);

				for (int i = 0; i < MAXNUMBER; i++) {
					ballNum += countBall(answer[i], i, input);
				}

				checkAnswer(strikeNum, ballNum);
				System.out.println("");
			}
			strikeNum = 0;
		}

	}

	public static int[] createAnswer() {
		int[] answer = new int[] { 0, 0, 0 };
		int randNum = 0;
		int location = 0;
		Random random = new Random();

		randNum = random.nextInt(9) + 1;
		answer[0] = randNum;

		while (location == 0) {
			randNum = random.nextInt(9) + 1;

			if (answer[0] != randNum) {
				answer[1] = randNum;
				location++;
			}
		}

		while (location == 1) {
			randNum = random.nextInt(9) + 1;

			if (answer[0] != randNum && answer[1] != randNum) {
				answer[2] = randNum;
				location++;
			}
		}
		return answer;
	}

	public static int isInvalid() {
		Scanner scanner = new Scanner(System.in);
		int tmp = 0;
		int result = 0;

		System.out.println("숫자를 입력해주세요 ex)123 : ");
		while (result != 2) {
			tmp = scanner.nextInt();
			result = checkLength(tmp) + checkDuplicateNumber(tmp);

			if (result != 2) {
				System.out.println("중복되지 않은 세 자리 숫자를 입력해주세요.");
			}
		}
		return tmp;
	}

	public static int checkLength(int number) {

		if ((number < 100) || (number >= 1000)) {
			return 0;
		} else {
			return 1;
		}
	}

	public static int checkDuplicateNumber(int number) {
		int tmp[] = new int[] { 0, 0, 0 };

		tmp[0] = number / 100;
		tmp[1] = (number / 10) % 10;
		tmp[2] = number % 10;

		if ((tmp[0] != tmp[1]) && (tmp[0] != tmp[2]) && (tmp[1] != tmp[2])) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int countStrike(int answer[], int input[]) {
		int strikeNum = 0;
		for (int i = 0; i < MAXNUMBER; i++) {
			if (answer[i] == input[i]) {
				strikeNum++;
			}
		}
		return strikeNum;
	}

	public static int countBall(int answer, int location, int input[]) {
		int ballNum = 0;
		for (int i = 0; i < MAXNUMBER; i++) {
			if ((answer == input[i]) && (i != location)) {
				ballNum = 1;
				break;
			} else if ((answer == input[i]) && (i == location)) {
				ballNum = 0;
				break;
			}
		}
		return ballNum;
	}

	public static void checkAnswer(int strikeNum, int ballNum) {
		if (strikeNum != 0) {
			System.out.printf("%d 스크라이크 \n", strikeNum);
		}

		if (strikeNum == MAXNUMBER) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료 \n");
			return;
		}

		if (ballNum != 0) {
			System.out.printf("%d 볼 ", ballNum);
		} else if ((strikeNum == 0) && (ballNum) == 0) {
			System.out.println("낫싱 ");
		}
	}

}
