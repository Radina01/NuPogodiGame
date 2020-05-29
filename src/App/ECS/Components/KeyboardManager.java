package App.ECS.Components;


import App.ECS.Component;
import App.ECS.Entity;
import App.NuPogodi;
import App.Rect;

import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardManager extends Component {

    private SpriteComponent spriteComponent;
    private PositionComponent position;
    private ColliderComponent collider;
    private int lastPosition;
    private List<Entity> catchPositions = NuPogodi.manager.getGroup(NuPogodi.groupLabels.groupCatchPosition.ordinal());

    public KeyboardManager() {
    }

    public KeyboardManager(SpriteComponent spriteComponent, PositionComponent positionComponent, ColliderComponent colliderComponent) {
        this.spriteComponent = spriteComponent;
        this.position = positionComponent;
        this.collider = colliderComponent;
        System.out.println(catchPositions.size());
    }

    KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            switch (e.getID()) {
                case KeyEvent.KEY_PRESSED: {
                    if (e.getKeyCode() == KeyEvent.VK_E) {
                        position.setPosition(1);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_Q) {
                        position.setPosition(0);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_A) {
                        position.setPosition(2);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_D) {
                        position.setPosition(3);
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
        if (lastPosition != position.getPosition()) {
            Rect r = catchPositions.get(position.getPosition()).getComponent(new TransformComponent()).getPosition();
            switch (position.getPosition()) {
                case 0:
                    spriteComponent.changeAnimationFrame(0, 0, false);
                    collider.setCollider(r);
                    break;
                case 1:
                    spriteComponent.changeAnimationFrame(0, 0, true);
                    collider.setCollider(r);
                    break;
                case 2:
                    spriteComponent.changeAnimationFrame(1, 0, false);
                    collider.setCollider(r);
                    break;
                case 3:
                    spriteComponent.changeAnimationFrame(1, 0, true);
                    collider.setCollider(r);
                    break;
            }
            System.out.println(r.x + " " + r.y + " " + r.width + " " + r.height + " " + position.getPosition());
            lastPosition = position.getPosition();
        }
    }

    @Override
    public void draw() {
    }

}

