import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int n=Integer.parseInt(br.readLine());
            if(n==1 || n==2){
                bw.write(String.valueOf(n));
                bw.newLine();
                continue;

            }
            int dp[]=new int[n+1];

            dp[1]=1;
            dp[2]=2;
            dp[3]=4;

            for(int j=4;j<=n;j++){
                dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
            }
            bw.write(String.valueOf(dp[n]));
            bw.newLine();




        }



        bw.flush();
        bw.close();








    }

















}
