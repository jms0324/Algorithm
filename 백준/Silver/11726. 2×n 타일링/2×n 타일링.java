import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        if(N==1){
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }


        int dp[]=new int[N+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;


        }

        bw.write(String.valueOf(dp[N]));












        bw.flush();
        br.close();
        bw.close();








    }















}
