import java.awt.*;
import javax.swing.*;

/**
 * This class is responsible for creating a new help menu by extending JPanel
 * 
 * @author jasontran
 */
@SuppressWarnings("serial")
public class HelpMenu extends JPanel {
    private static final int MENU_WIDTH = 800;
    private static final int MENU_HEIGHT = 650;

    /**
     * This constructor creates a new help menu by extending JPanel
     */
    public HelpMenu() {
        setLayout(null); // for setting widget location

        // the instructions added to a JTextArea which is added to the JPanel
        String warning = "WARNING! There will be sound effects during game that are memes, please "
                + "turn off your volume if you don't want to hear! You have been warned! " + "\n";
        String welcome = "Welcome to Evil Hangman! You will be playing a game just like Hangman, "
                + "but you will be playing against the AI! " + 
                "See if you can beat the AI, good luck! " + "\n";
        String messageInstructions = "Instructions: Type in a valid letter character from a to " + 
                "z one at a time. "
                + "Press main menu button to return to the main menu "
                + "Press reset button to restart and enter a word length when prompt. "
                + "Press save button to save the state of the game. "
                + "Press load button to load a pervious state of the game from a file. "
                + "If you win or lose, press reset to play the game again or exit the game " + 
                "by pressing quit. Enjoy!";

        JTextArea instructions = new JTextArea(warning + welcome + messageInstructions);
        instructions.setBounds(150, 140, 500, 265);
        instructions.setBackground(Color.black);
        instructions.setForeground(Color.red);
        Font fnt1 = new Font("arial", Font.PLAIN, 16);
        instructions.setFont(fnt1);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setEditable(false);
        add(instructions);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw background
        setBackground(Color.BLACK);

        // title of game
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.RED);
        g.drawString("Help", 340, 100);

        Font fnt1 = new Font("arial", Font.PLAIN, 40);
        g.setFont(fnt1);
        g.drawString("By Jason Tran", 10, 635);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MENU_WIDTH, MENU_HEIGHT);
    }
}
