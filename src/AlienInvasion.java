import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class AlienInvasion extends JPanel {
    int tileSize = 32;
    int rows = 16;
    int columns = 16;
    int boardWidth = tileSize*columns;
    int boardHeight = tileSize*rows;

    Image shipImage;
    Image alien;
    Image alien2;
    Image alien3;
    Image alienMonkey;
    Image alienDog;


    public AlienInvasion(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(new Color(135, 255, 227));

        shipImage = new ImageIcon(getClass().getResource("/assets/ship.png")).getImage();
        alien = new ImageIcon(getClass().getResource("./assets/alien.png")).getImage();
        alien2 = new ImageIcon(getClass().getResource("./assets/alien2.png")).getImage();
        alien3 = new ImageIcon(getClass().getResource("./assets/alien3.png")).getImage();
        alienMonkey = new ImageIcon(getClass().getResource("./assets/alienMonkey.png")).getImage();
        alienDog = new ImageIcon(getClass().getResource("./assets/alienDog.png")).getImage();
    }
}
