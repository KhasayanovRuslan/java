//1. Создать программу, которая переворачивает вводимые строки (читает справа налево).

public class FlipStrings {
    public void flipStrings(String string) {
        int lengthString = string.length();

        for (int i = lengthString - 1; i >= 0; i--) {
            char ch = string.charAt(i);
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        FlipStrings fs = new FlipStrings();
        fs.flipStrings("1234 1234");
    }
}
