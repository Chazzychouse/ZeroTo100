package Board;

import Global.Colors;

import java.util.Random;

public class Space
{
	Random random = new Random();
	private char cardBack = '*';

	private int cardFront;

	private boolean hasBeenSelected;

	private String activatedBy;

	public Space()
	{
		GenerateAndSetCardFront();
		hasBeenSelected = false;
	}

	private void GenerateAndSetCardFront()
	{
		cardFront = random.nextInt(9 - 1 + 1) + 1;
	}

	public void DisplayCard()
	{
		if (hasBeenSelected)
		{
			if (activatedBy.equalsIgnoreCase("PLAYER"))
			{
				System.out.print(Colors.ANSI_GREEN);
			}
			else if (activatedBy.equalsIgnoreCase("CPU1"))
			{
				System.out.print(Colors.ANSI_RED);
			}
			else if (activatedBy.equalsIgnoreCase("CPU2"))
			{
				System.out.print(Colors.ANSI_PURPLE);
			}

			System.out.print(cardFront);
			System.out.print(Colors.ANSI_RESET);

		}
		else
		{
			System.out.print(cardBack);
		}
	}

	public void SelectCard()
	{
		hasBeenSelected = true;
	}

	public char getCardBack()
	{
		return cardBack;
	}

	public void setCardBack(char cardBack)
	{
		this.cardBack = cardBack;
	}

	public int getCardFront()
	{
		return cardFront;
	}

	public void setCardFront(int cardFront)
	{
		this.cardFront = cardFront;
	}

	public boolean isHasBeenSelected()
	{
		return hasBeenSelected;
	}

	public void setHasBeenSelected(boolean hasBeenSelected)
	{
		this.hasBeenSelected = hasBeenSelected;
	}

	public String getActivatedBy()
	{
		return activatedBy;
	}

	public void setActivatedBy(String activatedBy)
	{
		this.activatedBy = activatedBy;
	}
}
