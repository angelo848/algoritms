package org.example.easy.countingValleys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

  /*
   * Hackerrank link: https://www.hackerrank.com/challenges/counting-valleys
   * Complete the 'countingValleys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER steps
   *  2. STRING path
   */

  public static int countingValleys(int steps, String path) {
    // Write your code here
    int seaLevel = 0, valleysEntered = 0;
    boolean enteredValley = false;
    for (int i = 0; i < steps; i++) {
      seaLevel += parsePath(path.charAt(i));
      if (seaLevel >= 0) {
        enteredValley = false;
      } else if (!enteredValley && seaLevel < 0) {
        enteredValley = true;
        valleysEntered++;
      }
    }

    return valleysEntered;
  }

  public static int parsePath(char step) {
    if (step == 'U') {
      return 1;
    } else {
      return -1;
    }
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int steps = Integer.parseInt(bufferedReader.readLine().trim());

    String path = bufferedReader.readLine();

    int result = Result.countingValleys(steps, path);

    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
