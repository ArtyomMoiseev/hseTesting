package sauceDemoTest.TestUtils;

import java.util.Random;

public class RandomStringGenerator
{
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public static String generateRandomString(int length)
    {
        if (length < 1)
        {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++)
        {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public static String generateStringWith16DigitRandomNumber()
    {
        Random random = new Random();

        long lowerBound = 1000000000000000L; // The smallest 16-digit number
        long upperBound = 9999999999999999L; // The largest 16-digit number

        long randomNumber = lowerBound + (long)(random.nextDouble() * (upperBound - lowerBound));

        return String.valueOf(randomNumber);
    }
}
