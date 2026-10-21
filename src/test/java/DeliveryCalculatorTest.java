import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryCalculatorTest {
    // TODO: добавь собственные тестовые методы с @Test.
    // assertEquals(ожидаемое, DeliveryCalculator.calculateDelivery(входныеДанные));
    @Test
    void addition_1() {
        assertEquals("Сумма доставки: 250 рублей", DeliveryCalculator.calculateDelivery(0));
    }
    @Test
    void addition_2() {
        assertEquals("Сумма доставки: 0 рублей", DeliveryCalculator.calculateDelivery(3000));
    }
    @Test
    void addition_3 () {
        assertEquals("Сумма доставки: Сумма не может быть отрицательной", DeliveryCalculator.calculateDelivery((-1)));
    }
    @Test
    void addition_4() {
        assertEquals("Сумма доставки: 250 рублей", DeliveryCalculator.calculateDelivery(2999));
    }
    @Test
    void addition_5() {
        assertEquals("Сумма доставки: 0 рублей", DeliveryCalculator.calculateDelivery(3001));
    }
    @Test
    void addition_6() {
        assertEquals("Сумма доставки: 0 рублей", DeliveryCalculator.calculateDelivery(100001));
    }

}
