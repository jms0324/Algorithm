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
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }

        arr2=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arr2[i]=Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int count=0;
        ArrayList<Integer>answer = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(BinarySearch(arr[i])==0){
                count++;
                answer.add(arr[i]);


            }

        }
        bw.write(String.valueOf(count));
        bw.newLine();
        if(count==0){
            bw.flush();
            return;
        }
        for(int i:answer){
            bw.write(String.valueOf(i+" "));
        }

        bw.flush();
        bw.close();





    }

    static int BinarySearch(int target){
        int st=0;
        int en=arr2.length-1;

        while(st<=en){
            int mid=(st+en)/2;
            if(arr2[mid]==target)return 1;
            if(arr2[mid]<target)st=mid+1;
            if(arr2[mid]>target)en=mid-1;

        }
        return 0;
    }
}