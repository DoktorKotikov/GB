package lesson7.my_hiber;

@Htable(name = "workers")
public class Worker {
    @HField
    int id;
    @HField
    String name;
    @HField
    int age;
    @HField
    int salary;
    @HField
    String email;
    @HField
    String phone;
    @HField
    String address;

    public Worker(int id, String name, int age, int salary, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
