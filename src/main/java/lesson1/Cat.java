package lesson1;

public class Cat {
    public String name;
    public String color;
    public int age;

    @Override
    // Переопределили метод для корректного отображения информации по классу
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;




    }
}
