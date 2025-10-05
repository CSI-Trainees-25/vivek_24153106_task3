import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        int tileSize = 32;
        int rows = 16;
        int columns = 16;
        int boardWidth = tileSize*columns;
        int boardHeight = tileSize*rows;

        JFrame frame = new JFrame("Alien Invasion");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AlienInvasion alienInvasion = new AlienInvasion();
        frame.add(alienInvasion);
        frame.pack();
        alienInvasion.requestFocus();  
        frame.setVisible(true);
    }
}
