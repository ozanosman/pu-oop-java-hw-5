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

public class SwingRenderer extends JFrame implements MouseListener
{
    Screen screen;

    public SwingRenderer(Screen screen)
    {
        this.screen = screen;

        this.setTitle("Serial No: " + this.screen.cerealNumberGenerator());
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);

        this.screen.healthyPixelCoordinates();
        this.screen.burnedPixelCoordinates();
        this.screen.almostBurnedCoordinates();

        Modal.renderMessageWithButton(this,"Внимание!", this.screen.getScreenDefect());
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int row = this.screen.getPixelCoordinates(e.getY());
        int col = this.screen.getPixelCoordinates(e.getX());

        if (this.screen.hasScreenPixel(row, col))
        {
            this.screen.selectedPixel = this.screen.getScreenPixel(row, col);

            Pixel pixel = this.screen.selectedPixel;

            if (this.screen.selectedPixel instanceof HealthyPixel)
            {
                pixel.pixelCondition();
            }

            if (this.screen.selectedPixel instanceof BurnedPixel)
            {
                pixel.pixelCondition();
            }

            if (this.screen.selectedPixel instanceof AlmostBurnedPixel)
            {
                if (e.getClickCount() == 3)
                {
                    pixel.pixelCondition();
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