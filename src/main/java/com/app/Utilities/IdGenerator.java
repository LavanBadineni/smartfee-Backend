package com.app.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {

    public static String generateCustomId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String timestamp = dateFormat.format(new Date());

        Random random = new Random();
        int randomInt = random.nextInt(1000);

        return timestamp + "L" + randomInt;
    }
}
