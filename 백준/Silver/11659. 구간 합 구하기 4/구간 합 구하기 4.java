import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int dp[]=new int[N+1];
        int arr[]=new int[N+1];

        dp[0]=0;
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            dp[i]=dp[i-1]+arr[i];

        }

        for(int t=0;t<M;t++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(dp[m]-dp[n-1]));
            bw.newLine();


        }


        bw.flush();
        bw.close();








    }

















}
