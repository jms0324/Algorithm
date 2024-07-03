import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

       String s=br.readLine();
       int m=Integer.parseInt(s.split(" ")[0]);
       int seed=Integer.parseInt(s.split(" ")[1]);
       int x1=Integer.parseInt(s.split(" ")[2]);
       int x2=Integer.parseInt(s.split(" ")[3]);



       for(int i=0;i<m;i++){
           for(int j=0;j<m;j++){
               if(x1==((i*seed+j)%m)){
                   if(x2==(i*x1+j)%m){
                       bw.write(String.valueOf(i+" "+j));
                       bw.flush();
                       bw.close();
                       return;

                   }
               }

           }
       }










    }


}
