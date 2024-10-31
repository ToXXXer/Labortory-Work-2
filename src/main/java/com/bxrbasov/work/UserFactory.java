package com.bxrbasov.work;

public class UserFactory {
    private static UserFactory instance = new UserFactory();

    private UserFactory() {}

    public static UserFactory getInstance() {
        return instance;
    }

    public User createUser(int id, String firstName, String lastName, int age, String country) {
        return new User(id, firstName, lastName, age, country);
    }
}
