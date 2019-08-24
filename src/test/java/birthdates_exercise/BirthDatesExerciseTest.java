package birthdates_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest(BirthDatesExercise.class)
@RunWith(PowerMockRunner.class)
public class BirthDatesExerciseTest {

    @Test
    public void test() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

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
                new Person("Person2", "01/01/1982"),
                new Person("Person1", "01/01/1959"),
                new Person("Person3", "20/08/1972"),
                new Person("Person4", "19/08/1972")
        );

        BirthDatesExercise.printSortedPeopleInfo(people);

        String expected = "Hello! My name is Person1, I am 60 years old, and I was born on Thursday!" + System.lineSeparator() +
                "Hello! My name is Person4, I am 47 years old, and I was born on Saturday!" + System.lineSeparator() +
                "Hello! My name is Person3, I am 46 years old, and I was born on Sunday!" + System.lineSeparator() +
                "Hello! My name is Person2, I am 37 years old, and I was born on Friday!" + System.lineSeparator();

        Assert.assertEquals(expected, outContent.toString());

        System.setOut(originalOut);
    }
}
