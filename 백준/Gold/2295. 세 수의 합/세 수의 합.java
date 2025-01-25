import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int []arr;

    static int []two;
    static int M;
    public static void main(String[] args) throws IOException {

      N=Integer.parseInt(br.readLine());
      arr=new int[N];
      two=new int[(N*(N+1))/2];
      for(int i=0;i<N;i++){
          arr[i]=Integer.parseInt(br.readLine());
      }

      int cnt=0;

      for(int i=0;i<N;i++){

          for(int j=i;j<N;j++){
               //두개 더한 값
              two[cnt++]=arr[i]+arr[j];
          }
      }
      Arrays.sort(two);

      int max=-1;
      for(int i=0; i<N;i++){
          for(int j=0;j<i;j++){

              if(binarySearch(arr[i]-arr[j])){
                  max=Math.max(max,arr[i]);
              }
          }
      }

      bw.write(String.valueOf(max));
      bw.flush();
      bw.close();










    }
    static boolean binarySearch(int target){

        int low=0;
        int hi=two.length - 1;

        while(low<=hi){

            int mid=(low+hi)/2;
            if(two[mid]==target)return true;
            if(two[mid]>target)hi=mid-1;
            if(two[mid]<target)low=mid+1;
        }

        return false;



    }

}