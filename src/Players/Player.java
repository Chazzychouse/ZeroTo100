package Players;

import Board.Board;
import Global.Colors;
import Input.Input;
import Input.Validator;

public class Player
{
	private int score;

	private int [] numbersRevealed = new int[3];

	private boolean isBonusTurn;


	public Player()
	{
		score = 0;
		isBonusTurn = false;
	}


	private int[] SelectSpace()
	{
		int [] space = new int[2];

		System.out.print(Colors.ANSI_YELLOW + "Enter a Row: ");
		int row = Input.GetRowSelectionFromUser();

		System.out.print("Enter a Column: ");
		int column = Input.GetColumnSelectionFromUser();

		System.out.print(Colors.ANSI_RESET);

		space[0] = row;
		space[1] = column;

		return space;

	}

	public void SelectSpacesForTurn(Board board)
	{
		System.out.println(Colors.ANSI_CYAN + "First Selection!" + Colors.ANSI_RESET);

		int [] selection1 = SelectSpace();

		boolean isValidSpace = Validator.ValidateSpaceSelection(selection1[0], selection1[1], board);

		while (!isValidSpace)
		{
			System.out.println(Colors.ANSI_RED + "Invalid! Out of Bounds or Already Selected" + Colors.ANSI_RESET);
			selection1 = SelectSpace();
			isValidSpace = Validator.ValidateSpaceSelection(selection1[0], selection1[1], board);
		}

		board.getLayout()[selection1[0]][selection1[1]].setHasBeenSelected(true);
		board.getLayout()[selection1[0]][selection1[1]].setActivatedBy("PLAYER");

		System.out.println(Colors.ANSI_CYAN + "Second Selection!" + Colors.ANSI_RESET);

		int [] selection2 = SelectSpace();

		boolean isValidSpace2 = Validator.ValidateSpaceSelection(selection2[0], selection2[1], board);

		while (!isValidSpace2)
		{
			System.out.println(Colors.ANSI_RED + "Invalid! Out of Bounds or Already Selected" + Colors.ANSI_RESET);
			selection2 = SelectSpace();
			isValidSpace2 = Validator.ValidateSpaceSelection(selection2[0], selection2[1], board);
		}

		board.getLayout()[selection2[0]][selection2[1]].setHasBeenSelected(true);
		board.getLayout()[selection2[0]][selection2[1]].setActivatedBy("PLAYER");

		System.out.println(Colors.ANSI_CYAN + "Third Selection!" + Colors.ANSI_RESET);

		int [] selection3 = SelectSpace();

		boolean isValidSpace3 = Validator.ValidateSpaceSelection(selection3[0], selection3[1], board);

		while (!isValidSpace3)
		{
			System.out.println(Colors.ANSI_RED + "Invalid! Out of Bounds or Already Selected" + Colors.ANSI_RESET);
			selection3 = SelectSpace();
			isValidSpace3 = Validator.ValidateSpaceSelection(selection3[0], selection3[1], board);
		}

		board.getLayout()[selection3[0]][selection3[1]].setHasBeenSelected(true);
		board.getLayout()[selection3[0]][selection3[1]].setActivatedBy("PLAYER");

		numbersRevealed[0] = board.getLayout()[selection1[0]][selection1[1]].getCardFront();
		numbersRevealed[1] = board.getLayout()[selection2[0]][selection2[1]].getCardFront();
		numbersRevealed[2] = board.getLayout()[selection3[0]][selection3[1]].getCardFront();

		CalculateAndSetScoreThisTurn();
	}

	public void CalculateAndSetScoreThisTurn()
	{
		isBonusTurn = false;
		int baseScore = 0;
		int scoreMultiplier = 1;
		for (int i = 0; i < numbersRevealed.length; i++)
		{
			baseScore += numbersRevealed[i];
		}
		if ((numbersRevealed[0] == numbersRevealed[1] || numbersRevealed[0] == numbersRevealed[2]) || (numbersRevealed[1] == numbersRevealed[2]))
		{
			scoreMultiplier = 2;
			isBonusTurn = true;
		}
		else if ((numbersRevealed[1] == (numbersRevealed[0] + 1) && numbersRevealed[2] == (numbersRevealed[1] + 1)) || (numbersRevealed[1] == (numbersRevealed[0] - 1) && numbersRevealed[2] == (numbersRevealed[1] - 1)))
		{
			scoreMultiplier = 2;
			isBonusTurn = true;
		}

		int totalRoundScore = baseScore * scoreMultiplier;
		score += totalRoundScore;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int[] getNumbersRevealed()
	{
		return numbersRevealed;
	}

	public void setNumbersRevealed(int[] numbersRevealed)
	{
		this.numbersRevealed = numbersRevealed;
	}

	public boolean isBonusTurn()
	{
		return isBonusTurn;
	}

	public void setBonusTurn(boolean bonusTurn)
	{
		isBonusTurn = bonusTurn;
	}
}
