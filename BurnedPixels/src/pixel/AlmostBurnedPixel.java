package pixel;

import java.awt.*;

public class AlmostBurnedPixel extends Pixel
{
    public AlmostBurnedPixel(int row, int col, Color color, Color outlineColor)
    {
        super(row, col, color, outlineColor);
    }

    @Override
    public Color pixelCondition()
    {
        return this.color = Color.BLACK;
    }
}