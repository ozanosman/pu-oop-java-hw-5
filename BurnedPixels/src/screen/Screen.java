package screen;

import pixel.Pixel;

import java.awt.*;

public class Screen
{
    public final int PIXEL_SIDE_COUNT = 64;

    private Pixel[][] pixelCollection = new Pixel[PIXEL_SIDE_COUNT][PIXEL_SIDE_COUNT];

    private final String CEREAL_NUMBER_CHARACTER_COLLECTION = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private int PIXEL_COUNT = 4096;

    public String cerealNumberGenerator()
    {
        StringBuilder randomString = new StringBuilder(10);

        for (int i = 0 ; i < 10; i++)
        {
            int randomCharacter = (int) (Math.random() * CEREAL_NUMBER_CHARACTER_COLLECTION.length());

            randomString.append(CEREAL_NUMBER_CHARACTER_COLLECTION.charAt(randomCharacter));
        }

        return randomString.toString();
    }

    public void pixelCoordinates()
    {
        do
        {
            int row = getPixelCoordinates();
            int col = getPixelCoordinates();

            if (this.hasScreenPixel(row, col))
            {
                continue;
            }

            Color pixelColor = this.getPixelColor();

            this.pixelCollection[row][col] = new Pixel(row, col, pixelColor, Color.BLACK);

            PIXEL_COUNT--;
        }
        while(PIXEL_COUNT != 0);
    }

    public void renderPixel(Graphics g, int row, int col)
    {
        if (this.hasScreenPixel(row, col))
        {
            Pixel tile = this.getScreenPixel(row, col);
            tile.renderPixel(g);
        }
    }

    private Color getPixelColor()
    {
        int chance = (int) (Math.random() * 3);

        if (chance == 0)
        {
            return Color.RED;
        }
        else if (chance == 1)
        {
            return Color.GREEN;
        }

        return Color.BLUE;
    }

    private Pixel getScreenPixel(int row, int col)
    {
        return this.pixelCollection[row][col];
    }

    private boolean hasScreenPixel(int row, int col)
    {
        return this.getScreenPixel(row, col) != null;
    }

    private int getPixelCoordinates()
    {
        return (int) (Math.random() * 64);
    }
}