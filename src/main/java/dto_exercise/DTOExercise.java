package dto_exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DTOExercise {

    /*
     * Please make an app with:
        • A method that takes a List<Person> and returns a List<PersonDTO> (their ages should be accurate)
     */

    public static List<PersonDTO> calculateAgesAndTransform(List<Person> people) {
        return people.stream().map(person -> {
            LocalDate birthDate = LocalDate.parse(person.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int age = birthDate.until(LocalDate.now()).getYears();
            return new PersonDTO(person.getName(), age);
        }).collect(Collectors.toList());
    }
}
