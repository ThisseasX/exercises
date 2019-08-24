package dto_exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DTOExerciseTest {

    @Test
    public void test() {
        List<Person> people = Arrays.asList(
                new Person("p1", "01/01/2009"),
                new Person("p2", "01/01/1999")
        );

        List<PersonDTO> transformedPeople = Arrays.asList(
                new PersonDTO("p1", 10),
                new PersonDTO("p2", 20)
        );

        Assert.assertEquals(transformedPeople, DTOExercise.calculateAgesAndTransform(people));
    }
}
