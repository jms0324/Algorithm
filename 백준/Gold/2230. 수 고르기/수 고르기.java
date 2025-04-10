import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer strr = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(strr.nextToken());
        int M= Integer.parseInt(strr.nextToken());
        int []arr= new int[N];



        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int en=0;
        int ans=0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr); //정렬
        for(int st=0; st<N; st++){

            while(en<N  && arr[en] - arr[st] <M ) en++;
            if(en==N)break;
            min= Math.min(min,arr[en]-arr[st]);



        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();






    }
}