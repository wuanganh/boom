package components.tiles.vertical;

import asset.Asset;
import components.tiles.Tile;

public class Vertical01 extends Tile
{
    public Vertical01()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(24, 506, 138, 137);
    }
}
