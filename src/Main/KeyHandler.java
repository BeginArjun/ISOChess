package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, rightPressed, leftPressed, downPressed, escPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                upPressed=true;
                System.out.println("Pressed");
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_ESCAPE:
                escPressed = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                upPressed=false;
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_ESCAPE:
                escPressed = false;
                break;
        }
    }
}
