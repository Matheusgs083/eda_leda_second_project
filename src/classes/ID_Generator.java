<<<<<<< HEAD
package classes;
import java.util.concurrent.ThreadLocalRandom;

public class ID_Generator {
    private static final int MAX_IDS = 20; // Ajuste conforme necessário
    private static final long[] usedIds = new long[MAX_IDS];
    private static int currentIndex = 0;

    public static long generateUniqueID() {
        long id;
        boolean isUnique;
        do {
            id = ThreadLocalRandom.current().nextLong(MAX_IDS);
            isUnique = true;
            for (int i = 0; i < currentIndex; i++) {
                if (usedIds[i] == id) {
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        usedIds[currentIndex++] = id;
        return id;
    }
=======
package classes;
import java.util.concurrent.ThreadLocalRandom;

public class ID_Generator {
    private static final int MAX_IDS = 20; // Ajuste conforme necessário
    private static final long[] usedIds = new long[MAX_IDS];
    private static int currentIndex = 0;

    public static long generateUniqueID() {
        long id;
        boolean isUnique;
        do {
            id = ThreadLocalRandom.current().nextLong(MAX_IDS);
            isUnique = true;
            for (int i = 0; i < currentIndex; i++) {
                if (usedIds[i] == id) {
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        usedIds[currentIndex++] = id;
        return id;
    }
>>>>>>> df0225b50ad3df1b24a52cb23229fb2aed54dd15
}