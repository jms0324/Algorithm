import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        if (N == 1 && M == 1) {
            bw.write("1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }


        int dp[][]=new int[N+1][M+1];

        int cnt=0;

        for(int i=1;i<=N;i++){

            String []line=br.readLine().split("");
            for(int j=1;j<=M;j++){
                int val = Integer.parseInt(line[j-1]);
                if(i==1 && j==1){  // 왼쪽, 왼쪽윗대각선, 위쪽값이 없으므로
                    dp[i][j]=val;

                }
                else{
                    if(val==1){
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                        cnt=Math.max(cnt,dp[i][j]);
                    }
                }






            }
        }

        bw.write(String.valueOf(cnt*cnt));











        bw.flush();
        bw.close();




    }






}