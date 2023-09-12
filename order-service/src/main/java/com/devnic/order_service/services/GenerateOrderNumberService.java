package com.devnic.order_service.services;

import java.util.Locale;
import java.util.UUID;

/**
 * @author Nicholas Nzovia
 * @On 26/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public class GenerateOrderNumberService {
    public  String generateRandomNumber(){
        var randomNumber = UUID.randomUUID().toString();
        var generatedString = randomNumber.substring(0,5);
        return  generatedString.toUpperCase(Locale.ROOT);
    }
}
