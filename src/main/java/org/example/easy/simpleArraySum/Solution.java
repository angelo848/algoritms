package org.example.easy.simpleArraySum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/simple-array-sum/problem
   * Complete the 'simpleArraySum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY ar as parameter.
   */

  public static int simpleArraySum(List<Integer> ar) {
    // Write your code here
    Integer sum = 0;
    for (Integer el : ar) {
      sum += el;
    }

    return sum;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    int arCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    int result = Result.simpleArraySum(ar);

    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}