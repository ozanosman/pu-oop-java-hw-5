package ui;

import renderer.SwingRenderer;
import screen.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modal extends JDialog
{
    public Modal(JFrame parent, String title, String message)
    {
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        JButton buttonRestart = new JButton("Нов телефон?");

        panel.add(label);
        panel.add(buttonRestart);
        getContentPane().add(panel);

        buttonRestart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                parent.setVisible(false);
                Screen screen = new Screen();
                SwingRenderer renderer = new SwingRenderer(screen);
            }
        });

        this.setSize(250, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void renderMessageWithButton(JFrame parent, String title, String message)
    {
        new Modal(parent, title, message);
    }
}
