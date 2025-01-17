import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

     while(true){

         int max=0;

         StringTokenizer st=new StringTokenizer(br.readLine());

         int a=Integer.parseInt(st.nextToken());
         max=Math.max(max,a);
         int b=Integer.parseInt(st.nextToken());
         max=Math.max(max,b);
         int c=Integer.parseInt(st.nextToken());
         max=Math.max(max,c);

         ArrayList<Integer>list=new ArrayList<>();
         list.add(a);
         list.add(b);
         list.add(c);
         Collections.sort(list,Collections.reverseOrder()); // 내림차순 정렬

         if(a==0 && b==0 && c==0){

             bw.flush();
             bw.close();
             break;
         }
         if(list.get(0) >= list.get(1)+list.get(2)){

             bw.write("Invalid");
             bw.newLine();
             continue;
         }

         if(a==b && a==c){
             bw.write("Equilateral");
             bw.newLine();
             continue;
         }
         if(a==b || a==c || b==c){
             bw.write("Isosceles");
             bw.newLine();
             continue;
         }
         else{
             bw.write("Scalene");
             bw.newLine();
         }




     }










    }
}