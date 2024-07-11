import java.io.*;
import java.util.*;

public class Main {
    static int dp[];
    static int arr[];






    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        arr=new int[N];
        dp=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }

        for(int i=0;i<N;i++){
            topdown(i);
        }

        int max=dp[0];
        for(int i=1;i<N;i++){
            max=Math.max(dp[i],max);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();




    }

    static int topdown(int n){
        if(dp[n]==0){
            dp[n]=1;

            for(int i=n-1;i>=0;i--){
                if(arr[i]<arr[n]){
                    dp[n]=Math.max(dp[n],topdown(i)+1);
                }
            }



        }



        return dp[n];
    }















}
