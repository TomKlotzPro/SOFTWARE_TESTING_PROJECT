package modele;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MockitoTest {

    @Mock
    private ActionsBDImpl actionsBD;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void getProgrammeursSize(){ //ne sert pas à grand chose
        when(actionsBD.getProgrammeurs()).thenReturn((ArrayList) Stream.of(new ProgrammeurBean(), new ProgrammeurBean()).collect(Collectors.toList()));
        assertEquals(2, actionsBD.getProgrammeurs().size());
    }
}
