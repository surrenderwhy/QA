public class DeliveryDemo {
    public static String describeCost(int cost) {
        String delivery;
        if (cost == 0 ) {
            delivery = "Бесплатная доставка";
        } else if (cost > 0) {
            delivery = "Стоимость доставки: " + cost + " рублей";
        } else {
            throw new IllegalArgumentException("Стоимость не может быть отрицательной");
        }
        return delivery;
    }

    public static void main(String[] args) {

        DeliveryOrder order1 = new DeliveryOrder(2999, 10, true);
        DeliveryOrder order2 = new DeliveryOrder(3000, 100, true);
        DeliveryOrder order3 = new DeliveryOrder(0, 21, true);
        DeliveryOrder Link = new DeliveryOrder(100, 10, true);

        int calculate1 = DeliveryPricing.calculate(order1.getAmount(), order1.getDistanceKm(), order1.isExpress());
        int calculate2 = DeliveryPricing.calculate(order2.getAmount(), order2.getDistanceKm(),order2.isExpress());
        int calculate3 = DeliveryPricing.calculate(order3.getAmount(), order3.getDistanceKm(), order3.isExpress());

        System.out.println(describeCost(calculate1));
        System.out.println(describeCost(calculate2));
        System.out.println(describeCost(calculate3));

        System.out.println("Расстояние order1: " + order1.getDistanceKm());
        System.out.println("Расстояние order2: " + order2.getDistanceKm());
        System.out.println("Расстояние order3: " + order3.getDistanceKm());

        System.out.println("order1: " + describeCost(DeliveryPricing.calculate(order1.getAmount(), order1.getDistanceKm(), order1.isExpress())));
        System.out.println("order2: " + describeCost(DeliveryPricing.calculate(order2.getAmount(), order2.getDistanceKm(), order2.isExpress())));
        System.out.println("order3: " + describeCost(DeliveryPricing.calculate(order3.getAmount(), order3.getDistanceKm(), order3.isExpress())));

        DeliveryOrder link = order1;

        System.out.println("Сумма order1: " + order1.getAmount());

        System.out.println("Сумма Link: " + Link.getAmount());

    }

    static int calculateOrder(DeliveryOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Заказ не должен быть null");
        }

        return DeliveryPricing.calculate(
            order.getAmount(),
            order.getDistanceKm(),
            order.isExpress()
        );
    }
}
