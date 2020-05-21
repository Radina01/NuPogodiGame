package App;

public class NuPogodi {

    Menu menu = new Menu();

    public void init() {
        Display.initInstance(600, 600, "Nu Pogodi");
        Display.getInstance().addGraphic(
                new TextureManager(50, 50, 300, 300, "assets\\sprite1.png")
        );
        menu.update();

    }

    public void update() {}
}
