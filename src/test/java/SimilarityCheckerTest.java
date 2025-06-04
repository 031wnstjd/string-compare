import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {

    private SimilarityChecker similarityChecker;

    @BeforeEach
    void setUp() {
        similarityChecker = new SimilarityChecker();
    }

    @Test
    void checkLengthTest_WhenSameCharacterCount() {
        assertEquals(60, similarityChecker.checkLength("ASD", "DSA"));
    }


    @Test
    void checkLengthTest_WhenLengthDiffIsMoreThanTwice() {
        assertEquals(0, similarityChecker.checkLength("ABCDE", "AB"));
    }

    @Test
    void checkLengthTest_WhenLengthDiffIsMoreThanTwice2() {
        assertEquals( 0, similarityChecker.checkLength("AB", "ABCDE"));
    }

    @Test
    void checkLengthTest_WhenPartScore1() {
        assertEquals(20, similarityChecker.checkLength("AAABB", "BAA"));
    }

    @Test
    void checkLengthTest_WhenPartScore2() {
        assertEquals(30, similarityChecker.checkLength("AA", "AAE"));
    }
}