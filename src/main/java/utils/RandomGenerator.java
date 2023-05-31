package utils;

import java.util.Random;

public class RandomGenerator {

    public static int getRandomInteger(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }

}