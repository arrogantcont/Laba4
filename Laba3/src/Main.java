public class Main {
    public static void main(String[] args) throws HumanNotFoundException {
        FlyableHuman carlson = new FlyableHuman("Карлсон", Location.ROOF, Location.ROOM, 0, "Lololol") {
            @Override
            public void hello() {
                System.out.println(getName() + ": Привет малыш! Я почувствовал что ты ждёшь меня");
            }
        };

        NormalHuman junior = NormalHuman.builder()
                .name("Малыш")
                .location(Location.KITCHEN)
                .time(2)
                .destination(Location.VILLAGE)
                .laugh("Хихихии")
                .build();
        NormalHuman mama = NormalHuman.builder()
                .name("Мама")
                .location(Location.KITCHEN)
                .time(2)
                .destination(Location.VILLAGE)
                .laugh("ХИ-ХИ-ХА")
                .build();
        NormalHuman papa = NormalHuman.builder()
                .name("Папа")
                .location(Location.KITCHEN)
                .time(2)
                .destination(Location.VILLAGE)
                .laugh("Хо-Хо-Хо")
                .build();
        NormalHuman bosse = NormalHuman.builder()
                .name("Боссе")
                .location(Location.KITCHEN)
                .time(2)
                .destination(Location.VILLAGE)
                .laugh("ВУхахаха")
                .build();
        NormalHuman betan = NormalHuman.builder()
                .name("Бетан")
                .location(Location.KITCHEN)
                .time(2)
                .destination(Location.VILLAGE)
                .laugh("МУхахаха")
                .build();
        Food econom = new Food("Обед эконом", "борщец", "компот");
        Food buisness = new Food("Обед бизнес", "борщец", "котлетки с пюрешкой", "компот");
        Food lux = new Food("Обед люкс", "борщец", "котлетки с пюрешкой", "тортик", "компот/чай/кофе/лимонад");
        junior.setOnStateChange(normalHuman -> {
            if ((junior.getState() == State.AWAITING) && (junior.getDestination() == Location.VILLAGE) && (junior.getTime() <= 5)) {
                carlson.fly(junior.getLocation());
                junior.hello();
                junior.setState(State.HAPPY);
            }
            if ((junior.getDestination() == Location.VILLAGE) && (junior.getTime() > 5)) {
                System.out.println(carlson.getName() + " прилетит позже, ведь время до отъеза Малыша: " + junior.getTime());
                System.exit(0);
            }
        });
        mama.laughHard();
        bosse.laughHard();
        betan.laughHard();
        mama.eat(lux);
        bosse.eat(buisness);
        betan.eat(buisness);
        junior.eat(econom);
        carlson.hello();
        carlson.circling();
        Container container1 = new Container("большой ящик", 5, false);
        carlson.act(container1);
        Item item = new Item("игрушку", "Малыш");
        Item picture = new Item("картину", "Малыш");
        Item car = new Item("машинка", "Малыш", "левое колесо", "корпус", "шасси");
        String string = new String("какая у тебя интересная " + car.getName() + ", Малыш!");
        carlson.touch(item);
        Container container2 = new Container("маленький ящик", 2, false);
        carlson.act(container2);
        carlson.lookat(picture);
        carlson.speak(string);
        carlson.brake(car, junior);
        //carlson.touch(car);
        junior.showCarlson(mama, papa, bosse, betan);
    }
}