import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CorrectBracketSequenceCheckerTest {


    @Order(value = 1)
    @Test
    void checkEmptySequence() {
        assertTrue(CorrectBracketSequenceChecker.checkSequence(""));
        assertTrue(CorrectBracketSequenceChecker.checkSequence("[]"));
        assertTrue(CorrectBracketSequenceChecker.checkSequence("{}()"));
        assertTrue(CorrectBracketSequenceChecker.checkSequence("{[]}"));
        assertTrue(CorrectBracketSequenceChecker.checkSequence("{}[({}[])]"));
        assertTrue(CorrectBracketSequenceChecker.checkSequence("[][][][][][]"));

    }

    @Order(value = 2)
    @Test
    void checkToLongSequence() {
        assertThrows(IllegalArgumentException.class, ()-> {
            CorrectBracketSequenceChecker.checkSequence("[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]");
        });
    }

    @Order(value = 3)
    @Test
    void checkWrongSymbolsSequence() {
        assertThrows(IllegalArgumentException.class, ()-> {
            CorrectBracketSequenceChecker.checkSequence("lplplp");
        });
        assertThrows(IllegalArgumentException.class, ()-> {
            CorrectBracketSequenceChecker.checkSequence("[]{}(pp)");
        });
    }
    @Order(value = 4)
    @Test
    void checkWrongOrderSequence() {
        assertThrows(IllegalArgumentException.class, ()-> {
            CorrectBracketSequenceChecker.checkSequence("][{}[]");
        });
    }


    @Order(value = 5)
    @Test
    void getFailChecksCount() {
        assertEquals(4,CorrectBracketSequenceChecker.getFailChecksCount());
    }
    @Order(value = 6)
    @Test
    void getSuccessChecksCount() {
        assertEquals(6,CorrectBracketSequenceChecker.getSuccessChecksCount());
    }
    @Order(value = 7)
    @Test
    void getLastSuccessSequence() {
        assertEquals("[][][][][][]",CorrectBracketSequenceChecker.getLastSuccessSequence());
    }
}