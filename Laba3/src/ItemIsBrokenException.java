public class ItemIsBrokenException extends RuntimeException {
    public ItemIsBrokenException(Item item) {
        super("невозможно воспользоваться вещью " + item);
    }
}
