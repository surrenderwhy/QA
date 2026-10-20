public class DeliveryCalculator {
    public static String calculateDelivery(int amount) {

        String delivery = "";
        if (amount >= 0 && amount <= 2999) {
            delivery = "250 рублей";
        } else if (amount >= 3000) {
            delivery = "0 рублей";
        } else {
            delivery = "Сумма не может быть отрицательной";
        }
        return "Сумма доставки: "+ delivery;
    }
    public static void main(String[] args) {
        System.out.println(calculateDelivery(2999));
    }
}
