package UI;

import Main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class UIManager {
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final GamePanel gp;
    private final TitleScreen titleScreen;

    public UIManager(JFrame window) {
        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);

        this.gp = new GamePanel(this);
        this.titleScreen = new TitleScreen(this);

        cardPanel.add(gp, "GamePanel");
        cardPanel.add(titleScreen, "TitleScreen");

        window.add(cardPanel);
        window.pack();
        window.setVisible(true);

        showGamePanel();
    }

    public void showGamePanel() {
        titleScreen.stop();
        cardLayout.show(cardPanel, "GamePanel");
        gp.startGame();
        gp.requestFocusInWindow();
    }

    public void showTitleScreen() {
        gp.stopGame();
        titleScreen.start();
        gp.setVisible(false);
        titleScreen.setVisible(true);
        cardLayout.show(cardPanel, "TitleScreen");
        titleScreen.requestFocusInWindow();
    }
}
