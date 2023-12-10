import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Goat {
    private static final Goat instance = new Goat();

    private List<ShelfItem> items;

    private Goat() {
        this.items = new ArrayList<>();
    }

    public static Goat getInstance() {
        return instance;
    }

    static class Dream {
        private String description;

        public Dream(String description) {
            this.description = description;
        }

        public void shareDream() {
            System.out.println("Козлик мечтает " + description);
        }
    }

    public void shareDream(String description) {
        Dream dream = new Dream(description);
        dream.shareDream();
    }

    public void interactWithShelf(Shelf shelf) {
        try {
            int attempts = 0;
            while (attempts < 2) {
                boolean santikDropped = dropSantik();
                if (santikDropped) {
                    System.out.println("Козлик уронил сантик.");
                    if (shelf.putItem(new Santik())) {
                        System.out.println("Козлик получил спальные предметы.");
                        return;
                    } else {
                        System.out.println("Язычок не принял сантик, повторная попытка оплаты.");
                    }
                } else {
                    System.out.println("Козлик положил сантик на механический язычок.");
                    attempts++;
                }
            }
            System.out.println("Вторая попытка оплаты неудачна. Козлик идет спать.");
        } catch (PaymentException e) {
            System.out.println("я просто промолчу, но.. " + e.getMessage());
        }
    }


    private boolean dropSantik() throws PaymentException {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new PaymentException("Оплата не принята. Язычок отверг сантик, и козлик вынужден был взглянуть на другой сантик");
        }
        return true;
    }

    public void pickUpSantik(Santik santik) {
        santik.pickUpSantik();
    }

    public void watchTV() {
        try {
            TV.makePayment();
            TV.turnOn();
            System.out.println("Стоп.. что? козлик смотрит телевизор?? у него получилось!");
        } catch (TVException | PaymentException e) {
            System.out.println("Боже казус, " + e.getMessage() + " Козлик в ауте...");
        }
    }
}
