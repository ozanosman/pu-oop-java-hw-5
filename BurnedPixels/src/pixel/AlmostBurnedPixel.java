package pixel;

import java.awt.*;

/**
 * Клас наследяващ Pixel, съдържащ конструктор и метод за елементи "Almost Burned Pixel".
 *
 * @author Озан Осман
 */
public class AlmostBurnedPixel extends Pixel
{
    /**
     * Конструктор на супер класа за елемента "Almost Burned Pixel".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public AlmostBurnedPixel(int row, int col, Color color, Color outlineColor)
    {
        super(row, col, color, outlineColor);
    }

    /**
     * Метод съдържащ състоянието на елементи "Almost Burned Pixel".
     */
    @Override
    public Color pixelCondition()
    {
        return this.color = Color.BLACK;
    }
}