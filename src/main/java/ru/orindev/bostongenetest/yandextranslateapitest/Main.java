package ru.orindev.bostongenetest.yandextranslateapitest;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Orin on 13.04.2018.
 */

public class Main {

    private static final String API_KEY = "trnsl.1.1.20180412T205723Z.b529a95d2be6c0e6.1ae08b94f07a583c84c9ed6bc5594ab94b8cd3fe";

    static final String URL_YANDEX = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=";

    static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ready to translate. Plaese, enter your phrase.");
        while (true) {
            String phrase = scanner.nextLine();
            if (phrase.equals("exit!")) break;
            String result = translateToRussian(phrase);
            System.out.println(result);
        }

    }

    protected static String translateToRussian(String phrase) {
        String address = URL_YANDEX +
                "trnsl.1.1.20170317T113621Z.ef483aec3f67594b.fcf593b397d506b0de046ff852b3253503346588" +
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