import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilerTest {
    @Test
    void name() {
        String input1 = "ABC";
        String input2 = "BTS";
        int expected = 60;
        LengthDiag app = new LengthDiag();

        int actual = app.getLengthPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name2() {
        String input1 = "ABC";
        String input2 = "BTSSDFSD";
        int expected = 0;
        LengthDiag app = new LengthDiag();

        int actual = app.getLengthPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name3() {
        String input1 = "ABDSFSDF";
        String input2 = "BTS";
        int expected = 0;
        LengthDiag app = new LengthDiag();

        int actual = app.getLengthPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name4() {
        String input1 = "ABDSF";
        String input2 = "BTS";
        int expected = 20;
        LengthDiag app = new LengthDiag();

        int actual = app.getLengthPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name5() {
        String input1 = "AAAAABB";
        String input2 = "AB";
        int expected = 40;
        CharacterDiag app = new CharacterDiag();

        int actual = app.getCharPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name6() {
        String input1 = "TR";
        String input2 = "AAAB";
        int expected = 0;
        CharacterDiag app = new CharacterDiag();

        int actual = app.getCharPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name7() {
        String input1 = "AAU";
        String input2 = "AAAB";
        int expected = 13;
        CharacterDiag app = new CharacterDiag();

        int actual = app.getCharPoint(input1, input2);

        assertEquals(actual, expected);
    }

    @Test
    void name8() {
        String input1 = "AAU";
        String input2 = "AAAB";
        int expected = 40 + 13;
        SimilerCheckSystem app = new SimilerCheckSystem();

        int actual = app.getSimlierPoint(input1, input2);

        assertEquals(actual, expected);
    }
}