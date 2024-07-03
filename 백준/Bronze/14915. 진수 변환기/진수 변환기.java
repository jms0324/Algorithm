
import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[]=br.readLine().split(" ");
        int a=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[1]);
        String result="";
        result=Integer.toString(a,b);
        String result1="";
        if(b>=10){
            for(int i=0;i<result.length();i++){
                if((int)result.charAt(i)>=97){
                    char x=Character.toUpperCase(result.charAt(i));
                    result1+=x;


                }else{
                    result1+=result.charAt(i);
                }
            }
            bw.write(result1);

        }
        else{
            bw.write(result);

        }





















        bw.flush();
        bw.close();
        br.close();

    }

}



