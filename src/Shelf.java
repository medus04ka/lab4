import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Shelf {
    private List<ShelfItem> items;

    public Shelf() {
        this.items = new ArrayList<>();
    }

    public boolean putItem(ShelfItem item, Action action) {
        try {
            int attempts = 0;
            while (attempts < 2) {
                boolean accepted = dropSantik();
                if (accepted) {
                    items.add(item);
                    System.out.println("Козлик положил " + item.getClass().getSimpleName() + " на полочку.");
                    action.performAction(item);
                    return true;
                } else {
                    System.out.println("Что за казус, " + new PaymentException("").getMessage());
                    attempts++;
                }
            }
            System.out.println("Вторая попытка оплаты неудачна. Козлик идет спать.");
            return false;
        } catch (PaymentException e) {
            System.out.println("Что за очередной казус, " + e.getMessage());
            return false;
        }
    }

    private boolean dropSantik() throws PaymentException {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new PaymentException("Оплата не прошла!");
        }
        return true;
    }
}
