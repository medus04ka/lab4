class Blanket extends BeddingItem {
    public Blanket() {
        super("Одеялко");
    }

    @Override
    public int getCost() {
        return Cost.BLANKET.getCost();
    }
}
