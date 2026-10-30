public class DeliveryOrder {
    public int Order(int amount, int distanceKm, boolean express) {
        DeliveryOrder Orders = new DeliveryOrder();

        int calculate = DeliveryPricing.calculate(amount, distanceKm, express);
        System.out.println(DeliveryDemo.describeCost(calculate));
    }

    public static void main(String[] args) {
        int amount = 1;
        int distanceKm = 20;
        boolean express = true;

    }
}
