package pixel;

import java.awt.*;

public abstract class Pixel
{
    public static final int PIXEL_SIZE = 25;

    protected int row;
    protected int col;
    protected Color color;
    protected Color outlineColor;

    public Pixel(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    public void renderPixel(Graphics g)
    {
        int tileX = this.col * PIXEL_SIZE;
        int tileY = this.row * PIXEL_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, PIXEL_SIZE, PIXEL_SIZE);

        g.setColor(this.outlineColor);
        g.drawRect(tileX, tileY, PIXEL_SIZE, PIXEL_SIZE);
    }

    public abstract Color pixelCondition();
}