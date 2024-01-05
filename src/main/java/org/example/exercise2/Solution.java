package org.example.exercise2;

import static java.util.stream.Collectors.joining;
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
   * Complete the 'compareTriplets' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */
  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    Integer aPoints = 0;
    Integer bPoints = 0;
    for (int i = 0; i < 3; i++) {
      if (a.get(i) > b.get(i)) {
        aPoints++;
      } else if (a.get(i) < b.get(i)) {
        bPoints++;
      }
    }

    return List.of(aPoints, bPoints);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.compareTriplets(a, b);

    System.out.println(result);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
