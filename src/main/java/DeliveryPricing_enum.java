public class DeliveryPricing_enum {
    public static int calculateDemo(int amount, int distanceKm, DeliveryMode delivery) {
        boolean isExpress = (delivery == DeliveryMode.EXPRESS);
        return DeliveryPricing.calculate(amount, distanceKm, isExpress);
    }
    public static void main(String[] args) {
        System.out.println(calculateDemo(0, 20,DeliveryMode.EXPRESS ));
        System.out.println(calculateDemo(0, 20,DeliveryMode.STANDARD));
    }
}
