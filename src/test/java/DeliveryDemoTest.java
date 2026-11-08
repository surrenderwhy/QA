import org.junit.jupiter.api.Test;
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

}
