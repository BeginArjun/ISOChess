package Constants;

import java.awt.*;

public class Constants {
    // UI
    public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int originalTileSize = 32;
    public static int scale = 3;
    public static int tileSize = originalTileSize * scale;

    // GAME
    public static final int FPS = 60;

    // FONTS
    public static final Font menuFont = new Font("Arial", Font.PLAIN, 32);
    public static final Font titleFont = new Font("Arial", Font.BOLD, 64);
}
