class DeliveryOrder {
    private int amount;
    private int distanceKm;
    private boolean express;

    public DeliveryOrder(int amount, int distanceKm, boolean express) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма заказа не может быть отрицательной");
        }
        if (distanceKm < 1 || distanceKm > 100) {
            throw new IllegalArgumentException("Расстояние должно быть от 1 до 100 км");
        }

        this.amount = amount;
        this.distanceKm = distanceKm;
        this.express = express;
    }

    String describe(){
        return "Сумма: " + this.amount + ", расстояние: " + this.distanceKm + ", express: " + this.express;
    }

    public int getAmount(){
        return amount;
    }

    public int getDistanceKm(){
        return distanceKm;
    }

    public boolean isExpress(){
        return express;
    }
}


