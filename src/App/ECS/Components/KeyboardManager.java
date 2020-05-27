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

    private SpriteComponent spriteComponent;

    public KeyboardManager() {}

    public KeyboardManager(SpriteComponent spriteComponent) {
        this.spriteComponent = spriteComponent;
    }

    KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            switch (e.getID()) {
                case KeyEvent.KEY_PRESSED : {
                    if(e.getKeyCode() == KeyEvent.VK_E) {
                        spriteComponent.setPosition(0);
                    }
                    if(e.getKeyCode() == KeyEvent.VK_Q) {
                        spriteComponent.setPosition(1);
                    }
                    if(e.getKeyCode() == KeyEvent.VK_A) {
                        spriteComponent.setPosition(2);
                    }
                    if(e.getKeyCode() == KeyEvent.VK_D) {
                        spriteComponent.setPosition(3);
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

