import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    void getFamily_ShouldReturnCatFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittens_NoArgs_ShouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void eatMeat_ShouldDelegateToGetFood() throws Exception {
        List<String> prey = List.of("Зебры", "Антилопы");
        doReturn(prey).when(feline).getFood("Хищник");

        List<String> actual = feline.eatMeat();

        assertEquals(prey, actual);
        verify(feline).getFood("Хищник");
    }
}
