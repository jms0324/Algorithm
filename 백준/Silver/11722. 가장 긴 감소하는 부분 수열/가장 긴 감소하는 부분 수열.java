import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int N=Integer.parseInt(br.readLine());


        int arr[]=new int[N+1];
        int dp[]=new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for (int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        if(N==1){
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }


        dp[1]=1;

        for(int i=2;i<=N;i++){
            dp[i]=1;
            for(int j=1;j<i;j++){

                if(arr[j]>arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }


        int max=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }

        bw.write(String.valueOf(max));















        bw.flush();
        bw.close();








    }

















}
