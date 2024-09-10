import java.io.*;
import java.util.*;

public class Main {

    static boolean[] checklist;
    static int[] result;

    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            if (str.charAt(1) == 'u') {
                String strr[] = str.split(" ");
                int a = Integer.parseInt(strr[1]);

                queue.add(a);
                last = a;
            }
            if (str.charAt(1) == 'o') {

                if (queue.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                } else {
                    int a = queue.poll();
                    bw.write(Integer.toString(a));
                    bw.newLine();
                }

            }
            if (str.charAt(1) == 'i') {
                bw.write(Integer.toString(queue.size()));
                bw.newLine();
            }

            if (str.charAt(1) == 'm') {
                if (queue.isEmpty()) {
                    bw.write("1");
                    bw.newLine();
                } else {
                    bw.write("0");
                    bw.newLine();
                }
            }

            if (str.charAt(1) == 'r') {
                if (queue.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                } else {
                    int a = queue.peek();
                    bw.write(Integer.toString(a));
                    bw.newLine();
                }
            }

            if (str.charAt(1) == 'a') {
                if (queue.isEmpty()) {
                    bw.write("-1");
                    bw.newLine();
                } else {
                    int a = last;
                    bw.write(Integer.toString(a));
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
