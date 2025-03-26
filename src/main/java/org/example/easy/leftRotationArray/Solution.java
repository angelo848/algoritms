package org.example.easy.leftRotationArray;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

  /*
   * Complete the 'rotateLeft' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER d
   *  2. INTEGER_ARRAY arr
   */

  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Write your code here
    int numRotations = d > arr.size() ? d % arr.size() : d;
    List<Integer> rotated = arr.subList(numRotations, arr.size());
    rotated.addAll(arr.subList(0, numRotations));
    return rotated;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    List<Integer> result = rotateLeft(d, arr);

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
