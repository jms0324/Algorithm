import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int mem[];






    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        int arr[]=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int dp[]=new int[N+1];
        dp[0]=0;

        int cnt=1;

        for(int i=1;i<=N;i++){

            if(i>=3){
                dp[i]=Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);


            }
            else{
                dp[i]=dp[i-1]+arr[i];
                cnt++;

            }



        }

        bw.write(String.valueOf(dp[N]));













        bw.flush();
        br.close();
        bw.close();








    }















}
