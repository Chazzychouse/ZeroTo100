package Input;

import Board.Space;
import Board.Board;

public class Validator
{


	public static boolean ValidateSpaceSelection(int x, int y, Board board)
	{
		Space[][] layout = board.getLayout();

		if ((x > 9 || x < 0) || (y > 9 || y < 0))
		{
			return false;
		}
		else
		{
			if (layout[x][y].isHasBeenSelected())
			{
				return false;
			}

			else return true;
		}
	}
}
