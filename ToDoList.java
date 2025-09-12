import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private static List<String> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            showMenu();

            String option = sc.nextLine();
            switch (option) {
                case "0":
                    isContinue = false;
                    break;

                case "1":
                    addTask();
                    break;

                case "2":
                    break;

                case "3":
                    removeTaskByNumber();
                    break;

                case "4":
                    removeTaskByName();
                    break;

                case "5":
                    removeTaskByKeyword();
                    break;
                default:
                    System.out.println("Такой команды нет");
            }

            showTasks();
        }
    }

    private static void removeTaskByKeyword() {
        System.out.print("Введите ключевое слово: ");
        String keyword = sc.nextLine();
        Iterator<String> iter = tasks.iterator();
        while (iter.hasNext()) {
            String task = iter.next();
            if (task.contains(keyword)) {
                iter.remove();
            }
        }
    }

    private static void removeTaskByName() {
        System.out.print("Введите название задачи: ");
        String task = sc.nextLine();
        if (tasks.contains(task)) {
            tasks.remove(task);
        } else {
            System.out.println("Такой задачи нет");
        }
    }

    private static void removeTaskByNumber() {
        System.out.print("Введите номер задачи: ");
        int position = Integer.parseInt(sc.nextLine()) - 1;
        if (position >= 0 && position < tasks.size()) {
            tasks.remove(position);
        } else {
            System.out.println("Такой задачи нет");
        }
    }

    private static void addTask() {
        System.out.print("Введите название задачи: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("Добавлено!");
    }

    private static void showTasks() {
        System.out.println("\n Ваш список дел: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
        System.out.println();
    }

    private static void showMenu() {
        System.out.printf("Выберите операцию:\n" +
                "\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить по ключевому слову\n" +
                "Ваш выбор: ");
    }
}
