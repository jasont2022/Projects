import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 * This class holds the primary game logic for how different objects interact
 * with one another, the layout for an Evil Hangman game, all the game
 * interactions happens here
 *
 * @author jasontran
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {
    private EvilHangman hangman; // the state of the game logic
    private int wordLength; // a valid word length
    private Words wordsSet; // a class responsible to provide words from a file to the AI
    private String name; // a string for the user name
    private JFrame frame; // a JFrame to be pass in
    private static BufferedImage img1; // an image field
    private static final int COURT_WIDTH = 800;
    private static final int COURT_HEIGHT = 600;

    /**
     * This method creates a new GameCourt, creates the initial state of the game
     * 
     * @param f a JFrame to be passed in
     */
    public GameCourt(JFrame f) {
        frame = f;
        name = inputUserName();
        wordsSet = new Words("files/dictionary.txt");
        wordLength = inputWordLength();
        hangman = new EvilHangman(wordsSet, wordLength);

        // read in image
        try {
            if (img1 == null) {
                img1 = ImageIO.read(new File("files/troll.png"));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setFocusable(true); // Enable keyboard focus on the court area

        // This key listener allows the characters to be typed
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key >= 65 && key <= 90) {
                    hangman.acceptGuess((char) key);
                    repaint(); // repaint the graphics / update the graphics after key press
                }
            }
        });
    }

    /**
     * This method enables the key type to be typed in the requested window
     */
    public void enableTpying() {
        // Make sure that this component has the keyboard focus
        // request focus in Game.java after GameCourt has been initialized
        requestFocusInWindow();
    }

    /**
     * This method will prompt the user for a valid input word length and keep
     * re-prompting the user if there is no valid input word length
     * 
     * @return the word length from the user input
     */
    public int inputWordLength() {
        boolean isValidWordLength = false; // there is no valid word length yet
        int wordLength = 0;
        while (!isValidWordLength) {
            String input = JOptionPane.showInputDialog(frame, 
                    "Please type in a valid word length to start the game",
                    "Input Word Length", JOptionPane.PLAIN_MESSAGE);
            try {
                wordLength = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame,
                        "Not a number, please re-enter a valid word length to start the game", 
                        "WELCOME",
                        JOptionPane.PLAIN_MESSAGE);
            }
            if (wordsSet.isValidWordLength(wordLength)) {
                isValidWordLength = true; // there is a valid word proceed and exit the loop
            }
        }
        return wordLength;
    }

    /**
     * This method will prompt the user for an input name the input name can consist
     * of any characters
     * 
     * @return the name from the user input
     */
    public String inputUserName() {
        // change display of JOptionPane
        UIManager.put("OptionPane.background", Color.black);
        UIManager.put("OptionPane.messageForeground", Color.red);
        UIManager.put("Panel.background", Color.black);
        UIManager.put("OptionPane.messageFont", 
                new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));

        String userName = JOptionPane.showInputDialog(frame, 
                "Please type in your name to start the game", 
                "Input Name",
                JOptionPane.PLAIN_MESSAGE);
        return userName;
    }

    /**
     * Reset the game to its initial state, re-prompting the word length Routing the
     * variables to the right calls
     */
    public void reset() {
        name = inputUserName(); // ask the user to retype his/her name again
        wordLength = inputWordLength(); // just call inputWordLength() to re-prompt
        hangman = new EvilHangman(wordsSet, wordLength); // creates a new game state

        setFocusable(true);
        requestFocusInWindow(); // Make sure that this component has the keyboard focus
        repaint(); // repaint the graphics
    }

    /**
     * This method saves the current state of the game into a file
     */
    public void save() {
        String userName = name;
        int guessesLeft = hangman.getNumGuessesLeft();
        String currentBoard = hangman.getCurrentBoard();
        SaveAndLoad.writeStateToFile(
                userName, 
                guessesLeft, 
                currentBoard, 
                "files/progress.txt", 
                false);
    }

    /**
     * This method loads a current state of a game from a file to the game, If there
     * is nothing to load then don't load and display a message to tell user to exit
     * the current game
     */
    public void load() {
        String state = SaveAndLoad.readStateToGame("files/progress.txt");
        if (state == null) {
            JOptionPane.showMessageDialog(frame,
                    "The load was unsuccessful, please exit the current game and start a new one", 
                    "Error Cannot Load",
                    JOptionPane.ERROR_MESSAGE);
            // exit the game when user presses "okay"
            System.exit(0);
        }
        // make sure the wordSet is correct
        String[] toState = state.split(",");
        name = toState[0];
        hangman = new EvilHangman(wordsSet, toState[2].length()); // creates a new game state
        int numGuesses = Integer.parseInt(toState[1]);
        hangman.setNumGuessesLeft(numGuesses);
        hangman.setCurrentBoard(toState[2]);

        requestFocusInWindow(); // Make sure that this component has the keyboard focus
        repaint(); // repaint the graphics based in the loaded state
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gc = (Graphics2D) g;

        // draw background
        setBackground(Color.BLACK);
        gc.setColor(Color.RED); // change color to red

        // draw a line on top of screen
        gc.setStroke(new BasicStroke(5));
        gc.drawLine(0, 0, COURT_WIDTH, 0);

        // set up hang man station
        gc.setStroke(new BasicStroke(30));
        gc.drawLine(50, 550, 350, 550); // base
        gc.drawLine(300, 550, 300, 50); // pole
        gc.drawLine(300, 50, 150, 50); // left pole
        gc.drawLine(150, 50, 150, 150); // down pole

        // draw the current board
        String currentBoard = hangman.getCurrentBoard();
        gc.setFont(new Font(currentBoard, Font.PLAIN, 25));
        gc.drawString("Word:  " + currentBoard, 425, 50);

        // draw the number of guesses left
        String numGuesses = "" + hangman.getNumGuessesLeft();
        gc.drawString("Number of Guesses Left:  " + numGuesses, 425, 150);

        // handle all the drawing of the person and sound effects
        gc.setStroke(new BasicStroke(5));
        switch (hangman.getNumGuessesLeft()) {
            case 7:
                PlaySound.playSound("files/youmadbro0.wav"); // play sound
                break;
            case 6:
                PlaySound.playSound("files/yeet.wav"); // play sound
                break;
            case 5:
                PlaySound.playSound("files/youmadbro.wav"); // play sound
                break;
            case 3:
                PlaySound.playSound("files/lookatthisdude.wav"); // play sound
                break;
            case 2:
                PlaySound.playSound("files/windowserror.wav"); // play sound
                break;
            case 0:
                gc.drawLine(150, 450, 225, 500); // right leg
                PlaySound.playSound("files/sadviolin.wav"); // play music
                gc.drawString("Word:  " + hangman.revealWord(), 425, 50);
                gc.drawString("You Lose! Better Luck Time!", 425, 250);
                setFocusable(false); // no longer accepts keyboard input
                break;
            default:
                break;
        }
        if (hangman.getNumGuessesLeft() <= 5) {
            g.drawImage(img1, 80, 149, 130, 130, null); // draw image for head
        }
        if (hangman.getNumGuessesLeft() <= 4) {
            gc.drawLine(150, 263, 150, 450); // draw body
        }
        if (hangman.getNumGuessesLeft() <= 3) {
            gc.drawLine(75, 350, 150, 350); // draw left arm
        }
        if (hangman.getNumGuessesLeft() <= 2) {
            gc.drawLine(150, 350, 225, 350); // draw right arm
        }
        if (hangman.getNumGuessesLeft() <= 1) {
            gc.drawLine(150, 450, 75, 500); // left leg
        }
        if (hangman.getNumGuessesLeft() != 0 && !currentBoard.contains("_")) {
            gc.drawString("You Won! Congraulations!", 425, 250);
            setFocusable(false); // no longer accepts keyboard input
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}
