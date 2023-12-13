import java.util.Random;

class TV {
    private static boolean isPaymentSuccessful = false;

    public static void makePayment() throws PaymentException {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new PaymentException("Телевизор требует оплату перед включением!");
        } else {
            isPaymentSuccessful = true;
            System.out.println("Оплата телевизора прошла успешно!");
        }
    }

    public static boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    public static void turnOn() {
        if (!isPaymentSuccessful()) {
            throw new TVException("Телевизор требует оплату перед включением!");
        }
        System.out.println("Козлик смотрит телевизор.");
    }

    static class TVPaymentHandler {
        public void handlePayment() {
            try {
                makePayment();
                System.out.println("Телевизор готов к работе.");
            } catch (PaymentException e) {
                System.out.println("Мне очень жаль, но " + e.getMessage());
            }
        }
    }
}
