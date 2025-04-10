import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer strr = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(strr.nextToken());
        int S= Integer.parseInt(strr.nextToken());
        int []arr= new int[N];

        strr=new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length;i++){

            arr[i]=Integer.parseInt(strr.nextToken());


        }
        int min=Integer.MAX_VALUE;
        int en=0;
        int sum=arr[0];
        for(int st=0;st<N;st++){



            while(en<N && sum<S){

                en++;
                if(en!=N)sum+=arr[en];
            }
            if(en==N)break; //넘어갈때까지 못찾음
            min=Math.min(min,en-st+1);

            sum-=arr[st];



        }
        if(min==Integer.MAX_VALUE)min=0;
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();











    }
}