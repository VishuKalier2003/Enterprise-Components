
public class Assertions {

    public static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError("FAILED: " + message +
                                 " | expected=" + expected +
                                 " | actual=" + actual);
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) throw new AssertionError("FAILED: " + message);
    }

    public static final String SPACE = "-----------------------------------------------";

    public static void log(String testName, Runnable test) {
        try {
            test.run();
            System.out.println(SPACE);
            System.out.println("PASSED: " + testName);
            System.out.println(SPACE);
        } catch (Throwable e) {
            System.out.println(SPACE);
            System.out.println("FAILED: " + testName + " → " + e.getMessage());
            System.out.println(SPACE);
        }
    }
}
