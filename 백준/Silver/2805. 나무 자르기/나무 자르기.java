import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int arr[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(BinarySearch()));
        bw.flush();
        bw.close();






    }

    static int BinarySearch(){
        int st=0;
        int en=Integer.MAX_VALUE;
        while(st<=en){
            int mid=(st+en)/2;
            Long cnt=0L;

            for(int i=0;i<arr.length;i++){
                if(arr[i]-mid>0){
                    cnt+=arr[i]-mid;

                }

            }

            if(cnt<M){
                en=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return en;

    }

}