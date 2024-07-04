import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int L;
    static int[] arr;



    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        arr=new int[M+1];

        for(int i=0;i<M;i++){
            arr[i]=Integer.parseInt(br.readLine());

        }
        arr[M]=L;

        for(int p=0;p<N;p++){

            int n=Integer.parseInt(br.readLine());
            bw.write(String.valueOf(BinarySearch(1,4000000,n)));
            bw.newLine();




        }



        br.close();
        bw.flush();
        bw.close();

    }

    static int BinarySearch(int left,int right,int n){

        while(left<=right){
            int mid=(left+right)/2;
            int cnt=0;
            int prev=0;
            for(int i=0;i<M+1;i++){
                if(arr[i]-prev>=mid){
                    cnt++;
                    prev=arr[i];
                }

            }

            if(cnt>n){
                left=mid+1;


            }
            else{
                right=mid-1;
            }

        }
        return right;





    }


}
