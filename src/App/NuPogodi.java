package App;

public class NuPogodi {

    Menu menu;

    public void init() {
        Display.initInstance(600, 600, "Nu Pogodi");
        Display.getInstance().addGraphic(
                new TextureManager(50, 50, 300, 300, "assets\\sprite1.png")
        );
        menu = new Menu();
        //menu.update();
        Display.getInstance().changePage(menu.pageManager.menuState);
    }

    public void update() {
        menu.update();
    }
}
