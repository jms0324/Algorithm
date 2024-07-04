import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st=new StringTokenizer(br.readLine());


       int m=Integer.parseInt(st.nextToken());
       int n=Integer.parseInt(st.nextToken());
       int result=0;

       int arr[]=new int[n];
       st=new StringTokenizer(br.readLine());
       for(int i=0;i<n;i++){
           arr[i]=Integer.parseInt(st.nextToken());
       }

       Arrays.sort(arr);


       int left=1;
       int right=arr[n-1];



       while (left<=right){
           int mid=(left+right)/2;
           int cnt=0;

           for(int i=0;i<arr.length;i++){
               if(arr[i]>=mid){
                   cnt+=arr[i]/mid;
               }
           }
           if(cnt<m){      //조카에게 나누어줄 수 없는 경우
               right=mid-1;

           }
           else {          //조카에게 더 나눠줄 수 있는 경우
               left=mid+1;
               result=mid;
           }




       }


       bw.write(String.valueOf(result));
       br.close();
       bw.flush();
       bw.close();






    }


}
