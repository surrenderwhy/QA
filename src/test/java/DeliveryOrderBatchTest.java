import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryOrderBatchTest {
    @Test
    void countsPaidDeliveries_1() {
        DeliveryOrder[] orders = {};

        int[] actual = DeliveryOrderBatch.summarize(orders);
        assertArrayEquals(new int[]{0, 0, 0}, actual);
    }

    @Test
    void countsPaidDeliveries_2() {
        DeliveryOrder[] orders = { new DeliveryOrder(3000, 10, false) };

        int[] actual = DeliveryOrderBatch.summarize(orders);
        assertArrayEquals(new int[]{0, 1, 0}, actual);
    }

    @Test
    void countsPaidDeliveries_3() {
        DeliveryOrder[] orders = { new DeliveryOrder(2999, 21, true) };

        int[] actual = DeliveryOrderBatch.summarize(orders);
        assertArrayEquals(new int[]{1, 0, 0}, actual);
    }

    @Test
    void countsPaidDeliveries_4() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryOrderBatch.summarize(null) ;
        });
        assertEquals("Массив заказов не должен быть null", exception.getMessage());
    }

    @Test
    void countsPaidDeliveries_5() {
        DeliveryOrder[] orders = { new DeliveryOrder(2999, 21, true),
                null,
                new DeliveryOrder(10, 21, true) };

        int[] actual = DeliveryOrderBatch.summarize(orders);
        assertArrayEquals(new int[]{2, 0, 1}, actual);
    }

    @Test
    void countsPaidDeliveries_6() {
        DeliveryOrder[] orders1 = { new DeliveryOrder(2999, 21, true) };

        int[] result1 = DeliveryOrderBatch.summarize(orders1);
        assertArrayEquals(new int[]{1, 0, 0}, result1);

        DeliveryOrder[] orders2 = { new DeliveryOrder(3000, 20, false) };

        int[] result2 = DeliveryOrderBatch.summarize(orders2);
        assertArrayEquals(new int[]{0, 1, 0}, result2);
    }
}
