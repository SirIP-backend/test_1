import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.print(calc(str));
    }


    public static String calc(String input) {
        StringBuilder str = new StringBuilder(input);
        str.append(" ");
        int result = 0;
        int countDigit = 0;
        int countMult = 0;
        int[] a = new int[5];
        StringBuilder str1 = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*') {
                countMult++;
            }
        }
        if (countMult > 1) {
            return "throws Exception";
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                str1.append(str.charAt(i));
            } else {
                a[countDigit] = Integer.parseInt(str1.toString());
                str1 = new StringBuilder();
                countDigit++;

            }
        }


        if (countDigit == 1 || countDigit > 2 ||
                a[0] <= 0 || a[0] >= 11 || a[1] <= 0 || a[1] >= 11) {
            return "throws Exception";
        }
        for (int i = 0; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {
                switch (str.charAt(i)) {
                    case '+':
                        result = a[0] + a[1];
                        break;
                    case '-':
                        result = a[0] - a[1];
                        break;
                    case '/':
                        result = a[0] / a[1];

                        break;
                    case '*':
                        result = a[0] * a[1];

                }
            }
        }
        return Integer.toString(result);
    }


}



