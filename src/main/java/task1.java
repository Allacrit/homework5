/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
2) Вывод всего
Пример:
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 1242353
К: Введите 1) Добавление номера
2) Вывод всего
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 547568
К: Введите 1) Добавление номера
2) Вывод всего
Я: 2
Иванов: 1242353, 547568
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> book = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1. - Чтобы добавить номер.\n" +
                    "2. - Чтобы вывести все записи.\n" +
                    "3. - Чтобы завершить.\n" +
                    "Введите: ");

            int command = scanner.nextInt();
            scanner.nextLine();

            if (command == 1) {
                add(book, scanner);
            }
            if (command == 2) {
                printAll(book);
            }
            if (command == 3) {
                System.out.println("<<< Завершение работы! >>>");
                break;
            }
        }
        scanner.close();
    }

    public static void add(HashMap<String, ArrayList<Integer>> book, Scanner scanner) {
        System.out.print("Введите фамилию: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер: ");
        int num = scanner.nextInt();
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<>());
        }
        book.get(name).add(num);
    }

    public static void printAll(HashMap<String, ArrayList<Integer>> book) {
        book.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue()
                    .toString()
                    .replaceAll("\\[", "")
                    .replaceAll("\\]", ""));
        });
    }
}