public class DeliveryDemo {
    public static String describeCost(int cost) {
        String delivery;
        if (cost == 0 ) {
            delivery = "Бесплатная доставка";
        } else if (cost > 0) {
            delivery = "Стоимость доставки: " + cost + " рублей";
        } else {
            throw new IllegalArgumentException("Стоимость  не может быть отрицательной");
        }
        return delivery;
    }

    public static void main(String[] args) {

        DeliveryOrder order1 = new DeliveryOrder();
        DeliveryOrder order2 = new DeliveryOrder();
        DeliveryOrder order3 = new DeliveryOrder();

        order1.amount = 2999;
        order1.distanceKm = 10;
        order1.express = true;

        order2.amount = 3000;
        order2.distanceKm = 50;
        order2.express = true;

        order3.amount = 500;
        order3.distanceKm = 10;
        order3.express = true;

        int calculate1 = DeliveryPricing.calculate(order1.amount, order1.distanceKm, order1.express);
        int calculate2 = DeliveryPricing.calculate(order2.amount, order2.distanceKm,order2.express);
        int calculate3 = DeliveryPricing.calculate(order3.amount, order3.distanceKm, order3.express);
        System.out.println(describeCost(calculate1));
        System.out.println(describeCost(calculate2));
        System.out.println(describeCost(calculate3));

        System.out.println("Расстояние order1: " + order1.distanceKm); // 10
        System.out.println("Расстояние order2: " + order2.distanceKm); // 50
        System.out.println("Расстояние order3: " + order3.distanceKm); // 10

        DeliveryOrder link = order1;
        link.amount = 1000;
        System.out.println("Сумма order1: " + order1.amount);
    }
}
