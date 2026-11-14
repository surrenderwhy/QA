public class DeliveryOrderBatch {

    public static int[] summarize(DeliveryOrder[] orders) {

        int paid = 0;
        int free = 0;
        int error = 0;

        if (orders == null) {
            throw new IllegalArgumentException("Массив заказов не должен быть null");
        }

        for (int i = 0; i < orders.length; i++) {
                try {
                    int calculate = DeliveryDemo.calculateOrder(orders[i]);
                    if (calculate > 0) {
                        paid++;
                    } else if (calculate  == 0) {
                        free++;
                    }
                }
                catch (IllegalArgumentException e) {
                    error++;
                }
        }
        return new int[]{paid, free, error};

    }
    public static void main(String[] args) {
        DeliveryOrder[] orders = {
                new DeliveryOrder(2999, 21, true),
                new DeliveryOrder(3000, 10, false),
                new DeliveryOrder(10, 21, true)
        };

        int[] result = summarize(orders);
        System.out.println(java.util.Arrays.toString(result));
    }
}
