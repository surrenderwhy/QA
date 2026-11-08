class DeliveryOrder {
    int amount;
    int distanceKm;
    boolean express;

    public DeliveryOrder(int amount, int distanceKm, boolean express) {
        this.amount = amount;
        this.distanceKm = distanceKm;
        this.express = express;
    }

    String describe(){
        return "Сумма: " + this.amount + ", расстояние: " + this.distanceKm + ", express: " + this.express;
    }
}


