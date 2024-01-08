package org.example.easy.jumpingOnTheClouds;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/jumping-on-the-clouds
   * Complete the 'jumpingOnClouds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY c as parameter.
   */

  public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here
    int steps = 0, currentCloud = 0;
    while (currentCloud < c.size() - 1) {
      if ((currentCloud + 2 < c.size()) && (c.get(currentCloud + 2) != 1)) {
        currentCloud += 2;
      } else {
        currentCloud++;
      }
      steps++;
    }

    return steps;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.jumpingOnClouds(c);

    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
