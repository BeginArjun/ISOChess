package Constants;

import java.awt.*;

public class Constants {
    public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int originalTileSize = 32;
    public static int scale = 3;
    public static int tileSize = originalTileSize * scale;
}
