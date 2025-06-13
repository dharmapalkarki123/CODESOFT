package converter;



public class CurrencyConverter {
    private String baseCurrency;
    private String targetCurrency;
    private double amount;
    private ExchangeRateProvider rateProvider;

    public CurrencyConverter(String baseCurrency, String targetCurrency, double amount, ExchangeRateProvider provider) {
        this.baseCurrency = baseCurrency.toUpperCase();
        this.targetCurrency = targetCurrency.toUpperCase();
        this.amount = amount;
        this.rateProvider = provider;
    }

    public void convertAndDisplay() {
        try {
            double rate = rateProvider.getExchangeRate(baseCurrency, targetCurrency);
            double converted = amount * rate;
            System.out.printf("Exchange Rate: 1 %s = %.2f %s%n", baseCurrency, rate, targetCurrency);
            System.out.printf("Converted Amount: %.2f %s = %.2f %s%n",
                    amount, baseCurrency, converted, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getConvertedResultString() throws Exception {
        double rate = rateProvider.getExchangeRate(baseCurrency, targetCurrency);
        double converted = amount * rate;
        return String.format("1 %s = %.2f %s | %.2f %s = %.2f %s",
                baseCurrency, rate, targetCurrency,
                amount, baseCurrency, converted, targetCurrency);
    }

}
