import java.util.ArrayList;
import java.util.Collections;

public class SimilarityChecker {

    private static final int MAX_ALPHA_SCORE = 40;
    public static final int MIN_ALPHA_SCORE = 0;

    public int checkLength(String a, String b) {
        int longLen = Math.max(a.length(), b.length());
        int shortLen = Math.min(a.length(), b.length());

        return getScore(shortLen, longLen);
    }

    private int getScore(int shortLen, int longLen) {
        int e = 2 * shortLen - longLen;

        if (e <= 0) return 0;
        return (e * 60) / shortLen;
    }

    public int checkAlpha(String a, String b) {
        if (isZeroSameAlphaCount(a, b)) return MIN_ALPHA_SCORE;
        if (isAllSameAlphaCount(a, b)) return MAX_ALPHA_SCORE;
        return getPartialScore(a, b);
    }

    private int getPartialScore(String a, String b) {
        ArrayList<Character> aDistinctCharList = getDistinctCharList(a.toCharArray());
        ArrayList<Character> bDistinctCharList = getDistinctCharList(b.toCharArray());

        Collections.sort(aDistinctCharList);
        Collections.sort(bDistinctCharList);

        int totalAlphaCount = getTotalAlphaCount(a, b);
        int sameAlphaCount = getSameAlphaCount(aDistinctCharList, bDistinctCharList);

        return (MAX_ALPHA_SCORE * sameAlphaCount) / totalAlphaCount;
    }

    private static int getTotalAlphaCount(String a, String b) {
        return a.length() + b.length();
    }

    private boolean isZeroSameAlphaCount(String a, String b) {
        ArrayList<Character> aDistinctCharList = getDistinctCharList(a.toCharArray());
        ArrayList<Character> bDistinctCharList = getDistinctCharList(b.toCharArray());

        Collections.sort(aDistinctCharList);
        Collections.sort(bDistinctCharList);

        int sameAlphaCount = getSameAlphaCount(aDistinctCharList, bDistinctCharList);
        return sameAlphaCount == 0;
    }

    private boolean isAllSameAlphaCount(String a, String b) {
        ArrayList<Character> aDistinctCharList = getDistinctCharList(a.toCharArray());
        ArrayList<Character> bDistinctCharList = getDistinctCharList(b.toCharArray());

        Collections.sort(aDistinctCharList);
        Collections.sort(bDistinctCharList);

        int sameAlphaCount = getSameAlphaCount(aDistinctCharList, bDistinctCharList);
        return sameAlphaCount == Math.max(aDistinctCharList.size(), bDistinctCharList.size());
    }

    private ArrayList<Character> getDistinctCharList(char[] charArray) {
        ArrayList<Character> charList = new ArrayList<>();
        for (Character c : charArray) {
            if (charList.contains(c)) continue;
            charList.add(c);
        }
        return charList;
    }

    private static int getSameAlphaCount(ArrayList<Character> aDistinctCharList, ArrayList<Character> bDistinctCharList) {
        int sameAlphaCount = 0;
        for (int i = 0; i < Math.min(aDistinctCharList.size(), bDistinctCharList.size()); i++) {
            if (aDistinctCharList.get(i) == bDistinctCharList.get(i)) {
                sameAlphaCount++;
            }
        }
        return sameAlphaCount;
    }
}
