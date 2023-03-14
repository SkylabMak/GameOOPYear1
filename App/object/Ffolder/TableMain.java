package App.object.Ffolder;

import App.object.Tile;

public abstract class TableMain {
    public Tile[][] tile;

    public Tile[][] getTile() {
        return tile;
    };

    public abstract Tile[][] returnTable();
}
