package com.bxrbasov.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserRunner {
    public static void main(String[] args) {
        UserFactory userFactory = UserFactory.getInstance();
        List<User> users = new ArrayList<User>(
                List.of(
                        userFactory.createUser(1, "Alexander", "Medvedev", 21, "Russia"),
                        userFactory.createUser(2, "Tommy", "Semenov", 20, "Russia"),
                        userFactory.createUser(3, "Nikita", "Popov", 22, "USA"),
                        userFactory.createUser(4, "Semen", "Voronov", 36, "Poland"),
                        userFactory.createUser(5, "Ilya", "Bolshoi", 28, "Germany")
                )
        );
        System.out.println("========");
        printSortByLastName(users);
        System.out.println("========");
        printSortByAge(users);
        System.out.println("========");
        System.out.println(checkUserWithAgeMoreThen(users, 7));
        System.out.println("========");
        System.out.println(getAverageAge(users));
        System.out.println("========");
        System.out.println(getCountOfDifferentCountry(users));
        System.out.println("========");
    }

    private static void printSortByLastName(List<User> users) {
        users.stream().sorted(Comparator.comparing(User::getLastName)).forEach(System.out::println);
    }

    private static void printSortByAge(List<User> users) {
        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);
    }

    private static boolean checkUserWithAgeMoreThen(List<User> users, int age) {
        return users.stream().allMatch(u -> u.getAge() > age);
    }

    private static double getAverageAge(List<User> users) {
        return users.stream().mapToInt(u -> u.getAge()).average().getAsDouble();
    }

    private static int getCountOfDifferentCountry(List<User> users) {
        return (int) users.stream().map(user -> user.getCountry()).distinct().count();
    }
}
