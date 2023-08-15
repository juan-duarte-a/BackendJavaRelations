package backendjavarelations.exercise01;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Juan", "Pérez", 31, 7654388);
        person1.addDog(new Dog("Rambo", "Pug", 5, 9.3));
        person1.addDog(new Dog("Estrellita", "Bulldog", 7, 26.1));

        Person person2 = new Person("Laura", "Martínez", 28, 6786588);
        person2.addDog(new Dog("Inu", "Beagle", 7, 12.7));
        
        System.out.println(person1);
        System.out.println(person2);
    }
    
}
