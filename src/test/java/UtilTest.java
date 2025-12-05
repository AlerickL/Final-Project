import org.alerick.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    @DisplayName("hEllO -> Hello")
    void testToTitleCase1() {
        String input = "hEllO";
        String expected = "Hello";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("hEllO wOrlD -> Hello World")
    void testToTitleCase2() {
        String input = "hEllO wOrlD";
        String expected = "Hello World";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("->")
    void testToTitleCase3() {
        String input = "";
        String expected = "";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName(" -> ")
    void testToTitleCase4() {
        String input = " ";
        String expected = " ";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
}
