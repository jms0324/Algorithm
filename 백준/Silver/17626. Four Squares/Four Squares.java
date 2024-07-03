import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


       int n=Integer.parseInt(br.readLine());

       int cnt=0;
       for(int i=0;i<n;i++){
           if(i*i>n){
               break;
           }
           for(int j=0;j<n;j++){
               if(j*j>n){
                   break;
               }
               for(int k=0;k<n;k++){

                   if(k*k>n){
                       break;
                   }
                   for(int q=1;q<=n;q++){





                       if((i*i+j*j+k*k+q*q)==n){
                           if(i>0){
                               cnt++;
                           }
                           if (j > 0) {

                               cnt++;
                           }
                           if (k > 0) {

                               cnt++;
                           }
                           if (q > 0) {

                               cnt++;
                           }
                           bw.write(String.valueOf(cnt));
                           bw.flush();
                           bw.close();


                           return;

                       }
                       if(q*q>n){
                           break;
                       }

                   }
               }
           }


       }








    }


}
