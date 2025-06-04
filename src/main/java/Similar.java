class LengthDiag {

    public static final int MAX_LENGTH_POINT = 60;
    public static final int MIN_LENGTH_POINT = 0;

    public int getLengthPoint(String input1, String input2) {
        int A = Integer.max(input1.length(), input2.length());
        int B = Integer.min(input1.length(), input2.length());

        if (isSameLength(A, B)) return MAX_LENGTH_POINT;
        if (isDoubleLengthGap(A, B)) return MIN_LENGTH_POINT;
        return getPartialLengthPoint(A, B);
    }

    private static boolean isSameLength(int A, int B) {
        return A == B;
    }

    private static boolean isDoubleLengthGap(int A, int B) {
        return A > B * 2;
    }

    private static int getPartialLengthPoint(int A, int B) {
        int Gap = A - B;
        return MAX_LENGTH_POINT - ((Gap * MAX_LENGTH_POINT) / B);
    }
}

class CharacterDiag {

    public static final int MAX_CHAR_POINT = 40;
    public static final int MIN_CHAR_POINT = 0;

    private int[] dat1;
    private int[] dat2;

    public int getCharPoint(String input1, String input2) {
        init(input1, input2);

        int totalCount = getTotalCount();
        int diffCount = getDiffCount();
        int sameCount = getSameCount();

        if (diffCount == 0) return MAX_CHAR_POINT;
        if (sameCount == 0) return MIN_CHAR_POINT;
        return getPartialPoint(sameCount, totalCount);
    }

    private void init(String input1, String input2) {
        dat1 = makeDAT(input1);
        dat2 = makeDAT(input2);
    }

    private int getPartialPoint(int sameCount, int totalCount) {
        return sameCount * MAX_CHAR_POINT / totalCount;
    }

    private int getTotalCount() {
        int totalCount = 0;
        for (int i = 0; i < 200; i++) {
            if (dat1[i] + dat2[i] >= 1) totalCount++;
        }
        return totalCount;
    }

    private int getSameCount() {
        int sameCount = 0;
        for (int i = 0; i < 200; i++) {
            if (dat1[i] + dat2[i] == 2) sameCount++;
        }
        return sameCount;
    }

    private int getDiffCount() {
        int diffCount = 0;
        for (int i = 0; i < 200; i++) {
            if (dat1[i] + dat2[i] == 1) diffCount++;
        }
        return diffCount;
    }

    private int[] makeDAT(String str) {
        int[] dat = new int[200];
        for (char ch : str.toCharArray()) {
            dat[(int)ch] = 1;
        }
        return dat;
    }
}

class SimilerCheckSystem {
    //Composition
    CharacterDiag charDiag = new CharacterDiag();
    LengthDiag lenDiag = new LengthDiag();

    public int getSimlierPoint(String input1, String input2) {
        int charPoint = charDiag.getCharPoint(input1, input2);
        int lengthPoint = lenDiag.getLengthPoint(input1, input2);
        return charPoint + lengthPoint;
    }
}