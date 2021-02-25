package screen;

import phone_list.PhoneList;
import pixel.AlmostBurnedPixel;
import pixel.BurnedPixel;
import pixel.HealthyPixel;
import pixel.Pixel;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Клас съдържащ методи за изпълнението на логиката в приложението.
 *
 * @author Озан Осман
 */
public class Screen
{
    public final int PIXEL_SIDE_COUNT = 64;

    private Pixel[][] pixelCollection = new Pixel[PIXEL_SIDE_COUNT][PIXEL_SIDE_COUNT];

    public Pixel selectedPixel;

    private PhoneList workingPhone = new PhoneList();
    private PhoneList brokenPhone  = new PhoneList();

    private final String CEREAL_NUMBER_CHARACTER_COLLECTION = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private int PIXEL_COUNT = 4096;

    private int RANDOM_PIXEL_COUNT = ThreadLocalRandom.current().nextInt(1,2049);

    private int HEALTHY_PIXEL_COUNT = PIXEL_COUNT - (2 * RANDOM_PIXEL_COUNT);
    private int BURNED_PIXEL_COUNT = RANDOM_PIXEL_COUNT;
    private int ALMOST_BURNED_PIXEL_COUNT = RANDOM_PIXEL_COUNT;

    private int DEFECT_PIXEL_COUNT = PIXEL_COUNT - (BURNED_PIXEL_COUNT + ALMOST_BURNED_PIXEL_COUNT);

    public int HEALTHY_PIXEL_CLICK_COUNTER = 0;
    public int BURNED_PIXEL_CLICK_COUNTER = 0;
    public int ALMOST_BURNED_PIXEL_CLICK_COUNTER = 0;

    private String phoneSerialNumber = serialNumberGenerator();

    /**
     * Метод, който разбърква низ и създава един случаен друг низ дълък 10 символа.
     */
    public String serialNumberGenerator()
    {
        StringBuilder randomString = new StringBuilder(10);

        for (int i = 0 ; i < 10; i++)
        {
            int randomCharacter = (int) (Math.random() * CEREAL_NUMBER_CHARACTER_COLLECTION.length());

            randomString.append(CEREAL_NUMBER_CHARACTER_COLLECTION.charAt(randomCharacter));
        }

        return randomString.toString();
    }

    /**
     * Метод задаващ координати за визуализиране на елементи "Healthy Pixel".
     */
    public void healthyPixelCoordinates()
    {
        do
        {
            int row = getPixelCoordinates();
            int col = getPixelCoordinates();

            if (this.hasScreenPixel(row, col))
            {
                continue;
            }

            Color pixelColor = this.getPixelColor();

            this.pixelCollection[row][col] = new HealthyPixel(row, col, pixelColor, Color.BLACK);

            HEALTHY_PIXEL_COUNT--;
        }
        while(HEALTHY_PIXEL_COUNT != 0);
    }

    /**
     * Метод задаващ координати за визуализиране на елементи "Burned Pixel".
     */
    public void burnedPixelCoordinates()
    {
        do
        {
            int row = getPixelCoordinates();
            int col = getPixelCoordinates();

            if (this.hasScreenPixel(row, col))
            {
                continue;
            }

            Color pixelColor = this.getPixelColor();

            this.pixelCollection[row][col] = new BurnedPixel(row, col, pixelColor, Color.BLACK);

            BURNED_PIXEL_COUNT--;
        }
        while(BURNED_PIXEL_COUNT != 0);
    }

    /**
     * Метод задаващ координати за визуализиране на елементи "Almost Burned Pixel".
     */
    public void almostBurnedCoordinates()
    {
        do
        {
            int row = getPixelCoordinates();
            int col = getPixelCoordinates();

            if (this.hasScreenPixel(row, col))
            {
                continue;
            }

            Color pixelColor = this.getPixelColor();

            this.pixelCollection[row][col] = new AlmostBurnedPixel(row, col, pixelColor, Color.BLACK);

            ALMOST_BURNED_PIXEL_COUNT--;
        }
        while(ALMOST_BURNED_PIXEL_COUNT != 0);
    }

    /**
     * Метод съдържащ инстанция на клас за визуализиране на елементи "Healthy Pixel", "Burned Pixel" и "Almost Burned Pixel".
     *
     * @param g     обект на супер класа за всички графични контексти
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public void renderPixel(Graphics g, int row, int col)
    {
        if (this.hasScreenPixel(row, col))
        {
            Pixel tile = this.getScreenPixel(row, col);
            tile.renderPixel(g);
        }
    }

    /**
     * Метод, който връща координати на дисплея в единични числа.
     *
     * @param coordinates   координати
     */
    public int getScreenCoordinates(int coordinates)
    {
        return coordinates / Pixel.PIXEL_SIZE;
    }

    /**
     * Метод, който връща елемент от обекта за елементи "Healthy Pixel", "Burned Pixel" и "Almost Burned Pixel".
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public Pixel getScreenPixel(int row, int col)
    {
        return this.pixelCollection[row][col];
    }

    /**
     * Метод, който проверява и връща елемент от обекта за елементи "Healthy Pixel", "Burned Pixel" и "Almost Burned Pixel", ако те съществуват.
     *
     * @param row   ред на елемента
     * @param col   колона на елемента
     */
    public boolean hasScreenPixel(int row, int col)
    {
        return this.getScreenPixel(row, col) != null;
    }

    /**
     * Метод, който избира да визуализира дали екрана на телефон има или няма дефект.
     */
    public String getScreenDefect()
    {
        return String.format("Няма нужда да продължавате да проверявате, защото този телефон %s дефектен екран!", checkScreenDefect() ? "има" : "няма");
    }

    /**
     * Метод, който визуализира сериийния номер на работещи и дефектни телефони.
     */
    public void renderPhoneList()
    {
        for (int i = 0; i < 5; i++)
        {
            if (this.workingPhone.get(i) != null)
            {
                System.out.println("Serial No: " + this.workingPhone.get(i) + "\nНе са открити дефекти!");
            }

            if (this.brokenPhone.get(i) != null)
            {
                System.out.println("Serial No: " + this.brokenPhone.get(i) + "\nОткрити са дефекти!");
            }
        }
    }

    /**
     * Метод, който връща 3 различни цвята случайно.
     */
    private Color getPixelColor()
    {
        int chance = (int) (Math.random() * 3);

        if (chance == 0)
        {
            return Color.RED;
        }

        if (chance == 1)
        {
            return Color.GREEN;
        }

        return Color.BLUE;
    }

    /**
     * Метод, който избира и връща координати на елементи "Healthy Pixel", "Burned Pixel" и "Almost Burned Pixel".
     */
    private int getPixelCoordinates()
    {
        return (int) (Math.random() * 64);
    }

    /**
     * Метод, който проверява дали екрана има или няма дефект.
     */
    private boolean checkScreenDefect()
    {
        if (DEFECT_PIXEL_COUNT > 2048)
        {
            brokenPhone.add(phoneSerialNumber);
            return true;
        }

        workingPhone.add(phoneSerialNumber);
        return false;
    }
}