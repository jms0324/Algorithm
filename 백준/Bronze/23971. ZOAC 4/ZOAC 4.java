import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());

        int H=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());  //세로로 이만큼 띄워야함
        int M=Integer.parseInt(st.nextToken());  //가로로 이만큼 띄워야함
        int cnt=0;

        for(int i=0;i<H;i+=(N+1)){

            for(int j=0 ;j<W;j+=(M+1)){

                cnt++;




            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();





    }
}