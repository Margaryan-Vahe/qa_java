import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class FelineParameterizedTest {
    private final Feline feline = new Feline();

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "0, 0",
            "3, 3"
    })
    void getKittens_WithArgs_ShouldReturnPassedCount(int count, int expected) {
        assertEquals(expected, feline.getKittens(count));
    }
}
