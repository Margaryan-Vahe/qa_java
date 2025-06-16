import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    void getSound_ShouldReturnSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFood_ShouldDelegateToPredatorEatMeat() throws Exception {
        List<String> food = List.of("Рыба", "Молоко");
        when(feline.eatMeat()).thenReturn(food);

        assertEquals(food, cat.getFood());
        verify(feline).eatMeat();
    }
}
