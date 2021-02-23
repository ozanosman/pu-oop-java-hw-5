import renderer.SwingRenderer;
import screen.Screen;

public class Application
{
    public static void main(String[] args)
    {
        Screen screen = new Screen();
        SwingRenderer renderer = new SwingRenderer(screen);
    }
}