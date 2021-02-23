package pixel;

import java.awt.*;

public class HealthyPixel extends Pixel
{
    public HealthyPixel(int row, int col, Color color, Color outlineColor)
    {
        super(row, col, color, outlineColor);
    }

    @Override
    public Color pixelCondition()
    {
        return this.color;
    }
}