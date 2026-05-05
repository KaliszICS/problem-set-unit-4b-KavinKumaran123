import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PracticeProblemTest {

    @Test
    public void testOutput() {

        // saving original output
        PrintStream original = System.out;

        // capturing output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        PracticeProblem.q1();

        // checking if it matches
        assertEquals("There once was a man from St. Ives.\n", out.toString());

        // set back to normal
        System.setOut(original);
    }

    @Test
    public void testIsEven() {

        // simple checks
        assertEquals(true, PracticeProblem.isEven(4));
        assertEquals(false, PracticeProblem.isEven(5));
        assertEquals(true, PracticeProblem.isEven(0));
    }
}