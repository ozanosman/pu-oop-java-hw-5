package pixel;

import java.awt.*;

/**
 * Клас наследяващ Pixel, съдържащ конструктор и метод за елементи "Healthy Pixel".
 *
 * @author Озан Осман
 */
public class HealthyPixel extends Pixel
{
    /**
     * Конструктор на супер класа за елемента "Healthy Pixel".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     * @param color     цвят на елемента
     * @param outlineColor      контур на елемента
     */
    public HealthyPixel(int row, int col, Color color, Color outlineColor)
    {
        super(row, col, color, outlineColor);
    }

    /**
     * Метод съдържащ състоянието на елементи "Healthy Pixel".
     */
    @Override
    public Color pixelCondition()
    {
        return this.color;
    }
}