package org.example.exercise5;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void plusMinus(List<Integer> arr) {
    // Write your code here
    int pos = 0, neg = 0, zero = 0;
    for (int el : arr) {
      if (el > 0) pos++;
      else if (el < 0) neg++;
      else zero++;
    }

    System.out.printf("%.6f\n", (float) pos / arr.size());
    System.out.printf("%.6f\n", (float) neg / arr.size());
    System.out.printf("%.6f\n", (float) zero / arr.size());
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.plusMinus(arr);

    bufferedReader.close();
  }
}
