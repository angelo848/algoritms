package org.example.easy.maximumNumberOfBaloons;

// Leetcode link: https://leetcode.com/problems/maximum-number-of-balloons/description/

public class Solution {
  public static int maxNumberOfBalloons(String text) {
    int bFound = 0;
    int aFound = 0;
    int lFound = 0;
    int oFound = 0;
    int nFound = 0;
    int baloonWordsFound = 0;
    for (int i = 0; i < text.length(); i++) {
      char currentChar = text.charAt(i);
      if (currentChar == 'b') {
        bFound++;
      } else if (currentChar == 'a') {
        aFound++;
      } else if (currentChar == 'l') {
        lFound++;
      } else if (currentChar == 'o') {
        oFound++;
      } else if (currentChar == 'n') {
        nFound++;
      }
      if (bFound >= 1 && aFound >= 1 && lFound >= 2 && oFound >= 2 && nFound >= 1) {
        baloonWordsFound++;
        bFound--;
        aFound--;
        lFound -= 2;
        oFound -= 2;
        nFound--;
      }
    }

    return baloonWordsFound;
  }

  public static void main(String[] args) {
    System.out.println(maxNumberOfBalloons("balloonobnablallonoononbal"));
  }
}
