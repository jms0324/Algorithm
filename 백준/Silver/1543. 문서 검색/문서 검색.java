import java.io.*;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        String str=br.readLine();
        String target=br.readLine();

        str=str.replace(target,"1");
        int cnt=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();




    }
}