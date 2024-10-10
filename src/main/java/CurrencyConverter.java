import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {

    private static final String API_KEY = "56746dbf54d694c7beca225f";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private static final Set<String> validCurrencies = new HashSet<>();

    static {
        validCurrencies.add("USD");
        validCurrencies.add("EUR");
        validCurrencies.add("GBP");
        validCurrencies.add("JPY");
        validCurrencies.add("CAD");
        validCurrencies.add("COP");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fromCurrency = getCurrency(scanner, "origen");
        double amount = getAmount(scanner);
        String toCurrency = getCurrency(scanner, "destino");

        double result = convertirMoneda(fromCurrency, toCurrency, amount);

        if (result != -1) {
            System.out.printf("El monto de %.2f %s convertido a %s es: %.2f %s\n", amount, fromCurrency, toCurrency, result, toCurrency);
        } else {
            System.out.println("Hubo un error durante la conversión, por favor intenta nuevamente.");
        }

        double copResult = convertirMoneda(fromCurrency, "COP", amount);
        if (copResult != -1) {
            System.out.printf("El monto de %.2f %s convertido a pesos colombianos (COP) es: %.2f COP\n", amount, fromCurrency, copResult);
        } else {
            System.out.println("No se pudo realizar la conversión a pesos colombianos.");
        }

        scanner.close();
    }

    private static String getCurrency(Scanner scanner, String tipo) {
        String currency;
        while (true) {
            System.out.printf("Introduce el código de la moneda de %s USD): ", tipo);
            currency = scanner.next().toUpperCase();

            if (validCurrencies.contains(currency)) {
                break;
            } else {
                System.out.println("Inválido. Intenta nuevamente.");
            }
        }
        return currency;
    }

    private static double getAmount(Scanner scanner) {
        double amount = 0;
        while (true) {
            System.out.print("Por favor, introduce la cantidad que deseas convertir: ");
            try {
                amount = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("La cantidad ingresada no es válida. Asegúrate de ingresar un número.");
                scanner.next();
            }
        }
        return amount;
    }

    public static double convertirMoneda(String fromCurrency, String toCurrency, double amount) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + fromCurrency))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return calcularConversion(response.body(), toCurrency, amount);
            } else {
                System.out.println("Error en la solicitud a la API. Código de estado: " + response.statusCode());
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Hubo un error al conectarse a la API. Por favor, verifica tu conexión a internet e intenta nuevamente.");
            return -1;
        }
    }

    private static double calcularConversion(String jsonString, String toCurrency, double amount) {
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        if (conversionRates.has(toCurrency)) {
            double exchangeRate = conversionRates.get(toCurrency).getAsDouble();
            return amount * exchangeRate;
        } else {
            System.out.println("La moneda de destino '" + toCurrency + "' no está disponible para la conversión.");
            return -1;
        }
    }
}
