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
        return people.stream()
                .map(DTOExercise::mapToDTO)
                .collect(Collectors.toList());
    }

    private static PersonDTO mapToDTO(Person x) {
        LocalDate birthDate = LocalDate.parse(x.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new PersonDTO(x.getName(), birthDate.until(LocalDate.now()).getYears());
    }
}
