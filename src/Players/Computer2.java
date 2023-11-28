package Players;

import Board.Board;
import Global.Colors;

import java.util.stream.Stream;

public class Computer2 extends Player
{
	public int [] SelectSpace(Board board)
	{
		int [] selection = new int[2];
		for (int i = 0; i < board.getLayout()[0].length; i++)
		{
			for (int j = 0; j < board.getLayout().length; j++)
			{
				if (!board.getLayout()[i][j].isHasBeenSelected())
				{
					selection[0] = i;
					selection[1] = j;

					return selection;
				}
			}
		}
		return selection;
	}

	public void SelectSpacesForTurn(Board board)
	{
		int [] selection1 = SelectSpace(board);
		board.getLayout()[selection1[0]][selection1[1]].setHasBeenSelected(true);
		board.getLayout()[selection1[0]][selection1[1]].setActivatedBy("CPU2");

		int [] selection2 = SelectSpace(board);

		board.getLayout()[selection2[0]][selection2[1]].setHasBeenSelected(true);
		board.getLayout()[selection2[0]][selection2[1]].setActivatedBy("CPU2");

		int [] selection3 = SelectSpace(board);

		board.getLayout()[selection3[0]][selection3[1]].setHasBeenSelected(true);
		board.getLayout()[selection3[0]][selection3[1]].setActivatedBy("CPU2");

		int value1 = board.getLayout()[selection1[0]][selection1[1]].getCardFront();
		int value2 = board.getLayout()[selection2[0]][selection2[1]].getCardFront();
		int value3 = board.getLayout()[selection3[0]][selection3[1]].getCardFront();

		int [] numbersRevealed = {value1, value2, value3};

		this.setNumbersRevealed(numbersRevealed);

		CalculateAndSetScoreThisTurn();

		char incomplete = '░'; // U+2591 Unicode Character
		char complete = '█'; // U+2588 Unicode Character
		StringBuilder builder = new StringBuilder();
		Stream.generate(() -> incomplete).limit(37).forEach(builder::append);
		System.out.println(Colors.ANSI_PURPLE + "Computer 2 Selecting");
		for(int i = 0; i < 37; i++)
		{
			builder.replace(i,i+1,String.valueOf(complete));
			String progressBar = "\r"+builder;
			System.out.print(progressBar);
			try
			{
				Thread.sleep(45);
			}
			catch (InterruptedException ignored)
			{

			}
		}
		System.out.println(Colors.ANSI_RESET);

	}
}
