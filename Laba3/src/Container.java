import java.util.Arrays;
import java.util.Objects;

public class Container {
    private Item[] items;
    private String name;
    private boolean state;
    private int counter = 0;

    public Container(String name, int capacity, boolean state) {
        this.name = name;
        items = new Item[capacity];
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void additem(Item item) {
        items[counter] = item;
        counter++;
    }

    public Item[] getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return counter == container.counter &&
                Arrays.equals(items, container.items) &&
                name.equals(container.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, counter);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
