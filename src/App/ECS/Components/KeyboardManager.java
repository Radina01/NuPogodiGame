package App.ECS.Components;

import App.Display;
import App.ECS.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class KeyboardManager extends Component {


    public KeyboardManager() {}

    KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            switch (e.getID()) {
                case KeyEvent.KEY_PRESSED : {
                    if(e.getKeyCode() == KeyEvent.VK_W) {
                        System.out.println("asd");
                    }
                }
            }
            return false;
        }
    };


    @Override
    public void init() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw() {}

}

