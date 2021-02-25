package pixel;

import java.awt.*;

/**
 * Клас наследяващ Pixel, съдържащ конструктор и метод за елементи "Burned Pixel".
 *
 * @author Озан Осман
 */
public class BurnedPixel extends Pixel
{
    /**
     * Конструктор на супер класа за елемента "Burned Pixel".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public BurnedPixel(int row, int col, Color color, Color outlineColor)
    {
        super(row, col, color, outlineColor);
    }

    /**
     * Метод съдържащ състоянието на елементи "Burned Pixel".
     */
    @Override
    public Color pixelCondition()
    {
        return this.color = Color.BLACK;
    }
}