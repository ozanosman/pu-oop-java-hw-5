package renderer;

import screen.Screen;

import javax.swing.*;
import java.awt.*;

public class SwingRenderer extends JFrame
{
    Screen screen;

    public SwingRenderer(Screen screen)
    {
        this.screen = screen;

        this.setTitle(this.screen.cerealNumberGenerator());
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.screen.pixelCoordinates();
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
