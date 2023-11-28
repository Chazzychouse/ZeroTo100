import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI
{

	public UI()
	{

		JFrame frame = new JFrame("Zero To 100!");

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 2));
		contentPane.setPreferredSize(new Dimension(500, 200));

		JButton startButton = new JButton("Play");
		startButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false); //you can't see me!
				frame.pack();
				new Game();

			}
		});

		JButton exitButton = new JButton("Quit");
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		JLabel title = new JLabel("Zero to 100!");
		title.setHorizontalAlignment(JLabel.CENTER);

		contentPane.add(startButton);
		contentPane.add(exitButton);
		contentPane.add(title, BorderLayout.CENTER);

		frame.add(contentPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
