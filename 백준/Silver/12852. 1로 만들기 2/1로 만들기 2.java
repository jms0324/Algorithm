import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int dp[]=new int[N+1];
        int pre[]=new int[N+1];
        if(N==1){
            bw.write("0");
            bw.newLine();
            bw.write("1");

            bw.flush();
            bw.close();
            return;
        }
        if(N==2){
            bw.write("1");
            bw.newLine();
            bw.write("2 1");
            bw.flush();
            bw.close();
            return;
        }
        if(N==3){
            bw.write("1");
            bw.newLine();
            bw.write("3 1");
            bw.flush();
            bw.close();
            return;
        }
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(N);
        pre[1]=1;
        pre[2]=1;
        pre[3]=1;

        for(int i=4;i<=N;i++){
            dp[i]=dp[i-1]+1;
            pre[i]=i-1;


            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
                if(dp[i]==dp[i/2]+1){
                    pre[i]=i/2;

                }
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
                if(dp[i]==dp[i/3]+1){
                    pre[i]=i/3;
                }
            }

        }

        bw.write(String.valueOf(dp[N]));
        bw.newLine();
        while(true){

            bw.write(String.valueOf(N+" "));
            if(N==1){
                break;
            }
            N=pre[N];

        }















        bw.flush();
        bw.close();








    }

















}
