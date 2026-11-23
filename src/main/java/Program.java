
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        people.add(new Person("Javiar", "Ray", 23));
        people.add(new Person("Daniel", "Smith", 30));
        people.add(new Person("Sara", "Johnson", 25));
        people.add(new Person("Michael", "Brown", 40));
        people.add(new Person("Hana", "Ayele", 28));
        people.add(new Person("David", "Wilson", 19));
        people.add(new Person("Emily", "Davis", 35));
        people.add(new Person("James", "Miller", 50));
        people.add(new Person("Sophia", "Taylor", 22));
        people.add(new Person("Daniel", "Lee", 27));

        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine();
        List<Person> matchingPeople = new ArrayList<>();

        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(searchName) || person.getLastName().equalsIgnoreCase(searchName)) {
                matchingPeople.add(person);
            }
        }
        System.out.println("\nSearch Results:");

        if (matchingPeople.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            for (Person person : matchingPeople) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        }

        int totalAge = 0;
        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        for (Person person : people) {
            totalAge += person.getAge();
            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }
            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        double averageAge = (double) totalAge / people.size();
        System.out.println("\nAge Statistics:");
        System.out.printf("Average Age: %.2f%n", averageAge);
        System.out.println("Oldest Age: " + oldestAge);
        System.out.println("Youngest Age: " + youngestAge);
        scanner.close();
    }
}
