import Board.Board;
import Global.Colors;
import Players.Computer1;
import Players.Computer2;
import Players.Player;
import java.util.stream.Stream;

public class Game
{
	private Board board;

	private Player player;

	private Computer1 computer1;

	private Computer2 computer2;

	private boolean gameOver;

	private String winner;

	public Game()
	{
		board = new Board();
		board.CalculateAndSetAllStats();
		player = new Player();
		computer1 = new Computer1();
		computer2 = new Computer2();
		gameOver = false;

		while (!gameOver)
		{
			DisplayBoardWithStats();
			PlayRound();
			DisplayRoundStats();
			DisplayScores();
			board.CalculateAndSetAllStats();
			CheckIfGameIsOver();
		}

		PrintWinner();

		try
		{
			Thread.sleep(1200);
		}
		catch (InterruptedException ignored)
		{

		}

		System.out.println(Colors.ANSI_YELLOW + "Goodbye!" + Colors.ANSI_RESET);
		System.exit(0);

	}

	public void PlayRound()
	{
		player.SelectSpacesForTurn(board);
		computer1.SelectSpacesForTurn(board);
		computer2.SelectSpacesForTurn(board);
	}

	public void DisplayRoundStats()
	{
		System.out.println(Colors.ANSI_GREEN + "Player Numbers Selected: " + Colors.ANSI_RESET
				+ player.getNumbersRevealed()[0] + " "
				+ player.getNumbersRevealed()[1] + " "
				+ player.getNumbersRevealed()[2]);

		if (player.isBonusTurn())
		{
			System.out.println(Colors.ANSI_WHITE + "Bonus Earned! Score x2" + Colors.ANSI_RESET);
		}
		else
		{
			System.out.println(Colors.ANSI_WHITE + "No Bonus :(" + Colors.ANSI_RESET);
		}

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}

		System.out.println(Colors.ANSI_RED + "CPU1 Numbers Selected: " + Colors.ANSI_RESET
				+ computer1.getNumbersRevealed()[0] + " "
				+ computer1.getNumbersRevealed()[1] + " "
				+ computer1.getNumbersRevealed()[2]);

		if (computer1.isBonusTurn())
		{
			System.out.println(Colors.ANSI_WHITE + "Bonus Earned! Score x2" + Colors.ANSI_RESET);
		}
		else
		{
			System.out.println(Colors.ANSI_WHITE + "No Bonus :(" + Colors.ANSI_RESET);
		}

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}

		System.out.println(Colors.ANSI_PURPLE + "CPU2 Numbers Selected: " + Colors.ANSI_RESET
				+ computer2.getNumbersRevealed()[0] + " "
				+ computer2.getNumbersRevealed()[1] + " "
				+ computer2.getNumbersRevealed()[2]);

		if (computer2.isBonusTurn())
		{
			System.out.println(Colors.ANSI_WHITE + "Bonus Earned! Score x2" + Colors.ANSI_RESET);
		}
		else
		{
			System.out.println(Colors.ANSI_WHITE + "No Bonus :(" + Colors.ANSI_RESET);
		}

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}
	}

	public void DisplayScores()
	{
		System.out.println(Colors.ANSI_GREEN + "Player Score: " + Colors.ANSI_RESET
				+ player.getScore());

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}

		System.out.println(Colors.ANSI_RED + "CPU1 Score: " + Colors.ANSI_RESET
				+ computer1.getScore());

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}

		System.out.println(Colors.ANSI_PURPLE + "CPU2 Score: " + Colors.ANSI_RESET
				+ computer2.getScore() + Colors.ANSI_RESET);

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}
	}

	public void CheckIfGameIsOver()
	{
		int oneHundredCount = 0;

		if (player.getScore() >= 100)
		{
			oneHundredCount++;
			winner = "Player";
			gameOver = true;
		}

		if (computer1.getScore() >= 100)
		{
			oneHundredCount++;
			winner = "CPU1";
			gameOver = true;
		}

		if (computer2.getScore() >= 100)
		{
			oneHundredCount++;
			winner = "CPU2";
			gameOver = true;
		}

		if (oneHundredCount > 1)
		{
			if (player.getScore() > computer1.getScore() && player.getScore() > computer2.getScore())
			{
				winner = "Player";
			}
			else if (computer1.getScore() > player.getScore() && computer1.getScore() > computer2.getScore())
			{
				winner = "CPU1";
			}
			else
			{
				winner = "CPU2";
			}
		}
	}

	public void PrintWinner()
	{
		char incomplete = '░'; // U+2591 Unicode Character
		char complete = '█'; // U+2588 Unicode Character
		StringBuilder builder = new StringBuilder();
		Stream.generate(() -> incomplete).limit(37).forEach(builder::append);
		System.out.println(Colors.ANSI_YELLOW + "And the winner is......");
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

		try
		{
			Thread.sleep(800);
		}
		catch (InterruptedException ignored)
		{

		}

		switch (winner)
		{
			case "Player":
				System.out.print(Colors.ANSI_GREEN);
				break;
			case "CPU1":
				System.out.print(Colors.ANSI_RED);
				break;
			case "CPU2":
				System.out.print(Colors.ANSI_PURPLE);
				break;
		}

		System.out.println(winner + "!" + Colors.ANSI_RESET);

	}

	public void ShowBoardStats()
	{
		board.CalculateAndSetAllStats();
		board.DisplayStats();
	}

	public void DisplayBoardWithStats()
	{
		int count = 0;
		for (int i = 0; i < board.getLayout()[0].length; i++)
		{
			for (int j = 0; j < board.getLayout().length; j++)
			{
				board.getLayout()[i][j].DisplayCard();
				System.out.print("   ");
			}
			count++;
			if (count == 1)
			{
				System.out.print(Colors.ANSI_YELLOW + "           Sum Remaining: " + Colors.ANSI_RESET + board.getSum() );
			}
			else if (count == 2)
			{
				System.out.print(Colors.ANSI_YELLOW + "           Spaces Remaining: " +  Colors.ANSI_RESET+ board.getSpacesRemaining());
			}
			else if (count == 3)
			{
				System.out.print(Colors.ANSI_YELLOW + "           Max Value Remaining: " + Colors.ANSI_RESET + board.getMaxSpace());
			}
			else if (count == 5)
			{
				System.out.print(Colors.ANSI_GREEN + "           Player Score: " + Colors.ANSI_RESET + player.getScore());
			}
			else if (count == 6)
			{
				System.out.print(Colors.ANSI_RED + "           CPU1 Score: " + Colors.ANSI_RESET + computer1.getScore());
			}
			else if (count == 7)
			{
				System.out.print(Colors.ANSI_PURPLE + "           CPU2 Score: " + Colors.ANSI_RESET + computer2.getScore());

			}

			System.out.println();
			try
			{
				Thread.sleep(75);
			}
			catch (InterruptedException ignored)
			{

			}
		}

	}
}
