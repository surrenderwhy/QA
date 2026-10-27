public class DeliveryBatch {
    public static int[] summarize(int[] amounts, int[] distancesKm, boolean[] expressFlags) {

        if (amounts == null || distancesKm == null || expressFlags == null) {
            throw new IllegalArgumentException("Массивы не должны быть null");
        }

        if (amounts.length != distancesKm.length || amounts.length != expressFlags.length) {
            throw new IllegalArgumentException("Длины массивов должны совпадать");
        } else {
            int paid = 0;
            int free = 0;
            int error = 0;

            for (int i = 0; i < amounts.length; i++) {
                try {
                    int calculate = DeliveryPricing.calculate(amounts[i], distancesKm[i], expressFlags[i]);
                    if (calculate > 0) {
                        paid++;
                    } else if (calculate  == 0) {
                        free++;
                    }
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Сумма заказа не может быть отрицательной");
                    error++;
                }
            }
            return new int[]{paid, free, error};
        }
    }

    public static void main(String[] args) {
        int[] amounts = {1000, 3000, -1};
        int[] distancesKm = {10, 20, 10};
        boolean[] expressFlags = {false, false, false};

        int[] result = summarize(amounts, distancesKm, expressFlags);
        System.out.println(java.util.Arrays.toString(result));
    }
}
