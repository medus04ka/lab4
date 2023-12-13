public class Main {
        public static void main(String[] args) {
            Shelf shelf = new Shelf();
            Goat goat = Goat.getInstance();
            Goat.DespairScenario despairScenario = goat.new DespairScenario();
            goat.interactWithShelf(shelf, despairScenario);
            shelf.putItem(new Sheet());
            shelf.putItem(new Blanket());
            shelf.putItem(new Pillow());
            goat.shareDream("о том, чтоб сантик приняли с первой попытки...");
            new TV.TVPaymentHandler().handlePayment();
            goat.watchTV();
            Goat.FallHandler fallHandler = goat.new FallHandler();
            fallHandler.handleFall();
        }
    }