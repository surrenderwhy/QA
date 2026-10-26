import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DeliveryPricingTest {

    @ParameterizedTest
    @CsvSource({
            "2999, 20, true, 450",
            "2999, 20, false, 250",
            "2999, 21, true, 600",
            "2999, 21, false, 400",
            "3000, 20, true, 200",
            "3000, 20, false, 0",
            "3000, 21, true, 350",
            "3000, 21, false, 150",
            "0, 1, false, 250",
            "0, 1, true, 450",
            "0, 100, false, 400",
            "0, 100, true, 600"

    })
    void testWithCsvSource(int amount, int distanceKm, boolean express, int expectedCost) {
        assertEquals(expectedCost, DeliveryPricing.calculate(amount, distanceKm, express));
    }

    @Test
    void addition_9() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryPricing.calculate(-1, 10,false );
        });
        assertEquals("Сумма заказа не может быть отрицательной", exception.getMessage());
    }
    @Test
    void addition_10() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryPricing.calculate(1000, 0,false);
        });
        assertEquals("Расстояние должно быть от 1 до 100 км", exception.getMessage());
    }
    @Test
    void addition_11() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryPricing.calculate(1000, 101,true);
        });
        assertEquals("Расстояние должно быть от 1 до 100 км", exception.getMessage());
    }
    @Test
    void addition_12() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,  () -> {
            DeliveryPricing.calculate(-1, 0,true);
        });
        assertEquals("Сумма заказа не может быть отрицательной", exception.getMessage());
    }


}
