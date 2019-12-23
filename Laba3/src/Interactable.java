public interface Interactable {
    void touch(Item item) throws ItemIsBrokenException;

    void act(Container container);

    void lookat(Item picture);

    void brake(Item car, NormalHuman user);

    void use(Item item) throws ItemIsBrokenException;
}
