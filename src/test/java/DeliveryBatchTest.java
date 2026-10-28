import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryBatchTest {
    @Test
    void countsPaidDeliveries_1() {
        int[] amounts = {};
        int[] distancesKm = {};
        boolean[] expressFlags = {};

        int[] actual = DeliveryBatch.summarize(amounts, distancesKm, expressFlags);
        assertArrayEquals(new int[]{0, 0, 0}, actual);
    }

    @Test
    void countsPaidDeliveries_2() {
        int[] amounts = {3000, 3000};
        int[] distancesKm = {1, 21};
        boolean[] expressFlags = {false, false};

        int[] actual = DeliveryBatch.summarize(amounts, distancesKm, expressFlags);
        assertArrayEquals(new int[]{1, 1, 0}, actual);
    }

    @Test
    void countsPaidDeliveries_3() {
        int[] amounts = {3000, 250};
        int[] distancesKm = {1, 1};
        boolean[] expressFlags = {false, false};

        int[] actual = DeliveryBatch.summarize(amounts, distancesKm, expressFlags);
        assertArrayEquals(new int[]{1, 1, 0}, actual);
    }

    @Test
    void countsPaidDeliveries_4() {
        int[] amounts = {-1, 3000};
        int[] distancesKm = {1, -1};
        boolean[] expressFlags = {false, false};

        int[] actual = DeliveryBatch.summarize(amounts, distancesKm, expressFlags);
        assertArrayEquals(new int[]{0, 0, 2}, actual);
    }

    @Test
    void countsPaidDeliveries_5_1() {
        int[] amounts = {1, -3, 3000};
        int[] distancesKm = {1, 10, 100};
        boolean[] expressFlags = {false, false, false};


        int[] actual = DeliveryBatch.summarize(amounts, distancesKm, expressFlags);
        assertArrayEquals(new int[]{2, 0, 1}, actual);
    }

    @Test
    void countsPaidDeliveries_5_2() {
        int[] amounts = {1, 3, 3000};
        int[] distancesKm = {1, -10, 100};
        boolean[] expressFlags = {false, false, false};


        int[] actual = DeliveryBatch.summarize(amounts, distancesKm, expressFlags);
        assertArrayEquals(new int[]{2, 0, 1}, actual);
    }


    @Test
    void countsPaidDeliveries_6() {
        int[] amounts1 = {1000};
        int[] distances1 = {10};
        boolean[] express1 = {false};

        int[] result1 = DeliveryBatch.summarize(amounts1, distances1, express1);
        assertArrayEquals(new int[]{1, 0, 0}, result1);

        int[] amounts2 = {3000};
        int[] distances2 = {10};
        boolean[] express2 = {false};

        int[] result2 = DeliveryBatch.summarize(amounts2, distances2, express2);

        assertArrayEquals(new int[]{0, 1, 0}, result2);
    }

    @Test
    void addition_7() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryBatch.summarize(new int[]{1, -3, 3000}, new int[]{1, -10, 100}, null);
        });
        assertEquals("Массивы не должны быть null", exception.getMessage());
    }

    @Test
    void addition_8() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryBatch.summarize(new int[]{1, -3, 3000}, null, new boolean[]{false, false, false});
        });
        assertEquals("Массивы не должны быть null", exception.getMessage());
    }

    @Test
    void addition_9() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryBatch.summarize(null, new int []{1, -10, 100}, new boolean[]{false, false, false});
        });
        assertEquals("Массивы не должны быть null", exception.getMessage());
    }

    @Test
    void addition_10() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryBatch.summarize(new int []{1, 2}, new int []{1}, new boolean[]{false, false});
        });
        assertEquals("Длины массивов должны совпадать", exception.getMessage());
    }

    @Test
    void addition_11() {
        int[] amounts = {1000};
        int[] distancesKm = {10};
        boolean[] expressFlags = {false};

        int[] amountsBefore = amounts.clone();
        int[] distancesBefore = distancesKm.clone();
        boolean[] expressBefore = expressFlags.clone();

        int[] actual = DeliveryBatch.summarize(
                amounts, distancesKm, expressFlags
        );

        assertArrayEquals(amountsBefore, amounts);
        assertArrayEquals(distancesBefore, distancesKm);
        assertArrayEquals(expressBefore, expressFlags);

        assertArrayEquals(new int[]{1, 0, 0}, actual);

    }
}
