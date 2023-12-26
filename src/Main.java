public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        Goat goat = Goat.getInstance();
        FallExecuter fallExecuter = new FallExecuter() {
            @Override
            public void execute() {
                System.out.println("Козлик от бессилия повернулся и споткнулся, он смарчно ударился головой, ой ой наверное это больно)()))(()())(())()(()()())(())(()()");
            }
        };
        goat.interactWithShelf(shelf, fallExecuter);
        shelf.putItem(new Sheet(), item -> System.out.println("Козлик с грустью посмотрел на " + item.getClass().getSimpleName()));
        shelf.putItem(new Blanket(), item -> System.out.println("Козлик с грустью посмотрел на " + item.getClass().getSimpleName()));
        shelf.putItem(new Pillow(), item -> System.out.println("Козлик с грустью посмотрел на " + item.getClass().getSimpleName()));
        goat.shareDream("о том, чтоб сантик приняли с первой попытки...");
        new TV.TVPaymentHandler().handlePayment();
        goat.watchTV();
        fallExecuter.execute();
        Goat.FallHandler fallHandler = goat.new FallHandler();
        fallHandler.handleFall();
        Shok amazedGoat = goat.interactWithShelf(shelf, fallExecuter);
        amazedGoat.amaze();
        Goat.Life life = goat.new Life();
        life.russia();
    }
}