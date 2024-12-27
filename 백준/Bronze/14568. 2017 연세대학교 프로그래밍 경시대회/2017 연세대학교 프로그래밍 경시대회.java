import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        int cnt=0;

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                for(int k=1;k<N+1;k++){
                    if(i+j+k==N){
                        if(i>=j+2){
                            if(k%2==0){
                                cnt++;

                            }
                        }
                    }

                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();


    }
}