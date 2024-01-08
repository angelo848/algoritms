package org.example.easy.repeatedString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/repeated-string
   * Complete the 'repeatedString' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. LONG_INTEGER n
   */

  public static long repeatedString(String s, long n) {
    // Write your code here
    long rest = n % s.length();
    long occurrences = s.chars().filter(c -> c == 'a').count();
    long occurrencesInFirstChars = s.substring(0, (int) rest).chars().filter(c -> c == 'a').count();

    return occurrences * (n / s.length()) + occurrencesInFirstChars;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    long n = Long.parseLong(bufferedReader.readLine().trim());

    long result = Result.repeatedString(s, n);

    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}

