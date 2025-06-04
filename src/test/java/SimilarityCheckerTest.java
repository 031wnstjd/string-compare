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

    @Test
    void checkAlphaTest_WhenSameKindAlpha() {
        assertEquals(40, similarityChecker.checkAlpha("ASD", "DSA"));
    }

    @Test
    void checkAlphaTest_WhenSameKindAlpha2() {
        assertEquals(40, similarityChecker.checkAlpha("AAAABB", "AB"));
    }

    @Test
    void checkAlphaTest_WhenSameKindAlpha3() {
        assertEquals(40, similarityChecker.checkAlpha("AAAABB", "AB"));
    }

    @Test
    void checkAlphaTest_WhenAllAlphaDiff() {
        assertEquals(0, similarityChecker.checkAlpha("A", "BB"));
    }

    @Test
    void checkAlphaTest_WhenPartialScore() {
        assertEquals(8, similarityChecker.checkAlpha("AA", "AAE"));
    }
}