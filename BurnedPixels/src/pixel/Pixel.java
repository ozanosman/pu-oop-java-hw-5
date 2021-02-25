package pixel;

import java.awt.*;

/**
 * Абстрактен клас съдържащ конструктор, променливи и методи за елементи "Healthy Pixel", "Burned Pixel" и "Almost Burned Pixel".
 *
 * @author Озан Осман
 */
public abstract class Pixel
{
    public static final int PIXEL_SIZE = 25;

    protected int row;
    protected int col;
    protected Color color;
    protected Color outlineColor;

    /**
     * Конструктор на елемента "Pixel".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public Pixel(int row, int col, Color color, Color outlineColor)
    {
        this.row = row;
        this.col = col;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    /**
     * Метод съдържащ логика за визуализиране на елементи "Pixel".
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    public void renderPixel(Graphics g)
    {
        int tileX = this.col * PIXEL_SIZE;
        int tileY = this.row * PIXEL_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, PIXEL_SIZE, PIXEL_SIZE);

        g.setColor(this.outlineColor);
        g.drawRect(tileX, tileY, PIXEL_SIZE, PIXEL_SIZE);
    }

    /**
     * Метод съдържащ състоянието на елементи "Pixel".
     */
    public abstract Color pixelCondition();
}