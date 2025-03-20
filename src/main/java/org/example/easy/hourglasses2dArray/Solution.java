package org.example.easy.hourglasses2dArray;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/2d-array
   * Complete the 'hourglassSum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    int highestSum = -64;
    for (int i = 1; i < (arr.size() - 1); i++) {
      for (int j = 1; j < (arr.get(i).size() - 1); j++) {
        int sum = arr.get(i - 1).get(j - 1) +
                  arr.get(i - 1).get(j) +
                  arr.get(i - 1).get(j + 1) +
                  arr.get(i).get(j) +
                  arr.get(i + 1).get(j - 1) +
                  arr.get(i + 1).get(j) +
                  arr.get(i + 1).get(j + 1);
        if (sum > highestSum) {
          highestSum = sum;
        }
      }
    }

    return highestSum;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, 6).forEach(i -> {
      try {
        arr.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = Result.hourglassSum(arr);

    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
