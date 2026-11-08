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

        int calculate1 = DeliveryPricing.calculate(order1.amount, order1.distanceKm, order1.express);
        int calculate2 = DeliveryPricing.calculate(order2.amount, order2.distanceKm,order2.express);
        int calculate3 = DeliveryPricing.calculate(order3.amount, order3.distanceKm, order3.express);

        System.out.println(describeCost(calculate1));
        System.out.println(describeCost(calculate2));
        System.out.println(describeCost(calculate3));

        System.out.println("Расстояние order1: " + order1.distanceKm);
        System.out.println("Расстояние order2: " + order2.distanceKm);
        System.out.println("Расстояние order3: " + order3.distanceKm);

        order2.distanceKm = 10;

        System.out.println("Расстояние order2: " + order2.distanceKm);
        System.out.println("order1: " + describeCost(DeliveryPricing.calculate(order1.amount, order1.distanceKm, order1.express)));
        System.out.println("order2: " + describeCost(DeliveryPricing.calculate(order2.amount, order2.distanceKm, order2.express)));
        System.out.println("order3: " + describeCost(DeliveryPricing.calculate(order3.amount, order3.distanceKm, order3.express)));

        DeliveryOrder link = order1;
        link.amount = 1000;
        System.out.println("Сумма order1: " + order1.amount);

        System.out.println("Сумма Link: " + Link.amount);

    }
}
