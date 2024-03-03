import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Изменить вес игрушки");
            System.out.println("3. Показать список всех игрушек");
            System.out.println("4. Организовать розыгрыш");
            System.out.println("5. Выход");
            System.out.print("Введите цифру: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.addToy();
                    break;
                case 2:
                    store.updateWeight();
                    break;
                case 3:
                    store.displayToys();
                    break;
                case 4:
                    Toy chosenToy = store.chooseToy();
                    if (chosenToy != null) {
                        saveToFile(chosenToy);
                        System.out.println("Поздравляем вы выиграли: " + chosenToy.getName());
                    } else {
                        System.out.println("Не осталось игрушек на выбор.");
                    }
                    break;
                case 5:
                    // Выход из программы
                    running = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }

        scanner.close();
    }

    // Метод для сохранения призовой игрушки в файл
    private static void saveToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write("ID: " + toy.getId() + ", Название: " + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
