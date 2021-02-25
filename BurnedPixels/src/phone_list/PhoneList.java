package phone_list;

/**
 * Клас съдържащ методи за създаване на структура от данни за приложението.
 *
 * @author Озан Осман
 */
public class PhoneList<T>
{
    private int placeholderPointer = 0;
    private final Object[] phoneCollection;

    /**
     * Конструктор, който инициализира структурата от данни.
     */
    public PhoneList()
    {
        this.phoneCollection = new Object[5];
    }

    /**
     * Метод, който добавя елемент към структурата от данни.
     *
     * @param element   добавен елемент
     */
    public void add(Object element)
    {
        this.phoneCollection[this.placeholderPointer++] = element;
    }

    /**
     * Метод, който връща индексът на добавен елемент.
     *
     * @param index     индексът на добавен елемент
     */
    public T get(int index)
    {
        return (T) this.phoneCollection[index];
    }
}