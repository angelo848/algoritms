package org.example.easy.timeConversion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String turn = s.substring(s.length()-2);
        String timePart = s.substring(0, s.length() - 2);
        StringBuilder stringBuffer = new StringBuilder(timePart);

        if (turn.equals("PM")) {
            int timeAddedHours = Integer.parseInt(timePart.substring(0, 2));
            if (timeAddedHours != 12) {
                timeAddedHours += 12;
            }
            timePart = stringBuffer
                    .replace(0, 2, String.valueOf(timeAddedHours))
                    .insert(0, timeAddedHours < 10 ? "0" : "")
                    .toString();
        } else if (timePart.startsWith("12")) {
            timePart = stringBuffer.replace(0, 2, "00").toString();
        }

        return timePart;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

