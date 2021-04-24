package lesson7.my_hiber;

@Htable(name = "cats")
public class Cat {

    @HField
    int id;
    @HField
    String name;
    @HField
    String color;

    public Cat(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
