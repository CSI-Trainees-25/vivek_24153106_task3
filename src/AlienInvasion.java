import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class AlienInvasion extends JPanel {

    class Block {
        int x;
        int y;
        int width;
        int height;
        Image img;
        boolean alive = true;
        boolean used = false;

        Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }

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
    ArrayList<Image> alienImage;

    int shipWidth = tileSize*2;
    int shipHeight = tileSize;
    int shipX = tileSize*columns/2 - tileSize;
    int shipY =  boardHeight - tileSize;

    Block ship;

    Timer gameLoop;

    public AlienInvasion(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(new Color(135, 255, 227));

        shipImage = new ImageIcon(getClass().getResource("/assets/ship.png")).getImage();
        alien = new ImageIcon(getClass().getResource("./assets/alien.png")).getImage();
        alien2 = new ImageIcon(getClass().getResource("./assets/alien2.png")).getImage();
        alien3 = new ImageIcon(getClass().getResource("./assets/alien3.png")).getImage();
        alienMonkey = new ImageIcon(getClass().getResource("./assets/alienMonkey.png")).getImage();
        alienDog = new ImageIcon(getClass().getResource("./assets/alienDog.png")).getImage();

        alienImage = new ArrayList<>();
        alienImage.add(alien);
        alienImage.add(alien2);
        alienImage.add(alien3);
        alienImage.add(alienDog);
        alienImage.add(alienMonkey);

        ship = new Block(shipX, shipY, shipWidth, shipHeight, shipImage);

        gameLoop = new Timer(1000/60, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(ship.img, ship.x, ship.y, ship.width, ship.height, null);
    }
}
