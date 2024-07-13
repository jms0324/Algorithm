import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));



        char A[]=br.readLine().toCharArray();


        char B[]=br.readLine().toCharArray();





        int dp[][]=new int[B.length+1][A.length+1];

       for(int i=1;i<=B.length;i++){

            for(int j=1;j<=A.length;j++){

                if(B[i-1]==A[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }

                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        bw.write(String.valueOf(dp[B.length][A.length]));

        bw.flush();
        bw.close();




    }

















}
