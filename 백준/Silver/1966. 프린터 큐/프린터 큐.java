
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    static class number {

        int value;
        int importance;

        number(int value,int importance){
            this.value=value;
            this.importance=importance;
        }


    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken()); //위치
            Queue<number>queue=new LinkedList<>();
            st=new StringTokenizer(br.readLine(), " ");
            ArrayList<number>check=new ArrayList<>();


            for(int l=0;l<N;l++){
                number num=new number(l,Integer.parseInt(st.nextToken()));

                check.add(num);

                queue.add(check.get(l));

            }

            Collections.sort(check,(o1,o2)->Integer.compare(o2.importance,o1.importance));






            int count=0;

            for(number number:check){
                int k=number.importance;

                while(!queue.isEmpty()){

                    if(queue.peek().importance<k){
                        number re=queue.poll();
                        queue.add(re);


                    }

                    else{




                        count++;
                        if(queue.peek().value==M){
                            System.out.println(count);



                        }
                        queue.remove();

                        break;

                    }

                }

            }







        }











        bw.flush();
        bw.close();
        br.close();


    }
}
