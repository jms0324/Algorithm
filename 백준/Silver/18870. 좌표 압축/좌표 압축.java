import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    static int []arr;


    public static void main(String[] args) throws IOException {


        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        int []origin=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            origin[i]=arr[i];
        }

        Arrays.sort(arr);
        HashMap<Integer,Integer>hashMap=new HashMap<Integer,Integer>();
        int rank=0;

        for(int i=0;i<arr.length;i++){


            if(!hashMap.containsKey(arr[i])){  //중복제거하고 순위매김
                hashMap.put(arr[i],rank);
                rank++;
            }

        }

        for(int key : origin){

            bw.write(String.valueOf(hashMap.get(key))+" ");
        }

        bw.flush();
        bw.close();














    }


}