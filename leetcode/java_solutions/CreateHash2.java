package DSA_Learnings.leetcode.java_solutions;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreateHash2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CreateHash2 hasher = new CreateHash2();
        try {
            String result = hasher.createHash("example");
            System.out.println("Hash: " + result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    protected String createHash(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            System.out.println(hex);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}