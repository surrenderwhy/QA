public class DeliveryCalculator {
    public static String calculateDelivery(int amount) {
        int number = 3000;
        String delivery = "";
        if (number >= 0 && number <= 2999) {
            delivery = "250 рублей";
        } else if (number >= 3000) {
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
