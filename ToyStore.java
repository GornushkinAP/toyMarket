// ToyStore.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyStore {
    private List<Toy> toys; // Список игрушек

    // Конструктор класса
    public ToyStore() {
        toys = new ArrayList<>();
    }

    // Метод добавления новой игрушки в магазин
     public void addToy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите информацию об игрушке: (ID, Название, Количество, Вес(частота выпадения)): ");
        int id = scanner.nextInt();
        String name = scanner.next();
        int quantity = scanner.nextInt();
        double weight = scanner.nextDouble();
        toys.add(new Toy(id, name, quantity, weight));
    }

    // Метод для изменения веса (частоты выпадения) игрушки из консоли
    public void updateWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди игрушки для обновления веса: ");
        int toyId = scanner.nextInt();
        System.out.println("Введите новый вес: ");
        double weight = scanner.nextDouble();
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                System.out.println("Вес обновлен.");
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " не найдена.");
    }

    // Метод для вывода всех игрушек в консоль
    public void displayToys() {
        System.out.println("Все игрушки: ");
        for (Toy toy : toys) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() + ", Количество: " + toy.getQuantity() + ", Вес: " + toy.getWeight());
        }
    }


    // Метод выбора призовой игрушки
    public Toy chooseToy() {
        // Рассчитываем общий вес всех игрушек
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        // Генерируем случайное число от 0 до общего веса
        double randomNumber = Math.random() * totalWeight;
        double generalWeight = 0;
        // Проходим по каждой игрушке и сравниваем вес с сгенерированным числом
        for (Toy toy : toys) {
            generalWeight += toy.getWeight();
            if (randomNumber <= generalWeight) {
                // Если вес текущей игрушки больше сгенерированного числа,
                // выбираем эту игрушку как призовую
                Toy chosenToy = toy;
                // Уменьшаем количество выбранной игрушки на 1
                chosenToy.setQuantity(chosenToy.getQuantity() - 1);
                // Удаляем выбранную игрушку из списка
                toys.remove(toy);
                return chosenToy;
            }
        }
        // Если ни одна игрушка не выбрана, возвращаем null
        return null;
    }
}
