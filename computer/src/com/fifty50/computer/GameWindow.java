package com.fifty50.computer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by samuel on 05.02.15.
 */
public class GameWindow implements KeyListener {
    public JPanel panel1;
    private Main main;


    public void init(Main main) {
        this.main = main;
        panel1.setFocusable(true);
        panel1.requestFocus();
        panel1.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //pass this over to main
        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:
                main.forward(Main.Speed.SLOW);
                break;
            case KeyEvent.VK_A:
                main.left(Main.Speed.SLOW);
                break;
            case KeyEvent.VK_S:
                main.backward(Main.Speed.SLOW);
                break;
            case KeyEvent.VK_D:
                main.right(Main.Speed.SLOW);
                break;

            case KeyEvent.VK_UP:
                main.forward(Main.Speed.FAST);
                break;
            case KeyEvent.VK_LEFT:
                main.left(Main.Speed.FAST);
                break;
            case KeyEvent.VK_DOWN:
                main.backward(Main.Speed.FAST);
                break;
            case KeyEvent.VK_RIGHT:
                main.right(Main.Speed.FAST);
                break;
            case KeyEvent.VK_ENTER:
                main.requestCalibration();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {

            //if the released key was an accelerating one, then brake; else just stop steering
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                main.brake();
                break;
            default:
                main.straight();
                break;
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
