import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * This class is responsible for creating a custom button (a unique look) by
 * extending the JButton class
 * 
 * @author jasontran
 */
@SuppressWarnings("serial")
public class MyButton extends JButton {
	private int w; // the width of the button
	private int h; // the height of the button

	/**
	 * This Constructor creates a custom button
	 * 
	 * @param label  the button's name
	 * @param width  the button's width
	 * @param height the button's height
	 */
	public MyButton(String label, int width, int height) {
		super(label);
		w = width;
		h = height;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// set font
		Font font = new Font("Times New Roman", Font.PLAIN, 30);
		setFont(font);

		// add border and change word color
		setBorder(new LineBorder(Color.RED));
		setForeground(Color.RED);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(w, h);
	}

}
