import java.util.Random;

public class RandomDataGenerator {
    // Method to generate a random email
    public static String generateRandomEmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder();
        email.append("user");

        // Generate a random number and append it
        email.append(random.nextInt(10000));

        email.append("@gmail.com");
        return email.toString();
    }

    // Method to generate a random password
    public static String generateRandomPassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Character pool for password generation
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";

        // Generate a random password of length 10
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }
}
