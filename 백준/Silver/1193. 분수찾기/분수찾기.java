import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc=new Scanner(System.in);

        int num=sc.nextInt();

        int line=1;

        while(true){
            num-=line;
            if(num<=0){
                num+=line;
                break;
            }
            line++;

        }

        if(line%2==0){
            System.out.println(num+"/"+(line-num+1));


        }else{
            System.out.println((line-num+1)+"/"+num);

        }






















































    }



}













































































