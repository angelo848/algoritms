package org.example.easy.minMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        List<Long> arrLong = arr.stream().map(Integer::longValue).collect(toList());
        long minSum = arrLong.stream().reduce(Long::sum).orElse(0L);
        long maxSum = 0;
        for (int i = 0; i < arrLong.size(); i++) {
            long acc = 0;
            for (int j = 0; j < arrLong.size(); j++) {
                if (j != i) {
                    acc += arrLong.get(j);
                }
            }
            if (acc < minSum) {
                minSum = acc;
            }
            if (acc > maxSum) {
                maxSum = acc;
            }
        }

        System.out.printf("%d %d", minSum, maxSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}