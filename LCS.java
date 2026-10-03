
// import java.util.Scanner;

import java.util.Scanner;

public class LCS {
    public static int[][] LCS_Length(String x, String y) {
        int m = x.length();
        int n = y.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }

        return dp;
    }

    public static String LCS_Build(String x, String y, int dp[][]) {
        int i = x.length();
        int j = y.length();
        StringBuilder result = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String St = s.nextLine();
        System.out.print("Enter the Pattern : ");
        String Pat = s.nextLine();
        int dp[][] = LCS_Length(St, Pat);
        int length = dp[St.length()][Pat.length()];
        String lcs = LCS_Build(St, Pat, dp);
        System.out.println("Length of LCS : " + length);
        System.out.println("LCS Obtained : " + lcs);
        s.close();
    }
}
