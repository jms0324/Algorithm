import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        int arr[][]=new int[N+1][10];
        for(int i=0;i<10;i++){
            arr[1][i]=1;
        }

        for(int i=2;i<=N;i++){

            for(int j=0;j<=9;j++){

                for(int k=j; k<=9;k++){
                    arr[i][j]+=arr[i-1][k];
                    arr[i][j]%=10007;
                }



            }

        }
        int sum=0;
        for(int i=0;i<=9;i++){
            sum+=arr[N][i];
        }
        bw.write(String.valueOf(sum%10007));



        bw.flush();
        bw.close();




    }






}