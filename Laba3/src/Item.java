public class Item {
    private String name;
    private String user;
    private boolean isbroken;
    private Part[] parts;

    public Item(String name, String user, String... partNames) {
        parts = new Part[partNames.length];
        for (int i = 0; i < partNames.length; i++) {
            String partName = partNames[i];
            parts[i] = new Part(partName);
        }
        this.name = name;
        this.user = user;
    }


    public Part[] getParts() {
        return parts;
    }

    void brake() {
        isbroken = true;
        for (Part part : parts) {
            part.brake();
        }
        System.out.println(name + " сломана");
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    class Part {
        private String name;
        private boolean isbroken;

        void brake() {
            isbroken = true;
            System.out.println("деталь " + name + " сломана");
        }

        public Part(String name) {
            this.name = name;
            this.isbroken = false;
        }
    }

    public boolean isIsbroken() {
        return isbroken;
    }
}
