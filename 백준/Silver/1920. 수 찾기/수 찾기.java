import java.io.*;
import java.util.*;

public class Main {
    static int list[];
    static int N;



    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        list=new int[N];
        for(int i=0;i<N;i++){
            list[i] = Integer.parseInt(st.nextToken());

        }

        int m=Integer.parseInt(br.readLine());
        Arrays.sort(list);

        int arr[]=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){

            int target=arr[i];
            bw.write(String.valueOf(BinarySearch(0,N-1,target)));
            bw.newLine();

        }










        bw.flush();
        br.close();
        bw.close();


    }

    static int BinarySearch(int left,int right,int target){


        while(left<=right){
            int mid=(left+right)/2;

            if(list[mid]==target){
                return 1;
            }

            if(list[mid]>target){
                right=mid-1;

            }
            if(list[mid]<target){
                left=mid+1;

            }



        }
        return 0;

    }






}
