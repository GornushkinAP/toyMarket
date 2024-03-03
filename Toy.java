

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight; // Вес в процентах от 100

    // Конструктор класса
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    // Геттеры для получения значений свойств
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    // Сеттеры
    // Сеттер для изменения веса (частоты выпадения игрушки)
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
