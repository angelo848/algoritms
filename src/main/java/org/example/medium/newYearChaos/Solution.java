package org.example.medium.newYearChaos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/new-year-chaos/problem
   * Complete the 'minimumBribes' function below.
   *
   * The function accepts INTEGER_ARRAY q as parameter.
   */

  public static void minimumBribes(int[] arr) {
    int swapCount = 0;

    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] != i + 1) {
        if (((i - 1) >= 0) && arr[i - 1] == (i + 1)) {
          swapCount++;
          swap(arr, i, i - 1);
        } else if (((i - 2) >= 0) && arr[i - 2] == (i + 1)) {
          swapCount += 2;
          swap(arr, i - 2, i - 1);
          swap(arr, i - 1, i);
        } else {
          System.out.println("Too chaotic");
          return;
        }
      }

    }
    System.out.println(swapCount);

  }

  private static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[] q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Result.minimumBribes(q);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
