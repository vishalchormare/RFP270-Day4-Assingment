package day4basic;

public class SnakeLadder {

	static int player1Position = 0;
	static int player2Position = 0;
	static final int NO_PLAY = 1;
	static final int LADDER = 2;
	static final int SNAKE = 3;

	static final int WIN_POSITION = 100;

	static final int START_POSITION = 0;

	private static int dieRoll() {
		int dieValue = (int) (Math.random() * 10 % 6) + 1;
		return dieValue;
	}

	private static int getOption() {
		int option = (int) (Math.random() * 10 % 3) + 1;
		return option;
	}

	public static void main(String[] args) {

		int diceCount = 0;
		int playerChance = 0;
		while (player1Position < WIN_POSITION && player2Position < WIN_POSITION) {
			int dieValue = dieRoll();
			diceCount++;
			System.out.println("Die:" + dieValue);
			int option = getOption();
			System.out.println("Option:" + option);
			if (playerChance % 2 == 0) {
				switch (option) {
				case NO_PLAY:
					System.out.println("No Play");
					break;
				case LADDER:
					if (player2Position + dieValue <= WIN_POSITION)
						player2Position = player2Position + dieValue;
					break;
				case SNAKE:
					player2Position = player2Position - dieValue;
					if (player2Position < START_POSITION)
						player2Position = START_POSITION;
					break;
				default:
					System.out.println("wrong option");

				}

				System.out.println("Position Player 2: " + player2Position);
				if (player2Position == WIN_POSITION)
					System.out.println("Player 2 won the game!!");
			} else {
				switch (option) {
				case NO_PLAY:
					System.out.println("No Play");
					break;
				case LADDER:
					if (player1Position + dieValue <= WIN_POSITION)
						player1Position = player1Position + dieValue;
					break;
				case SNAKE:
					if (player1Position - dieValue < START_POSITION)
						player1Position = 0;
					else
						player1Position = player1Position - dieValue;
					break;
				default:
					System.out.println("wrong option");

				}
				System.out.println("Position Player 1: " + player1Position);
				if (player1Position == WIN_POSITION)
					System.out.println("Player 1 won the game!!");
			}
			playerChance++;
		}
		System.out.println("Dice Count :" + diceCount);

	}

}
