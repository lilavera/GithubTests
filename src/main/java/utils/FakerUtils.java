package utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static Faker faker = new Faker();

    public FakerUtils() {
    }

    public static String generateDescription(){
        return faker.hacker().noun();
    }

    public static String generateName(){
        return faker.name().firstName();
    }

    public static String generateHomePage(){
        return faker.app().name();
    }
}
