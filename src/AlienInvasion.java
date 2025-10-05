import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class AlienInvasion extends JPanel implements ActionListener, KeyListener {
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
    int shipY =  boardHeight - 2*tileSize;
    int shipVelocityX = tileSize;
    Block ship;

    ArrayList<Block> alienArray;
    int alienWidth = tileSize*2;
    int alienHeight = tileSize;
    int alienX = tileSize;
    int alienY = tileSize;

    int alienRows = 2;
    int alienColumns = 3;
    int alienCount = 0;
    int alienVelocityX = 1;


    Timer gameLoop;

    public AlienInvasion(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.black);
        setFocusable(true );
        addKeyListener(this);

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

        alienArray = new ArrayList<Block>();

        gameLoop = new Timer(1000/60, this);
        createAliens();
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(ship.img, ship.x, ship.y, ship.width, ship.height, null);

        for(int i = 0; i < alienArray.size(); i++) {
            Block alien = alienArray.get(i);
            if(alien.alive) {
                g.drawImage(alien.img, alien.x, alien.y, alien.width, alien.height, null);
            }
        }
    }

     public void move() {
        //aliens
         for(int i = 0; i < alienArray.size(); i++) {
             Block alien = alienArray.get(i);
             if(alien.alive) {
                 alien.x += alienVelocityX;
             }
         }
     }

    public void createAliens() {
        Random random = new Random();
        for (int r = 0; r < alienRows; r++) {
            for (int c = 0; c < alienColumns; c++) {
                int randomImageIndex = random.nextInt(alienImage.size());
                Block alien = new Block(
                        alienX + c*alienWidth,
                        alienY + r*alienHeight,
                        alienWidth,
                        alienHeight,
                        alienImage.get(randomImageIndex));
                 alienArray.add(alien);
            }
        }
        alienCount = alienArray.size();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && ship.x - shipVelocityX >= 0) {
            ship.x -= shipVelocityX;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && ship.x + ship.width + shipVelocityX <= boardWidth) {
            ship.x += shipVelocityX;
        }
    }
}
