import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T ; i++){
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j =1;j<arr.length;j++){
                    arr[j] = Integer.parseInt(st.nextToken());
            }
            boolean visited[] = new boolean[N+1];

            for(int a=1;a<=N;a++){

                if(!visited[a]){
                    visited[a] = true;
                    int next = arr[a];

                    while(true){
                        if(visited[next]){
                            count++;
                            break;
                        }
                        visited[next] = true;
                        next = arr[next];
                    }
                }
            }

            System.out.println(count);
        }

    }
}