abstract class BeddingItem implements ShelfItem {
    private final String name;

    public BeddingItem(String name) {
        this.name = name;
    }

    @Override
    public void use() {
        System.out.println("Козлик забрал " + name);
    }
}
