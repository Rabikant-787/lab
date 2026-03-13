import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {

                if (arr.get(i) + arr.get(j) == m) {
                    result.add(i + 1); 
                    result.add(j + 1);
                    return result;
                }

            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {

            int m = Integer.parseInt(bufferedReader.readLine().trim());
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().split(" ");
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(arrTemp[i]));
            }

            List<Integer> result = Result.icecreamParlor(m, arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
