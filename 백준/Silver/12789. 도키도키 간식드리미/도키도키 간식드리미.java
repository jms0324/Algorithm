import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        ArrayList<Integer>listsorted=new ArrayList<>();
        Queue<Integer>queue=new LinkedList<>();
        Stack<Integer>stack=new Stack<>();

        for(int i=0;i<N;i++){
            listsorted.add(Integer.parseInt(st.nextToken()));
            queue.add(listsorted.get(i));

        }
        Collections.sort(listsorted);
        int min=0;
        boolean fflag=true;


        for(int i: listsorted){
            if(stack.contains(i)){
                if(stack.peek()==i){
                    stack.pop();
                }

                continue;
            }
            min=i;
            while(!queue.isEmpty()){


                if(min< queue.peek()){
                    int a= queue.poll();

                    stack.push(a);
                }

                else if(min==queue.peek()){
                    queue.remove();
                    break;
                }
            }


        }
        if(stack.isEmpty()){
            bw.write("Nice");
        }
        else{
            bw.write("Sad");
        }



       /* if(stack.isEmpty() || stack.size()==1){
            bw.write("Nice");
            bw.flush();
            bw.close();
            return;

        }

        boolean flag=false;
        for(int i=0;i< stack.size()-1;i++){
            for(int j=i+1;j<stack.size();j++){
                if(stack.get(i)<stack.get(j)){
                    flag=true;



                }

            }
        }
        if(flag){
            bw.write("Sad");
        }
        else{
            bw.write("Nice");
        }*/
























        bw.flush();
        bw.close();
    }
}
