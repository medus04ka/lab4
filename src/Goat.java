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

    public Shok interactWithShelf(Shelf shelf, FallExecuter fallExecuter) {

        class AmazedGoat implements Shok {
            @Override
            public void amaze() {
                System.out.println("О боже я в полном недоумении от всего происходящего, неужели я это заслужил - подумал козлик");
            }
        }

        final AmazedGoat amazedGoat = new AmazedGoat();

        try {
            int attempts = 0;
            while (attempts < 2) {
                boolean santikDropped = dropSantik();
                if (santikDropped) {
                    System.out.println("Козлик уронил сантик.");
                    if (shelf.putItem(new Santik())) {
                        System.out.println("Козлик получил спальные предметы.");
                        amazedGoat.amaze();
                        return amazedGoat;
                    } else {
                        System.out.println("Язычок не принял сантик, повторная попытка оплаты.");
                    }
                } else {
                    System.out.println("Козлик положил сантик на механический язычок.");
                    attempts++;
                }
            }
            System.out.println("Вторая попытка оплаты неудачна. Козлик идет спать.");
            fallExecuter.execute();
        } catch (PaymentException e) {
            System.out.println("я просто промолчу, но.. " + e.getMessage());
        }
        return amazedGoat;
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

    class FallHandler {
        public void handleFall() {
            System.out.println("В жизни все просто, козлик неудачник, он ненавидел фембойчиков вот и поплатился");
        }
    }

    class Life {
        public void russia() {
            System.out.println("Такова жестокая жизнь в России, но по факту, он получил то, что заслужил");
        }
    }
}
