package org.example.easy.numberLineJumps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/kangaroo/problem
   * Complete the 'kangaroo' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER x1
   *  2. INTEGER v1
   *  3. INTEGER x2
   *  4. INTEGER v2
   *
   * In my tests I came to the conclusion that the remainder of the absolute difference between the positions x1 and x2 divided by the difference
   * in the ratio of the smallest in relation to the largest has to be 0, because only in this way will it be possible for the 2 objects to meet at some point
   *
   * Example:
   * x1 = 28
   * v1 = 8
   * x2 = 96
   * v2 = 2
   * Difference between x2 (bigger) and x1 (smaller) = 68
   * Difference between v1 (rate of smaller object that is x1 at the route) = 6
   * The division between 68 and 6 it's 11,333333..., as this result is not integer, so the objects will never meet at the same position on the route.
   * The positions of the route calculated step by step:
   * 28 96
   * 36 98  | 1st JUMP
   * 44 100 | 2nd JUMP
   * 52 102 | 3rd JUMP
   * 60 104 | 4th JUMP
   * 68 106 | 5th JUMP
   * 76 108 | 6th JUMP
   * 84 110 | 7th JUMP
   * 92 112 | 8th JUMP
   * 100 114 | 9th JUMP
   * 108 116 | 10th JUMP
   * 116 118 | 11th JUMP
   * As we see, it took 11 jumps and 33% of 6, i.e. 2 (the difference between v1 and v2) to take the same place.
   * In the end, it was not possible for the 2 objects to arrive at the same position on the route
   */

  public static String kangaroo(int x1, int v1, int x2, int v2) {
    // Write your code here
    if ((x1 > x2) && (v2 - v1 > 0)) {
      if ((x1 - x2) % (v2 - v1) == 0) {
        return "YES";
      }
    } else if ((x1 < x2) && (v1 - v2 > 0)) {
      if ((x2 - x1) % (v1 - v2) == 0) {
        return "YES";
      }
    }

    return "NO";
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int x1 = Integer.parseInt(firstMultipleInput[0]);

    int v1 = Integer.parseInt(firstMultipleInput[1]);

    int x2 = Integer.parseInt(firstMultipleInput[2]);

    int v2 = Integer.parseInt(firstMultipleInput[3]);

    String result = Result.kangaroo(x1, v1, x2, v2);

    System.out.println(result);
    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
