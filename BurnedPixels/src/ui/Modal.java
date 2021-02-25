package ui;

import phone_list.PhoneList;
import renderer.SwingRenderer;
import screen.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Клас наследяващ JDialog, съдържащ конструктор и метод за визуализиране на прозореца "Modal".
 *
 * @author Озан Осман
 */
public class Modal extends JDialog
{
    /**
     * Конструктор съдържащ характеристиките за създаване на прозореца "Modal".
     *
     * @param parent    родителят, който JFrame ще го използва
     * @param title     заглавие на прозореца
     * @param message   съобщение в прозореца
     */
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

        this.setSize(550, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Метод за инстанция на прозореца "Modal".
     *
     * @param parent    родителят, който JFrame ще го използва
     * @param title     заглавие на прозореца
     * @param message   съобщение в прозореца
     */
    public static void renderMessageWithButton(JFrame parent, String title, String message)
    {
        new Modal(parent, title, message);
    }
}