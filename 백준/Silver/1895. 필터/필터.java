import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

       String s=br.readLine();

       int n=Integer.parseInt(s.split(" ")[0]);
       int m=Integer.parseInt(s.split(" ")[1]);
       int arr[][]=new int[n][m];

       for(int i=0;i<n;i++){
           s=br.readLine();

           for(int j=0;j<m;j++){
               arr[i][j]=Integer.parseInt(s.split(" ")[j]);

           }
       }
       int t=Integer.parseInt(br.readLine());
       ArrayList<Integer> result=new ArrayList<>();
       ArrayList<Integer> result2=new ArrayList<>();

       n= n-3+1;
       m=m-3+1;

       for(int k=0;k<n;k++){
           for(int q=0;q<m;q++){
               for(int i=0;i<3;i++){

                   for( int j=0;j<3;j++){
                       result.add(arr[i+k][j+q]);


                   }
               }

               Collections.sort(result);
               result2.add(result.get(4));
               result=new ArrayList<>();
           }
       }
       int cnt=0;

       for(int value:result2){
           if(value>=t){
               cnt++;
           }
       }
       bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();


    }


}
