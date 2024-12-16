import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());


        Long a=Long.valueOf(st.nextToken());
        Long b=Long.valueOf(st.nextToken());
        Long c=Long.valueOf(st.nextToken());

        bw.write(String.valueOf(pow(a,b,c)));



        bw.flush();
        bw.close();



    }

    static Long pow(Long a,Long b, Long m){    //(5,14,3)이 (5,7,3)을 부르고 (5,7,3)이 (5,3,3)을 부르고

        if(b==1){
            return a%m;
        }
        Long val=pow(a,b/2,m);
        val=val*val%m;
        if(b%2==0) return val;
        return val * a %m ;
    }
}

