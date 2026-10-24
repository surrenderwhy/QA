import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryPricingTest {
    @Test
    void addition_1() {
        assertEquals(450, DeliveryPricing.calculate(2999, 20,true ));
    }
    @Test
    void addition_2() {
        assertEquals(250, DeliveryPricing.calculate(2999, 20,false ));
    }
    @Test
    void addition_3() {
        assertEquals(600, DeliveryPricing.calculate(2999, 21,true ));
    }
    @Test
    void addition_4() {
        assertEquals(400, DeliveryPricing.calculate(2999, 21,false ));
    }
    @Test
    void addition_5() {
        assertEquals(200, DeliveryPricing.calculate(3000, 20,true ));
    }
    @Test
    void addition_6() {
        assertEquals(0, DeliveryPricing.calculate(3000, 20,false ));
    }
    @Test
    void addition_7() {
        assertEquals(350, DeliveryPricing.calculate(3000, 21,true ));
    }
    @Test
    void addition_8() {
        assertEquals(150, DeliveryPricing.calculate(3000, 21,false ));
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
