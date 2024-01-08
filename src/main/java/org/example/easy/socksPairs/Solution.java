package org.example.easy.socksPairs;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/sock-merchant
   * Complete the 'sockMerchant' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY ar
   */

  public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
    Map<Integer, Integer> typesByPairs = new HashMap<>();
    int pairs = 0;
    for (int sock : ar) {
      typesByPairs.put(sock, typesByPairs.getOrDefault(sock, 0) + 1);
      if (typesByPairs.get(sock) == 2) {
        typesByPairs.put(sock, 0);
        pairs++;
      }
    }

    return pairs;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.sockMerchant(n, ar);

    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
