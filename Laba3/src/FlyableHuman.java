public class FlyableHuman extends Human implements Flyable {
    public FlyableHuman(String name, Location location, Location destination, int time, String laugh) {
        super(name, location, destination, time, laugh);
    }

    public void hello() {
        System.out.println(getName() + ": Привет!");
    }

    public void fly(Location location) {
        this.setLocation(location);
        System.out.println(getName() + " Прилетел в " + getLocation());
    }

    public void circling() {
        System.out.println(getName() + " Начинает кружить по " + getLocation());
    }

    public void speak(String string) {
        System.out.println(getName() + ": " + string);
    }

    public void touch(Item item) throws ItemIsBrokenException {
        System.out.println(getName() + " трогает " + item.getName());
        if (item.isIsbroken() == true) throw new ItemIsBrokenException(item);
    }

    public void act(Container container) {
        if (container.isState() == false) {
            System.out.println(getName() + " открывает " + container.getName());
            container.setState(true);
        } else {
            System.out.println(getName() + " закрывает " + container.getName());
            container.setState(false);
        }
    }

    public void brake(Item item, NormalHuman user) {
        System.out.println(getName() + " начинает ломать игрушку " + item.getName());
        item.brake();
        user.setState(State.SAD);
        System.out.println(user.getName() + ": " + getName() + ", что ты наделал? Это была моя любимая " + item.getName() + "... Ладно, давай я пзнакомлю тебя со своей семьей");
        user.setLocation(Location.KITCHEN);
        System.out.println(user.getName() + " бежит в " + user.getLocation());

    }

    @Override
    public void use(Item item) throws ItemIsBrokenException {

    }

    public void lookat(Item item) {
        System.out.println(getName() + " смотрит на " + item.getName());
    }


    public FlyableHuman ReturnObject() {
        return this;
    }
}
