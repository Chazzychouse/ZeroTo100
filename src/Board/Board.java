package Board;

import Global.Colors;

public class Board
{

	private Space[][] layout = new Space[10][10];

	private int sum;

	private int spacesRemaining;

	private int maxSpace;

	public Board()
	{
		for (int i = 0; i < layout[0].length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				layout[i][j] = new Space();
			}
		}
	}

	public void DisplayBoard()
	{
		for (int i = 0; i < layout[0].length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				layout[i][j].DisplayCard();
				System.out.print("   ");
			}
			System.out.println();
		}

	}

	public void CalculateAndSetSumOfRemaining()
	{
		int sum = 0;
		for (int i = 0; i < layout[0].length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				if (!layout[i][j].isHasBeenSelected())
				{
					sum += layout[i][j].getCardFront();
				}
			}
		}

		this.sum = sum;
	}

	public void CalculateAndSetSpacesRemaining()
	{
		int count = 0;
		for (int i = 0; i < layout[0].length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				if (!layout[i][j].isHasBeenSelected())
				{
					count++;
				}
			}
		}
		spacesRemaining = count;
	}

	public void CalculateAndSetMaxValueRemaining()
	{
		int max = 0;
		for (int i = 0; i < layout[0].length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				if (!layout[i][j].isHasBeenSelected())
				{
					if (layout[i][j].getCardFront() > max)
					{
						max = layout[i][j].getCardFront();
					}
				}
			}
		}

		maxSpace = max;
	}

	public void CalculateAndSetAllStats()
	{
		CalculateAndSetMaxValueRemaining();
		CalculateAndSetSpacesRemaining();
		CalculateAndSetSumOfRemaining();
	}

	public void DisplayStats()
	{
		System.out.print(Colors.ANSI_YELLOW);
		System.out.println("Sum Remaining: " + Colors.ANSI_RESET + sum);
		System.out.print(Colors.ANSI_YELLOW);
		System.out.println("Spaces Remaining: " + Colors.ANSI_RESET + spacesRemaining);
		System.out.print(Colors.ANSI_YELLOW);
		System.out.println("Max Value Remaining: " + Colors.ANSI_RESET + maxSpace);
	}

	public void SelectAllCards()
	{
		for (int i = 0; i < layout[0].length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				layout[i][j].SelectCard();
			}
		}
	}

	public Space[][] getLayout()
	{
		return layout;
	}

	public void setLayout(Space[][] layout)
	{
		this.layout = layout;
	}

	public int getSum()
	{
		return sum;
	}

	public void setSum(int sum)
	{
		this.sum = sum;
	}

	public int getSpacesRemaining()
	{
		return spacesRemaining;
	}

	public void setSpacesRemaining(int spacesRemaining)
	{
		this.spacesRemaining = spacesRemaining;
	}

	public int getMaxSpace()
	{
		return maxSpace;
	}

	public void setMaxSpace(int maxSpace)
	{
		this.maxSpace = maxSpace;
	}
}
