package birthdates_exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Comparator;
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
     "Hello! My name is Thiss, I am 27 years old, and I was born on Friday!"
     */

    public static void printSortedPeopleInfo(List<Person> people) {
        people.stream()
                .sorted(Comparator.comparing(BirthDatesExercise::extractBirthDate))
                .forEach(BirthDatesExercise::printInfo);
    }

    private static LocalDate extractBirthDate(Person x) {
        return LocalDate.parse(x.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static void printInfo(Person x) {
        LocalDate birthDate = extractBirthDate(x);

        System.out.printf("Hello! My name is %s, I am %s years old, and I was born on %s!%n",
                x.getName(),
                birthDate.until(LocalDate.now()).getYears(),
                birthDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }
}
