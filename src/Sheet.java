class Sheet extends BeddingItem {
    public Sheet() {
        super("Простыньку");
    }

    @Override
    public int getCost() {
        return Cost.SHEET.getCost();
    }
}
