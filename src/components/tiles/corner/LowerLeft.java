package components.tiles.corner;

import asset.Asset;
import components.tiles.Tile;

public class LowerLeft extends Tile
{
    public LowerLeft()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(335, 351, 138, 137);
    }
}
