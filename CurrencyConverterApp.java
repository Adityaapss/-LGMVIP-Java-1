import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterApp {
    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        // Exchange rates for example purposes (not up-to-date)
        EXCHANGE_RATES.put("USD", 1.0);  // 1 USD = 1 USD
        EXCHANGE_RATES.put("EUR", 0.85); // 1 USD = 0.85 EUR
        EXCHANGE_RATES.put("INR", 74.5); // 1 USD = 74.5 INR
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial currency (USD, EUR, INR): ");
        String initialCurrency = scanner.nextLine().toUpperCase();

        if (!EXCHANGE_RATES.containsKey(initialCurrency)) {
            System.out.println("Invalid initial currency.");
            scanner.close();
            return;
        }

        System.out.print("Enter the desired currency (USD, EUR, INR): ");
        String desiredCurrency = scanner.nextLine().toUpperCase();

        if (!EXCHANGE_RATES.containsKey(desiredCurrency)) {
            System.out.println("Invalid desired currency.");
            scanner.close();
            return;
        }

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(amount, initialCurrency, desiredCurrency);
        System.out.printf("%.2f %s is equal to %.2f %s%n", amount, initialCurrency, convertedAmount, desiredCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromRate = EXCHANGE_RATES.get(fromCurrency);
        double toRate = EXCHANGE_RATES.get(toCurrency);
        return amount * (toRate / fromRate);
    }
}
