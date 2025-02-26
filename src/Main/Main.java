package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("ISOChess");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(true);
        window.setVisible(true);

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);
        window.pack();

        gamePanel.startGame();
    }
}