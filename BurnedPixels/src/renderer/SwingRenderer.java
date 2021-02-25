package renderer;

import pixel.AlmostBurnedPixel;
import pixel.BurnedPixel;
import pixel.HealthyPixel;
import pixel.Pixel;
import screen.Screen;
import ui.Modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Клас наследяващ JFrame и прилагащ MouseListener, съдържащ конструктор и методи за визуализиране на приложението.
 *
 * @author Озан Осман
 */
public class SwingRenderer extends JFrame implements MouseListener
{
    Screen screen;

    /**
     * Конструктор съдържащ характеристиките за създаване на прозореца, в която се визуализира екрана и неговите елементи.
     *
     * @param screen
     */
    public SwingRenderer(Screen screen)
    {
        this.screen = screen;

        this.setTitle("Serial No: " + this.screen.serialNumberGenerator());
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);

        this.screen.healthyPixelCoordinates();
        this.screen.burnedPixelCoordinates();
        this.screen.almostBurnedCoordinates();

        this.screen.renderPhoneList();
    }

    /**
     * Метод, който позволява кликане върху екрана, за проверка на дефектност.
     *
     * @param e     обект на супер класа за всички графични контексти
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int row = this.screen.getScreenCoordinates(e.getY());
        int col = this.screen.getScreenCoordinates(e.getX());

        if (this.screen.hasScreenPixel(row, col))
        {
            this.screen.selectedPixel = this.screen.getScreenPixel(row, col);

            Pixel pixel = this.screen.selectedPixel;

            if (this.screen.selectedPixel instanceof HealthyPixel)
            {
                if (e.getClickCount() == 1)
                {
                    pixel.pixelCondition();
                    this.screen.HEALTHY_PIXEL_CLICK_COUNTER++;

                    if (this.screen.HEALTHY_PIXEL_CLICK_COUNTER == 15)
                    {
                        Modal.renderMessageWithButton(this,"Внимание!", this.screen.getScreenDefect());
                        this.screen.renderPhoneList();
                    }
                }
            }

            if (this.screen.selectedPixel instanceof BurnedPixel)
            {
                if (e.getClickCount() == 1)
                {
                    pixel.pixelCondition();
                    this.screen.BURNED_PIXEL_CLICK_COUNTER++;

                    if (this.screen.BURNED_PIXEL_CLICK_COUNTER == 15)
                    {
                        Modal.renderMessageWithButton(this,"Внимание!", this.screen.getScreenDefect());
                        this.screen.renderPhoneList();
                    }
                }
            }

            if (this.screen.selectedPixel instanceof AlmostBurnedPixel)
            {
                if (e.getClickCount() == 3)
                {
                    pixel.pixelCondition();
                    this.screen.ALMOST_BURNED_PIXEL_CLICK_COUNTER++;

                    if (this.screen.ALMOST_BURNED_PIXEL_CLICK_COUNTER == 15)
                    {
                        Modal.renderMessageWithButton(this,"Внимание!", this.screen.getScreenDefect());
                        this.screen.renderPhoneList();
                    }
                }
            }

            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    /**
     * Метод съдържащ цикъл за визуализиране на екрана и неговите елементи.
     *
     * @param g     обект на супер класа за всички графични контексти
     */
    @Override
    public void paint(Graphics g)
    {
        for (int row = 0; row < 64; row++)
        {
            for (int col = 0; col < 64; col++)
            {
                this.screen.renderPixel(g, row, col);
            }
        }
    }
}