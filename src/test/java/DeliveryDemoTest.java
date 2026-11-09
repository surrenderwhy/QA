import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryDemoTest {

    @Test
    void addition_1() {
        assertEquals("Бесплатная доставка", DeliveryDemo.describeCost(0));
    }

    @Test
    void addition_2() {
        assertEquals("Стоимость доставки: 1 рублей", DeliveryDemo.describeCost(1));
    }

    @Test
    void addition_3() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryDemo.describeCost(-1);
        });
        assertEquals("Стоимость не может быть отрицательной", exception.getMessage());
    }

    @Test
    void addition_4() {
        DeliveryOrder order1 = new DeliveryOrder(2999, 10, true);
        assertEquals("Стоимость доставки: 1 рублей", DeliveryDemo.describeCost(1));
    }
//исключения
    @Test
    void addition_5() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryDemo.describeCost(DeliveryPricing.calculate(-1, 1, true));
        });
        assertEquals("Сумма заказа не может быть отрицательной", exception.getMessage());
    }

    @Test
    void addition_6() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryDemo.describeCost(DeliveryPricing.calculate(100, 0, true));
        });
        assertEquals("Расстояние должно быть от 1 до 100 км", exception.getMessage());
    }

    @Test
    void addition_7() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryDemo.describeCost(DeliveryPricing.calculate(-1, 0, true));
        });
        assertEquals("Сумма заказа не может быть отрицательной", exception.getMessage());
    }

    @Test
    void addition_8() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryDemo.describeCost(DeliveryPricing.calculate(100, 101, true));
        });
        assertEquals("Расстояние должно быть от 1 до 100 км", exception.getMessage());
    }

    @Test
    void addition_9() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryDemo.describeCost(-1);
        });
        assertEquals("Стоимость не может быть отрицательной", exception.getMessage());
    }
// валидные значения
    @ParameterizedTest
    @CsvSource({
            "2999, 20, true, Стоимость доставки: 450 рублей",
            "2999, 20, false, Стоимость доставки: 250 рублей",
            "2999, 21, true, Стоимость доставки: 600 рублей",
            "2999, 21, false, Стоимость доставки: 400 рублей",
            "3000, 20, true, Стоимость доставки: 200 рублей",
            "3000, 20, false, Бесплатная доставка",
            "3000, 21, true, Стоимость доставки: 350 рублей",
            "3000, 21, false, Стоимость доставки: 150 рублей",
    })
    void testWithCsvSource(int amount, int distanceKm, boolean express, String expectedCost) {
        assertEquals(expectedCost, DeliveryDemo.describeCost(DeliveryPricing.calculate(amount, distanceKm, express)));
    }

}
