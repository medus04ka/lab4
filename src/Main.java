public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        Goat goat = Goat.getInstance();

        goat.interactWithShelf(shelf);
        shelf.putItem(new Sheet());
        shelf.putItem(new Blanket());
        shelf.putItem(new Pillow());

        goat.watchTV();
    }
}
