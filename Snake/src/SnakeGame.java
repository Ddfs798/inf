import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class SnakeGame {

    // параметры окна
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 600;
    private static final int UNIT_SIZE = 20;
    private static final int GAME_UNITS = (WINDOW_HEIGHT*WINDOW_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    private int[] x = new int[GAME_UNITS];
    private int[] y = new int[GAME_UNITS];

    // параметры змейки и яблока
    private int bodyParts;
    private int appleX;
    private int appleY;
    private char direction = 'R';
    private boolean isRunning = false;
    private final Timer timer;

    // кнопкa
    private final JPanel gamePanel;
    private final JButton startButton;
    private int result;

    public SnakeGame() {
        JFrame gameFrame = new JFrame("Змейка");
        gameFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };


        gamePanel.setBackground(new Color(0x86AF86));


        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A:
                        if (direction != 'R')
                            direction = 'L';
                        break;
                    case KeyEvent.VK_D:
                        if (direction != 'L')
                            direction = 'R';
                        break;
                    case KeyEvent.VK_W:
                        if (direction != 'D')
                            direction = 'U';
                        break;
                    case KeyEvent.VK_S:
                        if (direction != 'U')
                            direction = 'D';
                        break;
                }
            }
        });


        startButton = new JButton("Начать игру");
        startButton.addActionListener(e -> {startGame();
            gamePanel.requestFocus();
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xFF658365, true));
        buttonPanel.add(startButton);

        gameFrame.add(gamePanel, BorderLayout.CENTER);
        gameFrame.add(buttonPanel, BorderLayout.SOUTH);
        gameFrame.setVisible(true);

        // частота смены кадров (фпс)
        int delay = 70;
        timer = new Timer(delay, e -> {
            if (isRunning) {
                move();
                checkApple();
                checkCollisions();
                gamePanel.repaint();
            }
        });

    }

    private void startGame() {
        result = 0;
        bodyParts = 3;
        direction = 'R';
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        spawnApple();
        isRunning = true;
        timer.start();
    }
    private void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            result++;
            spawnApple();
        }
    }

    private void spawnApple() {
        int maxPossibleX = (WINDOW_WIDTH / UNIT_SIZE) - 10;
        int maxPossibleY = (WINDOW_HEIGHT / UNIT_SIZE) - 10;

        int randomX = (int) (Math.random() * maxPossibleX) * UNIT_SIZE;
        int randomY = (int) (Math.random() * maxPossibleY) * UNIT_SIZE;

        appleX = randomX;
        appleY = randomY;
    }

    private void checkCollisions() {
        // Проверка столкновений с границами окна и с телом змейки
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                isRunning = false; // Игра окончена
                break;
            }
        }
        if (x[0] < 0 || x[0] >= WINDOW_WIDTH || y[0] < 0 || y[0] >= WINDOW_HEIGHT) {
            isRunning = false; // Игра окончена
        }
        if (!isRunning) {
            timer.stop(); // Остановка таймера при конце игры
            showGameOverDialog(); // Отображение диалогового окна с результатом игры
            startButton.setEnabled(true); // Включение кнопки "Начать игру"
        }
    }


    private void showGameOverDialog() {
        JOptionPane.showMessageDialog(gamePanel, "Игра окончена,\nваш результат: " + result, "Результат", JOptionPane.INFORMATION_MESSAGE);
    }

    private void draw(Graphics g) {
        if (isRunning) {
            // Отрисовка яблока
            g.setColor(new Color(0xC44343));
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Отрисовка змейки
            for (int i = 0; i < bodyParts; i++) {
                if (i % 2 == 0) {
                    g.setColor(new Color(0x852091)); // Тело змейки
                } else {
                    g.setColor(new Color(0xAF59D5)); // Тело змейки
                }
                if (i == 0){
                    g.setColor(new Color(0x4A1352)); // Голова змейки
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}