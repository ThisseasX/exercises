package birthdates_exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class BirthDatesExercise {

    /*
     * Please make an app that:

     • Has a Person class with:
     ° String name
     ° String dateOfBirth

     • Has a List of Person instances

     • Sort the people list by age from oldest to youngest

     • For each Person in the list, print the day of the week they were born on, their name, and their age

     e.g.
     Person thiss = new Person("Thiss", "07/08/1992"):

     should print:
     "Hello, I am Thiss, I am 27 years old and I was born on a Friday"
     */

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void printSortedPeopleInfo(List<Person> people) {
        people.stream()
                .sorted(BirthDatesExercise::comparePeopleByBirthDate)
                .forEach(BirthDatesExercise::printPersonInfo);
    }

    private static int comparePeopleByBirthDate(Person a, Person b) {
        LocalDate dateA = LocalDate
                .parse(a.getDateOfBirth(), formatter);

        LocalDate dateB = LocalDate
                .parse(b.getDateOfBirth(), formatter);

        return dateA.compareTo(dateB);
    }

    private static void printPersonInfo(Person person) {
        LocalDate birthDate = LocalDate
                .parse(person.getDateOfBirth(), formatter);

        String dayOfBirth = birthDate
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        int age = birthDate
                .until(LocalDate.now())
                .getYears();

        System.out.printf("Hello! My name is %s, I am %s years old, and I was born on %s!%n",
                person.getName(),
                age,
                dayOfBirth
        );
    }
}
