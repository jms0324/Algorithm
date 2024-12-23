import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int dura[];
    static int attack[];
    static int N;
    static int cnt=0;
    static int max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        dura=new int[N];
        attack=new int[N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            dura[i]=Integer.parseInt(st.nextToken());
            attack[i]=Integer.parseInt(st.nextToken());

        }
        egg(0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();




    }
    static void egg(int start) {


        if (start == N) {
            max = Math.max(max, cnt);
            
            return;
        }

        if (cnt == N - 1 || dura[start] <= 0) {
            egg(start + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == start || dura[i] <= 0) continue;

            dura[start] -= attack[i];
            dura[i] -= attack[start];
            if (dura[start] <= 0) cnt++;
            if (dura[i] <= 0) cnt++;

            egg(start + 1);

            if (dura[start] <= 0) cnt--;
            if (dura[i] <= 0) cnt--;
            dura[start] += attack[i];
            dura[i] += attack[start];
        }
    }

}