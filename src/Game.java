import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI, connects all
 * menus, and provides transition from menus, the backbone of the game
 *
 * @author jasontran
 */
public class Game implements Runnable {
    private JFrame frame; // a JFrame or window for the game
    private JPanel menu; // the main menu for the game

    public void run() {
        frame = new JFrame("Evil Hangman"); // create a single new frame

        launchMenu(); // launch the main menu

        // Put the frame on the screen
        frame.setLocation(300, 300);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * This method helps launch the main menu for the game, puts it on the frame
     */
    private void launchMenu() {
        menu = new GameMenu();
        frame.add(menu);

        final JButton play = new MyButton("PLAY", 150, 100);
        final JButton help = new MyButton("HELP", 150, 100);
        final JButton quit = new MyButton("QUIT", 150, 100);

        // launch the game
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchGame();
            }
        });
        // go to help menu
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchHelp();
            }
        });
        // quit the game
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        play.setBounds(325, 150, 150, 100);
        help.setBounds(325, 300, 150, 100);
        quit.setBounds(325, 450, 150, 100);

        menu.add(play);
        menu.add(help);
        menu.add(quit);
    }

    /**
     * This method helps launch the help menu for the game, puts it on the frame and
     * remove the main menu off the frame
     */
    private void launchHelp() {
        final JPanel helpMenu = new HelpMenu();
        frame.add(helpMenu);
        frame.remove(menu);

        final JButton menu = new MyButton("RETURN", 100, 50);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchMenu();
                frame.remove(helpMenu);
            }
        });
        menu.setBounds(325, 450, 150, 100);
        helpMenu.add(menu);
    }

    /**
     * This method helps launch the game, puts it on the frame and remove the main
     * menu off the frame
     */
    private void launchGame() {
        final GameCourt court = new GameCourt(frame);
        frame.add(court, BorderLayout.CENTER);
        frame.remove(menu); // remove the menu from frame

        // Layout Buttons on the top of game
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.black);
        frame.add(controlPanel, BorderLayout.NORTH);

        final JButton menu = new MyButton("MENU", 100, 50);
        final JButton reset = new MyButton("RESET", 100, 50);
        final JButton save = new MyButton("SAVE", 100, 50);
        final JButton load = new MyButton("LOAD", 100, 50);
        final JButton quit = new MyButton("QUIT", 100, 50);

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchMenu();
                frame.remove(controlPanel);
                frame.remove(court);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                court.reset();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                court.save();
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                court.load();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // add button to panel
        controlPanel.add(menu);
        controlPanel.add(reset);
        controlPanel.add(save);
        controlPanel.add(load);
        controlPanel.add(quit);

        // enable typing in the game court area
        court.enableTpying();
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements
     * specified in Game and runs it
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}
