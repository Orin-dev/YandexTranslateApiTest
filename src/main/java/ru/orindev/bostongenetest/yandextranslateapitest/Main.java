package ru.orindev.bostongenetest.yandextranslateapitest;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String URL_YANDEX = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=";

    private static final RestTemplate restTemplate = new RestTemplate();

    private static String apiKey;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Plaese, enter your api key.");

        apiKey = scanner.nextLine();

        System.out.println("Ready to translate. Plaese, enter your phrase.");

        while (true) {
            String phrase = scanner.nextLine();
            if (phrase.equals("exit!")) break;
            String result = translateToRussian(phrase, apiKey);
            System.out.println(result);
        }

    }

    protected static String translateToRussian(String phrase, String apiKey) {
        String address = URL_YANDEX + apiKey +
                "&text=" + phrase + "&lang=en-ru";

        HttpEntity<YandexApiResponse> responseEntity = restTemplate.getForEntity(address, YandexApiResponse.class);
        List<String> translatedWordsList = responseEntity.getBody().getText();
        String result = "";
        for (String s:translatedWordsList
             ) {
            result += s;
        }
        return result;
    }
}