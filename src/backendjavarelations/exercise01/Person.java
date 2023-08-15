package backendjavarelations.exercise01;

import java.util.ArrayList;
import java.util.List;

public class Person {
    
    private String firstName;
    private String lastName;
    private int age;
    private long ID;
    private final List<Dog> dogs;

    public Person(String firstName, String lastName, int age, long ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ID = ID;
        
        dogs = new ArrayList<>();
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }
    
    public boolean hasDogs() {
        return !dogs.isEmpty();
    }
    
    public boolean removeDog(Dog dog) {
        return dogs.remove(dog);
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    
    public String listDogs() {
        if (dogs.isEmpty())
            return "Sin perros.";
        
        String dogList = "";
        for (Dog dog : dogs) {
            dogList += dog + "\n";
        }
        return dogList;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + ":\n" + listDogs();
    }
    
}
