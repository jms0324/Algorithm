import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int a=Integer.parseInt(br.readLine());


        for(int i=0;i<a;i++){
            String str=br.readLine();
            int arr=0;
            int x=0;
            int y=0;
            boolean flag=true;

            for(int j=0;j<str.length();j++){

                if(str.charAt(j)=='('){
                    x++;
                    arr++;

                }
                else{
                    if(arr==0){

                        flag=false;
                        break;
                    }
                    y++;
                    arr--;


                }



            }
            if(x==y && flag==true){
                bw.write("YES\n");

            }else{
                bw.write("NO\n");
            }











        }























        bw.flush();
        bw.close();
        br.close();



























































    }








}













































































