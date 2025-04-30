/* pingpong game */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PongGame extends JPanel implements KeyListener, ActionListener {
    private int ballX = 160, ballY = 120, ballDirX = -1, ballDirY = -1;
    private int paddle1Y = 100, paddle2Y = 100;
    private int paddleWidth = 10, paddleHeight = 60;
    private Timer timer;
    private int score1 = 0, score2 = 0;
    private boolean gameOver = false;

    public PongGame() {
        this.setPreferredSize(new Dimension(320, 240));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 80, 120);
        } else {
            g.setColor(Color.YELLOW);
            g.fillRect(10, paddle1Y, paddleWidth, paddleHeight);
            g.setColor(Color.PINK);
            g.fillRect(300, paddle2Y, paddleWidth, paddleHeight);
            g.setColor(Color.WHITE);
            g.fillOval(ballX, ballY, 10, 10);
            g.drawString("Player A: " + score1, 10, 10);
            g.drawString("Player B: " + score2, 240, 10);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            ballX += ballDirX;
            ballY += ballDirY;

            if (ballX <= 20 && ballY >= paddle1Y && ballY <= paddle1Y + paddleHeight) {
                ballDirX = -ballDirX;
            } else if (ballX >= 300 && ballY >= paddle2Y && ballY <= paddle2Y + paddleHeight) {
                ballDirX = -ballDirX;
            } else if (ballX <= 0) {
                score2++;
                resetBall();
            } else if (ballX >= 310) {
                score1++;
                resetBall();
            }

            if (ballY <= 0 || ballY >= 230) {
                ballDirY = -ballDirY;
            }

            if (score1 == 5 || score2 == 5) {
                gameOver = true;
            }
            repaint();
        }
    }

    private void resetBall() {
        ballX = 160;
        ballY = 120;
        ballDirX = -ballDirX;
        ballDirY = -ballDirY;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W && paddle1Y > 0) {
            paddle1Y -= 10;
        }
        if (key == KeyEvent.VK_S && paddle1Y < getHeight() - paddleHeight) {
            paddle1Y += 10;
        }
        if (key == KeyEvent.VK_UP && paddle2Y > 0) {
            paddle2Y -= 10;
        }
        if (key == KeyEvent.VK_DOWN && paddle2Y < getHeight() - paddleHeight) {
            paddle2Y += 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        PongGame pongGame = new PongGame();
        frame.add(pongGame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
