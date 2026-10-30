public class DeliveryDemo {
    public static String describeCost(int cost) {
        String delivery;
        if (cost == 0 ) {
            delivery = "Бесплатная доставка";
        } else if (cost > 0) {
            delivery = "Стоимость доставки: N рублей";
        } else {
            throw new IllegalArgumentException("Стоимость  не может быть отрицательной");
        }

        return delivery;
    }

    public static void main(String[] args) {
        System.out.println(describeCost(1));
    }
}
