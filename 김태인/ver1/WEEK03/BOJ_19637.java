    import java.util.*;
    import java.io.*;

    public class Main {

        static class Node implements Comparable<Node>{
            int weight;
            String word;

            public Node(int weight, String word) {
                this.weight = weight;
                this.word = word;
            }

            @Override
            public int compareTo(Node o) {
                return this.weight - o.weight;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "weight=" + weight +
                        ", word='" + word + '\'' +
                        '}';
            }
        }

        static ArrayList<Node> arr;
        static int N, M;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();
            String word;
            int num;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                word = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                arr.add(new Node(num, word));
            }

            Collections.sort(arr);

            int size = arr.size();
            int left, right, mid;
            int idx = size - 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                num = Integer.parseInt(br.readLine());
                left = 0;
                right = size - 1;
                mid = (left + right) / 2;

                while (left <= right){
                    mid = (left + right) / 2;

                    if(num > arr.get(mid).weight){
                        left = mid+1;
                    }
                    else{
                        right = mid - 1;
                        idx = mid;
                    }
                }
                sb.append(arr.get(idx).word + "\n");
            }


            System.out.println(sb);
        }
    }
