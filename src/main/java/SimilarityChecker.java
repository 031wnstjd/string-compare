public class SimilarityChecker {

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
}
