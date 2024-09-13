import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        Queue<Integer>queue=new LinkedList<>();
        int visited[]=new int[100002];
        for(int i=0;i<100002;i++){
            visited[i]=-1;
        }

        queue.add(a);
        visited[a]=0;

        while(visited[b]==-1){

            int cur=queue.poll();
            int [] nxtposition={cur-1,cur+1,cur*2};
           for(int nxt : nxtposition){
               if(nxt<0 || nxt>100000) continue;
               if(visited[nxt]!=-1)continue;
               visited[nxt]=visited[cur]+1;
               queue.add(nxt);

           }
        }

        bw.write(String.valueOf(visited[b]));

        bw.flush();
        bw.close();


    }
}
