import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        for(int k=0;k<N;k++){

            int n=Integer.parseInt(br.readLine());
            int dp[]=new int[n+1];
            if(n==1 || n==2){
                bw.write(String.valueOf(n));
                bw.newLine();

            }
            else{
                dp[1]=1;
                dp[2]=2;
                dp[3]=4;
                for(int i=4;i<=n;i++){
                    dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
                }
                bw.write(String.valueOf(dp[n]));
                bw.newLine();

            }




        }








        bw.flush();
        br.close();
        bw.close();








    }















}
