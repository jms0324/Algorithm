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
       ArrayList<Integer>result=new ArrayList<>();

        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            s=br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(s.split("")[j]);
            }
        }

        if(n==1 || m==1){
            System.out.println(1);
            return;
        }

        if(n>=m){
            for(int i=2;i<=m;i++){

                for(int j=0;j<n-i+1;j++){


                    for(int k=0;k<m-i+1;k++){

                        if(arr[j][k]==arr[j][k+i-1]&&arr[j][k+i-1]==arr[j+i-1][k]&&arr[j+i-1][k]==arr[j+i-1][k+i-1]){

                            result.add(i*i);
                            
                        }
                    }
                }

            }

        }
        else{
            for(int i=2;i<=n;i++){

                for(int j=0;j<n-i+1;j++){


                    for(int k=0;k<m-i+1;k++){

                        if(arr[j][k]==arr[j][k+i-1]&&arr[j][k+i-1]==arr[j+i-1][k]&&arr[j+i-1][k]==arr[j+i-1][k+i-1]){
                            result.add(i*i);

                        }
                    }
                }

            }

        }

        int max=0;
        if(result.isEmpty()){
            bw.write(String.valueOf(1));
        }

        else{
            for(int i:result){

                if(max<i){
                    max= i;
                }

            }
            bw.write(String.valueOf(max));

        }



        bw.flush();
        bw.close();






    }


}
