package Input;

import java.util.Scanner;
import Global.Colors;

public class Input
{

	public static Scanner get = new Scanner(System.in);

	public static int GetRowSelectionFromUser()
	{
		int x_coordinate = 0;
		do {
			if (x_coordinate < 0)
			{
				System.out.print(Colors.ANSI_YELLOW + "Enter a Row: ");
			}
			while (!get.hasNextInt()) {
				System.out.println("That's not a number!");
				get.next();
			}
			x_coordinate = get.nextInt();
			if (x_coordinate >= 0)
			{
				return x_coordinate;
			}
		} while (x_coordinate < 0);

		return x_coordinate;

	}

	public static int GetColumnSelectionFromUser()
	{
		int y_coordinate = 0;
		do {
			if (y_coordinate < 0)
			{
				System.out.print(Colors.ANSI_YELLOW + "Enter a Column: " + Colors.ANSI_RESET);
			}
			while (!get.hasNextInt()) {
				System.out.println("That's not a number!");
				get.next();
			}
			y_coordinate = get.nextInt();
			if (y_coordinate >= 0)
			{
				return y_coordinate;
			}
		} while (y_coordinate < 0);

		return y_coordinate;

	}

}


