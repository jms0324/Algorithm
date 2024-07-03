import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());
        int realx=0;
        int realy=0;

        if(x>w-x){
            realx=w-x;
        }else{
            realx=x;
        }
        if(y>h-y){
            realy=h-y;

        }else{
            realy=y;
        }

        if(realx>realy){
            bw.write(String.valueOf(realy));
        }
        else{
            bw.write(String.valueOf(realx));

        }
        bw.flush();
        bw.close();
        br.close();


















    }








}













































































