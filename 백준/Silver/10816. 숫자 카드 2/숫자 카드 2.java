import java.io.*;
import java.util.*;

public class Main {
    static int list[];
    static int N;



    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        list=new int[N];
        for(int i=0;i<N;i++){

            list[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        int M=Integer.parseInt(br.readLine());
        int arr[]=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }


        for(int i=0;i<M;i++){

            bw.write(String.valueOf(upperBound(arr[i])-lowerBound(arr[i]))+" ");





        }














        bw.flush();
        br.close();
        bw.close();


    }

    static int lowerBound(int key){

        int left=0;
        int right=list.length;

        while(left<right){
            int mid=(left+right)/2;
            if(key<=list[mid]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        return left;



    }

    static int upperBound(int key){

        int left=0;
        int right=list.length;

        while(left<right){
            int mid=(left+right)/2;

            if(key<list[mid]){

                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;


    }










}
