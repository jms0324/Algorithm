import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int arr[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        if(N==1){
            bw.write(String.valueOf(1));
            bw.flush();
            bw.close();


            return;
        }
        arr=new int[N+1];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=N;i++){
            arr[i]=(arr[i-1]+arr[i-2])%10007;

        }

        bw.write(String.valueOf(arr[N]));






        bw.flush();
        bw.close();




    }






}