


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = createPeople();

        System.out.print("Enter a first or last name: ");
        String searchName = scanner.nextLine();

        List<Person> matches = searchPeople(people, searchName);

        displayPeople(matches);

        System.out.printf("Average Age: %.2f%n", calculateAverageAge(people));
        System.out.println("Oldest Age: " + findOldestAge(people));
        System.out.println("Youngest Age: " + findYoungestAge(people));

        scanner.close();
    }

    public static List<Person> createPeople() {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Mahlet", "Ayele", 23));
        people.add(new Person("Daniel", "Smith", 30));
        people.add(new Person("Sara", "Johnson", 25));
        people.add(new Person("Michael", "Brown", 40));
        people.add(new Person("Hana", "Ayele", 28));
        people.add(new Person("David", "Wilson", 19));
        people.add(new Person("Emily", "Davis", 35));
        people.add(new Person("James", "Miller", 50));
        people.add(new Person("Sophia", "Taylor", 22));
        people.add(new Person("Daniel", "Lee", 27));

        return people;
    }

    public static List<Person> searchPeople(List<Person> people, String name) {

        List<Person> matches = new ArrayList<>();

        for (Person person : people) {

            if (person.getFirstName().equalsIgnoreCase(name)
                    || person.getLastName().equalsIgnoreCase(name)) {

                matches.add(person);
            }
        }

        return matches;
    }

    public static void displayPeople(List<Person> people) {

        System.out.println("\nSearch Results:");

        if (people.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    public static double calculateAverageAge(List<Person> people) {

        if (people.isEmpty()) {
            return 0;
        }

        int totalAge = 0;
        for (Person person : people) {
            totalAge += person.getAge();
        }

        return (double) totalAge / people.size();
    }

    public static int findOldestAge(List<Person> people) {

        if (people.isEmpty()) {
            return 0;
        }

        int oldestAge = people.get(0).getAge();

        for (Person person : people) {

            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }
        }

        return oldestAge;
    }

    public static int findYoungestAge(List<Person> people) {

        if (people.isEmpty()) {
            return 0;
        }

        int youngestAge = people.get(0).getAge();

        for (Person person : people) {

            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        return youngestAge;
    }
}
