enum Cost {
    SANTIK(1),
    SHEET(1),
    BLANKET(1),
    PILLOW(2),
    TV_PAYMENT(5);

    private final int cost;

    Cost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
