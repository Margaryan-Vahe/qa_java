import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    @Mock
    private Feline felineMock;

    @Test
    void constructor_InvalidSex_ShouldThrowException() {
        Exception ex = assertThrows(Exception.class,
                () -> new Lion("Некто", felineMock));
        assertTrue(ex.getMessage().contains("Используйте допустимые значения пола"));
    }

    @Test
    void getKittens_ShouldDelegate() throws Exception {
        when(felineMock.getKittens()).thenReturn(7);
        Lion lion = new Lion("Самец", felineMock);

        assertEquals(7, lion.getKittens());
        verify(felineMock).getKittens();
    }

    @Test
    void getFood_ShouldDelegate() throws Exception {
        List<String> prey = List.of("Антилопы");
        when(felineMock.getFood("Хищник")).thenReturn(prey);
        Lion lion = new Lion("Самец", felineMock);

        assertEquals(prey, lion.getFood());
        verify(felineMock).getFood("Хищник");
    }

    @Test
    void getFood_ShouldPropagateException() throws Exception {
        when(felineMock.getFood("Хищник")).thenThrow(new Exception("fail"));
        Lion lion = new Lion("Самец", felineMock);

        assertThrows(Exception.class, lion::getFood);
    }

}
