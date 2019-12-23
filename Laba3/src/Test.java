//import java.lang.reflect.Method;
//import java.util.Scanner;

//пример рефлексии, можем получить значения полей (private), можем поменять если не final
//public class Test {
//    public static void main(String[] args) {
//        FlyableHuman s = new FlyableHuman("Karslon", Location.ROOF, Location.ROOM, 0);
//        Method[] methods = s.getClass().getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            String line = scanner.nextLine();
//            System.out.println(line + "@@@");//неявно добавляется блок finally, которыц закроет ресурс(поток) ввода
//            //try with resources работа с ресурсами
//        }
//}

