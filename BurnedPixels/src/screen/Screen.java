package screen;

import pixel.AlmostBurnedPixel;
import pixel.BurnedPixel;
import pixel.HealthyPixel;
import pixel.Pixel;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Screen
{
    public final int PIXEL_SIDE_COUNT = 64;

    private Pixel[][] pixelCollection = new Pixel[PIXEL_SIDE_COUNT][PIXEL_SIDE_COUNT];

    public Pixel selectedPixel;

    private final String CEREAL_NUMBER_CHARACTER_COLLECTION = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private int PIXEL_COUNT = 4096;

    private int RANDOM_PIXEL_COUNT = ThreadLocalRandom.current().nextInt(1,2049);

    private int HEALTHY_PIXEL_COUNT = PIXEL_COUNT - (2 * RANDOM_PIXEL_COUNT);
    private int BURNED_PIXEL_COUNT = RANDOM_PIXEL_COUNT;
    private int ALMOST_BURNED_PIXEL_COUNT = RANDOM_PIXEL_COUNT;

    private int DEFECT_PIXEL_COUNT = PIXEL_COUNT - (BURNED_PIXEL_COUNT + ALMOST_BURNED_PIXEL_COUNT);

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

    public void healthyPixelCoordinates()
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

            this.pixelCollection[row][col] = new HealthyPixel(row, col, pixelColor, Color.BLACK);

            HEALTHY_PIXEL_COUNT--;
        }
        while(HEALTHY_PIXEL_COUNT != 0);
    }

    public void burnedPixelCoordinates()
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

            this.pixelCollection[row][col] = new BurnedPixel(row, col, pixelColor, Color.BLACK);

            BURNED_PIXEL_COUNT--;
        }
        while(BURNED_PIXEL_COUNT != 0);
    }

    public void almostBurnedCoordinates()
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

            this.pixelCollection[row][col] = new AlmostBurnedPixel(row, col, pixelColor, Color.BLACK);

            ALMOST_BURNED_PIXEL_COUNT--;
        }
        while(ALMOST_BURNED_PIXEL_COUNT != 0);
    }

    public void renderPixel(Graphics g, int row, int col)
    {
        if (this.hasScreenPixel(row, col))
        {
            Pixel tile = this.getScreenPixel(row, col);
            tile.renderPixel(g);
        }
    }

    public int getPixelCoordinates(int coordinates)
    {
        return coordinates / Pixel.PIXEL_SIZE;
    }

    public Pixel getScreenPixel(int row, int col)
    {
        return this.pixelCollection[row][col];
    }

    public boolean hasScreenPixel(int row, int col)
    {
        return this.getScreenPixel(row, col) != null;
    }

    public String getScreenDefect()
    {
        return String.format("Този телефон %s дефектен екран!", checkScreenDefect() ? "има" : "няма");
    }

    private Color getPixelColor()
    {
        int chance = (int) (Math.random() * 3);

        if (chance == 0)
        {
            return Color.RED;
        }

        if (chance == 1)
        {
            return Color.GREEN;
        }

        return Color.BLUE;
    }

    private int getPixelCoordinates()
    {
        return (int) (Math.random() * 64);
    }

    private boolean checkScreenDefect()
    {
        return DEFECT_PIXEL_COUNT > 2048;
    }
}