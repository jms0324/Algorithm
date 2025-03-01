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
        N=Integer.parseInt(st.nextToken()); //나무의 수
        M=Integer.parseInt(st.nextToken()); //나무의 길이
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
        while(st<=en){
            Long cnt=0L;
            int mid=(st+en)/2;

            for(int i=0;i<N;i++){
                if(arr[i]-mid >0){
                    cnt+=arr[i]-mid;  //자르고 난 길이

                }

            }

            if(cnt<M){ //mid값이 크다 --> 덜 잘렸다
                en=mid-1;
            }
            if(cnt>=M){  //mid값이 같다 --> 더 큰걸로 잘라본다 잘린길이가 너무많다 --> mid값이작다 M보다 커도 된다
                st=mid+1;
            }
        }
        return en;

    }




}