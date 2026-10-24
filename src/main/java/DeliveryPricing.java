public class DeliveryPricing {
    public static int calculate(int amount, int distanceKm, boolean express) {

        if (amount < 0) {
            throw new IllegalArgumentException("Сумма заказа не может быть отрицательной");
        } else if (amount < 3000) {
            amount = 250;
            if (distanceKm < 1 || distanceKm > 100) {
                throw new IllegalArgumentException("Расстояние должно быть от 1 до 100 км");
            } else if (distanceKm > 20) {
                amount += 150;
            }
            if (express) {
                amount += 200;
            }

        } else if (amount >= 3000) {
            amount = 0;
            if (distanceKm < 1 || distanceKm > 100) {
                throw new IllegalArgumentException("Расстояние должно быть от 1 до 100 км");
            } else if (distanceKm > 20) {
                amount += 150;
            }
            if (express) {
                amount += 200;
            }
        }
        return amount;
    }
    public static void main(String[] args) {
        System.out.println(calculate(0, 20,true ));
    }
}
