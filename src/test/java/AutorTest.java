import com.teste.implementabiblioteca.Author;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    public void Test_Construtor() {
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15T00:00:00Z").toInstant(ZoneOffset.UTC);

        Author atual = new Author("Jorge", "Lucas", data_nascimento_autor, 1);
        assertEquals("Jorge", atual.getNome());
        assertEquals("Lucas", atual.getSobrenome());
        assertEquals(data_nascimento_autor, atual.getData_nascimento());
        assertEquals(1, atual.getId_autor());

    }
}