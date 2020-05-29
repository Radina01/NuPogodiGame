package App;

import App.ECS.Components.ColliderComponent;
import App.ECS.Components.TileComponent;
import App.ECS.Components.TransformComponent;
import App.ECS.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {

    private String mapFilePath;
    private int mapScale;
    private int tileSize;
    private int scaledSize;

    Map(final String mapFilePath, int mapScale, int tileSize) {
        this.mapFilePath = mapFilePath;
        this.mapScale = mapScale;
        this.tileSize = tileSize;
        this.scaledSize = mapScale * tileSize;
    }

    public void loadMap(final String path, int sizeY, int sizeX) {

        BufferedReader reader;
        String line;
        String[] words;

        try {
            reader = new BufferedReader(new FileReader(path));

            int a = 0;
            for (int i = 0; i < sizeY; i++) {
                line = reader.readLine();
                for (int j = 0; j < sizeX; j++) {
                    //addTile(a % 10, a/10, j*scaledSize, i * scaledSize);
                    a++;
                }
            }
            line = reader.readLine();
            for (int i = 0; i < sizeY; i++) {
                line = reader.readLine();
                words = line.split(",");
                for (int j = 0; j < sizeX; j++) {
                    if(words[j].equals("1")) {
                        Entity entity = NuPogodi.manager.addEntity();
                        entity.addComponent(new TransformComponent(j * scaledSize, i * scaledSize, scaledSize, scaledSize));
                        entity.addGroup(NuPogodi.groupLabels.groupStartPosition.ordinal());
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTile(int srcX, int srcY, int x, int y) {
        Entity entity = NuPogodi.manager.addEntity();
        entity.addComponent(new TileComponent(x, y, srcX, srcY, tileSize, mapScale, mapFilePath));
        entity.addGroup(NuPogodi.groupLabels.groupMap.ordinal());
    }




}
