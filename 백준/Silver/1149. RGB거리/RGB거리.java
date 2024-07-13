import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[][]=new int[N+1][3];


        for(int i=1;i<=N;i++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }


        }

        int dp[][]=new int[N+1][3];

        for(int i=1;i<=N;i++){

            dp[i][0]=Math.min(dp[i-1][1]+arr[i][0],dp[i-1][2]+arr[i][0]);
            dp[i][1]=Math.min(dp[i-1][0]+arr[i][1],dp[i-1][2]+arr[i][1]);
            dp[i][2]=Math.min(dp[i-1][0]+arr[i][2],dp[i-1][1]+arr[i][2]);

        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if(min>dp[N][i]){
                min=dp[N][i];
            }
        }

        bw.write(String.valueOf(min));












        bw.flush();
        bw.close();








    }

















}
