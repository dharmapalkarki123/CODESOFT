package converter;

public interface ExchangeRateProvider {
    double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception;
}

