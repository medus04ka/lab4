class Pillow extends BeddingItem {
    public Pillow() {
        super("Подушечку");
    }

    @Override
    public int getCost() {
        return Cost.PILLOW.getCost();
    }
}
