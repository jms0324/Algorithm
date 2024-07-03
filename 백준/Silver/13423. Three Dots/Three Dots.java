import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int cnt;


    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

       String s=br.readLine();

       int total=Integer.parseInt(s);

       for(int tot=0;tot<total;tot++){

           int num=Integer.parseInt(br.readLine());
           String s1=br.readLine();
           int arr[]=new int[num];

           for(int arrnum=0;arrnum<num;arrnum++){
               arr[arrnum]=Integer.parseInt(s1.split(" ")[arrnum]);

           }
           Arrays.sort(arr);
           cnt=0;
           HashMap<Integer,Boolean> map=new HashMap<>();
           for(int value:arr){
               map.put(value,true);
           }



           for(int i=0;i<num-2;i++){
               for(int j=i+1;j<num-1;j++){
                   int k=arr[j]+(arr[j]-arr[i]);

                   if(map.containsKey(k)){
                       cnt++;
                   }

               }
           }



           bw.write(String.valueOf(cnt));
           bw.newLine();

       }
        bw.flush();
        bw.close();


    }




}
