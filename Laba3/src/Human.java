import java.util.Objects;

public abstract class Human implements Speakable, Interactable {
    private String name;
    private State state = State.NORMAL;
    private Location location = Location.KITCHEN;
    private Location destination;
    private int time;
    protected String laugh;

    public String getLaugh() {
        return laugh;
    }

    public Human(String name, Location location, Location destination, int time, String laugh) {
        this.name = name;
        this.location = location;
        this.destination = destination;
        this.time = time;
        this.laugh = laugh;
    }


    public void setState(State state) {
        this.state = state;
    }

    public Location getLocation() {
        return location;
    }

    protected void setLocation(Location location) {
        this.location = location;
    }

    public Location getDestination() {
        return destination;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public Human ReturnObject() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name) &&
                state == human.state &&
                location == human.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state, location);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", state=" + state +
                ", location=" + location +
                '}';
    }
}
