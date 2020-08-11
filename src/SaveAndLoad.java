import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;

/**
 * This Class is responsible for saving and loading the state of the game The
 * class can read from a file and load into the game Also, the can write into a
 * file and save the current state of the game
 * 
 * @author jasontran
 */
public class SaveAndLoad {
    /**
     * This method will read in a line from the file and provide a string to the
     * current game
     * 
     * @param filePath a path to the desired file
     * @return a string to provide the game to take in the string and load the
     *         current state null if there is an IOException
     * @throw an IllegalArgumentException if the filePath is null or does not exist
     */
    public static String readStateToGame(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File Path is null!");
        }
        String state = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            state = br.readLine();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File is not found!");
        } catch (IOException e) {
            state = null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    state = null;
                }
            }
        }
        return state;
    }

    /**
     * Given a user name, the number of guesses left, and the current board, this
     * method writes those 3 parameters into a file. This method uses BufferedWriter
     * to carry out that task format: userName,guessesLeft,currentBoard
     * 
     * @param userName     a user name from the game
     * @param guessesLeft  the number of guesses left
     * @param currentBoard the current board in the game
     * @param filePath     a path to the desired file
     * @param append       a boolean indicating whether the new string should be
     *                     appended to the current file or should overwrite its
     *                     previous contents
     * @throw IllegalArgumentException if filePath is null or the file doesn't exist
     */
    public static void writeStateToFile(String userName, int guessesLeft, String currentBoard, 
            String filePath, boolean append) {
        File file = Paths.get(filePath).toFile();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, append));
            String write = userName + "," + guessesLeft + "," + currentBoard;
            bw.write(write);
            bw.newLine();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File is not found!");
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Internal Error:" + e.getMessage());
                }
            }
        }
    }
}
