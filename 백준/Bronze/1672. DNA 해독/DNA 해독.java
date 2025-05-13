import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        String sequence = br.readLine();
        char answer = sequence.charAt(length - 1);

        for (int i = length - 2; i >= 0; i--) {
            char ch = sequence.charAt(i);
            answer = func(ch, answer);
        }
        bw.write(answer);
        bw.flush();
        bw.close();
    }

    public static char func(char first, char two) {
        switch (first) {
            case 'A':
                switch (two) {
                    case 'A': return 'A';
                    case 'C': return 'A';
                    case 'G': return 'C';
                    case 'T': return 'G';
                }
                break;
            case 'C':
                switch (two) {
                    case 'A': return 'A';
                    case 'C': return 'C';
                    case 'G': return 'T';
                    case 'T': return 'G';
                }
                break;
            case 'G':
                switch (two) {
                    case 'A': return 'C';
                    case 'C': return 'T';
                    case 'G': return 'G';
                    case 'T': return 'A';
                }
                break;
            case 'T':
                switch (two) {
                    case 'A': return 'G';
                    case 'C': return 'G';
                    case 'G': return 'A';
                    case 'T': return 'T';
                }
                break;
        }
        return ' ';
    }
}
