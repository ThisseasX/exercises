package dto_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest(DTOExercise.class)
@RunWith(PowerMockRunner.class)
public class DTOExerciseTest {

    @Test
    public void test() throws Exception {
        LocalDate mockedLocalDate = LocalDate.of(2019, Month.AUGUST, 19);
        Calendar c = Calendar.getInstance();
        c.set(2019, Calendar.AUGUST, 19);
        Date mockedCurrentDate = c.getTime();
        long mockedCurrentTime = mockedCurrentDate.getTime();

        spy(LocalDate.class);
        spy(Instant.class);
        spy(System.class);
        when(LocalDate.now()).thenReturn(mockedLocalDate);
        when(Instant.now()).thenReturn(mockedCurrentDate.toInstant());
        when(System.currentTimeMillis()).thenReturn(mockedCurrentTime);
        whenNew(Date.class).withNoArguments().thenReturn(mockedCurrentDate);

        List<Person> people = Arrays.asList(
                new Person("Person1", "01/01/1959"),
                new Person("Person2", "01/01/1982"),
                new Person("Person3", "20/08/1972"),
                new Person("Person4", "19/08/1972")
        );

        List<PersonDTO> transformedPeople = Arrays.asList(
                new PersonDTO("Person1", 60),
                new PersonDTO("Person2", 37),
                new PersonDTO("Person3", 46),
                new PersonDTO("Person4", 47)
        );

        Assert.assertEquals(transformedPeople, DTOExercise.calculateAgesAndTransform(people));
    }
}
