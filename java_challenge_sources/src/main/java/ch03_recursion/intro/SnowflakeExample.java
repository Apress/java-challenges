package ch03_recursion.intro;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class SnowflakeExample
{
	public static void main(final String[] args)
	{
		final JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);

		final JPanel panel = new JPanel()
		{
			@Override
			public void paintComponent(final Graphics g)
			{
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				drawSnowflake(g, 300, 300, 200, 4);
			}
		};
		frame.add(panel);

		frame.setSize(600, 600);
		frame.setVisible(true);
	}

	public static void drawSnowflake(final Graphics graphis, final int startX, final int startY, final int length,
			final int depth)
	{
		for (int degree = 0; degree < 360; degree += 60)
		{
			final double rad = degree * Math.PI / 180;
			final int endX = (int) (startX + Math.cos(rad) * length);
			final int endY = (int) (startY + Math.sin(rad) * length);

			graphis.drawLine(startX, startY, endX, endY);

			// recursive descent
			if (depth > 0)
			{
				drawSnowflake(graphis, endX, endY, length / 4, depth - 1);
			}
		}
	}
}
