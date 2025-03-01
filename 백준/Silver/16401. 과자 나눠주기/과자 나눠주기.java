import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int []arr;
    static int []arr2;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {



        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st = new StringTokenizer(br.readLine());
        int max=-1;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,arr[i]);
        }

        bw.write(String.valueOf(BinarySearch(max)));


        bw.flush();
        bw.close();





    }

    static int BinarySearch(int en){

        int st=1;
        int result=0;
        while(st<=en){

            int mid=(st+en)/2;
            int cnt=0;
            for(int i=0;i<N;i++){
                cnt+=arr[i]/mid;

            }
            if(cnt>=M){
                st=mid+1;
                result=mid;
            }
            else if(cnt<M){//너무 큰 수로 나눈거
                en=mid-1;

            }


        }
        return result;

    }


}