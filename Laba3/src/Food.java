public class Food {
    private String name;
    private Food[] foods;

    public Food(String name, String... foodNames) {
        foods = new Food[foodNames.length];
        for (int i = 0; i < foodNames.length; i++) {
            String foodName = foodNames[i];
            foods[i] = new Food(foodName);
        }
        this.name = name;
    }

    void eat() {
        for (Food food : foods) {
            food.eat();
        }
        System.out.println("блюдо " + name + " съедено на обед");
    }
}
