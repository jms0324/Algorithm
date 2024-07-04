import java.io.*;
import java.util.*;

public class Main {

    static int arr[];
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }

        bw.write(String.valueOf(BinarySearch(0,2000000)));


        br.close();
        bw.flush();
        bw.close();

    }

    static int BinarySearch(int left,int right){
        int result=0;
          //그룹의 수를 새주는 변수

        while(left<=right){
            int mid=(left+right)/2;
            int sum=0;
            int gnt=0;
            for(int i=0;i<N;i++){
                sum+=arr[i];
                if(sum>=mid){
                    gnt++;
                    sum=0;
                }

            }
            if(gnt>=M){
                left=mid+1;
                result=mid;
            }
            else if(gnt<M){
                right=mid-1;
            }


        }
        return result;


    }


}
