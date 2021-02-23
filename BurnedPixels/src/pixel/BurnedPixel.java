package pixel;

import java.awt.*;

public class BurnedPixel extends Pixel
{
    public BurnedPixel(int row, int col, Color color, Color outlineColor)
    {
        super(row, col, color, outlineColor);
    }

    @Override
    public Color pixelCondition()
    {
        return this.color = Color.BLACK;
    }
}