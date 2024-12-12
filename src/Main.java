import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.print(calc(str));        //вызов метода calc
    }


    public static String calc(String input) {
        StringBuilder str = new StringBuilder(input);
        str.append(" ");                                    //обход для разделения чисел
        int result = 0;
        int countDigit = 0;
        int countMult = 0;
        int[] a = new int[5];
        StringBuilder str1 = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {        //Добавляем счетчик операндов
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*') {
                countMult++;
            }
        }

        if (countMult > 1) {            //если операндов больше 1 выдаем ошибку
            return "throws Exception";
        }

        for (int i = 0; i < str.length(); i++) {            //отделяем числа из строки если текущий символ цифра то
            if (Character.isDigit(str.charAt(i))) {         //добавляем цифру в строку
                str1.append(str.charAt(i));
            } else {                                                    //иначе если символ не цифра то записываем строку
                a[countDigit] = Integer.parseInt(str1.toString());      //в массив со счетчиком чисел
                str1 = new StringBuilder();
                countDigit++;

            }
        }

        if (countDigit == 1 || countDigit > 2 ||                            //проверки на ограничения
                a[0] <= 0 || a[0] >= 11 || a[1] <= 0 || a[1] >= 11) {
            return "throws Exception";
        }

        for (int i = 0; i < str.length(); i++) {            //операция двух чисел с операндом
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
        return Integer.toString(result);        //вывод результата
    }


}



