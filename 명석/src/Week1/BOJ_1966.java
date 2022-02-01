/*
1966 프린터 큐

 */
package Week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Printer implements Comparable<Printer> {
    int seq;
    int priority;

    public Printer(int seq, int priority) {
        this.seq = seq;
        this.priority = priority;
    }

    @Override
    public int compareTo(Printer printer) {
        if (this.priority > printer.priority)
            return -1;
        else if (this.priority < printer.priority)
            return 1;
        else return 0;
    }
}

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            // 큐의 크기
            int size = Integer.parseInt(st.nextToken());
            // 원하는 순서
            int wantSeq = Integer.parseInt(st.nextToken());
            PriorityQueue<Printer> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                pq.add(new Printer(i, Integer.parseInt(st.nextToken())));
            }
            for (int i = 1; i < size + 1; i++) {
                if (pq.poll().seq == wantSeq) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
        }

        br.close();
        bw.close();
    }
}
