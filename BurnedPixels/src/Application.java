import renderer.SwingRenderer;
import screen.Screen;

/**
 * Клас съдържащ главния метод за изпълнение на приложението.
 *
 * @author Озан Осман
 */
public class Application
{
    public static void main(String[] args)
    {
        Screen screen = new Screen();
        SwingRenderer renderer = new SwingRenderer(screen);
    }
}