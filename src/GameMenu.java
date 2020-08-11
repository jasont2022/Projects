import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class is responsible for creating a new game menu by extending JPanel
 * 
 * @author jasontran
 */
@SuppressWarnings("serial")
public class GameMenu extends JPanel {
    private static final int MENU_WIDTH = 800;
    private static final int MENU_HEIGHT = 650;
    private BufferedImage img1; // an image field
    private BufferedImage img2; // another image field
    private BufferedImage img3; // a third image field

    /**
     * This constructor creates a new game menu and reads in multiple images
     */
    public GameMenu() {
        setLayout(null); // for setting widget location

        // read in image
        try {
            if (img1 == null) {
                img1 = ImageIO.read(new File("files/troll.png"));
            }
            if (img2 == null) {
                img2 = ImageIO.read(new File("files/takethatl.png"));
            }
            if (img3 == null) {
                img3 = ImageIO.read(new File("files/troll2.png"));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
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
        g.drawString("EVIL HANGMAN", 200, 100);

        Font fnt1 = new Font("arial", Font.PLAIN, 40);
        g.setFont(fnt1);
        g.drawString("By Jason Tran", 10, 635);

        // draw texts
        Font fnt2 = new Font("Times New Roman", Font.ITALIC, 30);
        g.setFont(fnt2);
        g.drawString("Problem?", 120, 330);

        // draw images
        g.drawImage(img1, 95, 170, 150, 150, null);
        g.drawImage(img2, 480, 225, 300, 200, null);
        g.drawImage(img3, 95, 400, 150, 150, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MENU_WIDTH, MENU_HEIGHT);
    }
}
