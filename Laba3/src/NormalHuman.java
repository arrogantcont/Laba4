public class NormalHuman extends Human {
    public NormalHuman(String name, Location location, Location destination, int time, String laugh) {
        super(name, location, destination, time, laugh);
    }

    public void hello() {
        System.out.println(getName() + ": Привет!");
    }

    public static Builder builder() {
        return new Builder();
    }


    static class Builder {
        private String name;
        private Location location;
        private Location destination;
        private int time;
        private String laugh;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder destination(Location destination) {
            this.destination = destination;
            return this;
        }

        public Builder time(int time) {
            this.time = time;
            return this;
        }

        public Builder laugh(String laugh) {
            this.laugh = laugh;
            return this;
        }

        public NormalHuman build() {
            return new NormalHuman(name, location, destination, time, laugh);
        }
    }

    public void speak(String string) {
    }

    private FlyableAction action;

    public void setOnStateChange(FlyableAction action) {
        this.action = action;
    }

    public void setState(State state) {
        super.setState(state);
        action.action(this);
    }

    @Override
    public void touch(Item item) throws ItemIsBrokenException {

    }

    @Override
    public void act(Container container) {

    }

    @Override
    public void lookat(Item picture) {

    }

    @Override
    public void brake(Item car, NormalHuman user) {

    }

    @Override
    public void use(Item item) throws ItemIsBrokenException {

    }

    public void laughHard() {
        System.out.println(getName() + " начинает хохотать: " + getLaughContainer());
    }

    private interface LaughContainer {
        String toString();
    }

    public LaughContainer getLaughContainer() {
        class PersonLaughContainer implements LaughContainer {
            final String laugh = NormalHuman.this.laugh;

            @Override
            public String toString() {
                return this.laugh;
            }
        }
        LaughContainer laugh = new PersonLaughContainer();
        return laugh;


    }

    public void eat(Food food) {
        System.out.println(getName() + " начинает обедать ");
        food.eat();
        if ((getName() == "Боссе") || (getName() == "Бетан")) {
            setLocation(Location.STREET);
        }
        if (getName() == "Малыш") {
            setLocation(Location.ROOM);
            System.out.println(getName() + " идёт в " + getLocation() + " ждёт Карлсона");
            setState(State.AWAITING);
        }
    }

    void showCarlson(NormalHuman mama, NormalHuman betan, NormalHuman bosse, NormalHuman papa) throws HumanNotFoundException {
        System.out.println(getName() + " прибежал в " + getLocation());
        if (mama.getLocation() != Location.KITCHEN || papa.getLocation() != Location.KITCHEN || (bosse.getLocation() != Location.KITCHEN && betan.getLocation() != Location.KITCHEN))
            throw new HumanNotFoundException("Только мама и папа находятся в " + mama.getLocation() + " Боссе и Бетан ушли на " + bosse.getLocation());
    }
}

