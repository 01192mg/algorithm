package etc.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1_10825 {
    private static final StringBuilder sb = new StringBuilder();
    private static int n;
    private static Student[] students;

    public static void main(String[] args) {
        input();
        Arrays.sort(students);
        for (int i = 0; i < n; i++) {
            sb.append(students[i].getName()).append('\n');
        }
        System.out.println(sb);
    }

    private static void input() {
        MyScanner sc = new MyScanner();
        n = sc.nextInt();
        students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
    }

    private static class Student implements Comparable<Student> {
        private final String name;
        private final int korean;
        private final int english;
        private final int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean != o.korean) {
                return o.korean - this.korean;
            }
            if (this.english != o.english) {
                return this.english - o.english;
            }
            if (this.math != o.math) {
                return o.math - this.math;
            }
            return this.name.compareTo(o.name);
        }
    }

    private static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            if (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}