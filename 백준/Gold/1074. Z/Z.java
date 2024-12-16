import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int N=0;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String [] args )throws IOException{

        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(matrix(a,b,c)));








        bw.flush();
        bw.close();









    }

    static int matrix(int n , int r , int c){

        if (n == 0) {  //base condition
            return 0;
        }
        int half= 1<<(n-1);   //2의 (n-1)승 반띵이니까   만약 2번사각형이면 half*half한걸한번더해주면 되겠지
        if(r<half && c<half) return matrix(n-1 , r,c);
        if(r<half && c>=half) return half*half+matrix(n-1,r,c-half);
        if(r>=half && c<half) return 2*half*half+matrix(n-1,r-half,c);
        return 3*half*half+matrix(n-1,r-half,c-half);





    }



}

