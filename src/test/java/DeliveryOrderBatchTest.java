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
    void countsPaidDeliveries_5() {
        DeliveryOrder[] orders = { new DeliveryOrder(2999, 21, true),
                null,
                new DeliveryOrder(10, 21, true) };

        DeliveryOrder before0 = orders[0];
        DeliveryOrder before1 = orders[1];
        DeliveryOrder before2 = orders[2];

        int amount0 = orders[0].getAmount();
        int amount2 = orders[2].getAmount();

        int distanceKm0 = orders[0].getDistanceKm();
        int distanceKm2 = orders[2].getDistanceKm();

        boolean express0 = orders[0].isExpress();
        boolean express2 = orders[2].isExpress();

        int[] actual = DeliveryOrderBatch.summarize(orders);
        assertArrayEquals(new int[]{2, 0, 1}, actual);

        assertEquals(before0, orders[0]);
        assertEquals(before1, orders[1]);
        assertEquals(before2, orders[2]);

        assertEquals(amount0, orders[0].getAmount());
        assertEquals(distanceKm0, orders[0].getDistanceKm());
        assertEquals(express0, orders[0].isExpress());

        assertEquals(amount2, orders[2].getAmount());
        assertEquals(distanceKm2, orders[2].getDistanceKm());
        assertEquals(express2, orders[2].isExpress());
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

    @Test
    void countsPaidDeliveries_4() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            new DeliveryOrder(-1, 21, true) ;
        });
        assertEquals("Сумма заказа не может быть отрицательной", exception.getMessage());
    }

    @Test
    void countsPaidDeliveries_7() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryOrderBatch.summarize(null) ;
        });
        assertEquals("Массив заказов не должен быть null", exception.getMessage());
    }

    @Test
    void countsPaidDeliveries_8() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            new DeliveryOrder(100, 0, true) ;
        });
        assertEquals("Расстояние должно быть от 1 до 100 км", exception.getMessage());
    }

    @Test
    void countsPaidDeliveries_9() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            new DeliveryOrder(-1, 0, true) ;
        });
        assertEquals("Сумма заказа не может быть отрицательной", exception.getMessage());
    }



}
