abstract class Animal {
    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods for name and age
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method sound to be overridden by subclasses
    public abstract String sound();
}

// Dog subclass
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String sound() {
        return "Woof";
    }
}

// Cat subclass
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String sound() {
        return "Meow";
    }
}

// Main class to test the hierarchy
public class Demo3 {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy", 5);
        Animal cat = new Cat("Whiskers", 3);

        System.out.println(dog.getName() + " is " + dog.getAge() + " years old and says: " + dog.sound());
        System.out.println(cat.getName() + " is " + cat.getAge() + " years old and says: " + cat.sound());
    }
}
