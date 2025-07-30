    import java.util.*;
    import java.io.*;

    public class Main {

        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String word = br.readLine();

            LinkedList<Character> alpha_list = new LinkedList<>();
            for (int i = 0; i < word.length(); i++) {
                alpha_list.add(word.charAt(i));
            }

            int N = Integer.parseInt(br.readLine());

            ListIterator<Character> iterator_list = alpha_list.listIterator();

            while (iterator_list.hasNext()){
                iterator_list.next();
            }

            char ord, alpha;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                ord = st.nextToken().charAt(0);

                if(ord == 'L'){
                    if(iterator_list.hasPrevious()) iterator_list.previous();
                }
                else if (ord == 'D'){
                    if(iterator_list.hasNext()) iterator_list.next();
                }
                else if (ord == 'B'){
                    if (iterator_list.hasPrevious()){
                        iterator_list.previous();
                        iterator_list.remove();;
                    }
                }
                else{
                    alpha = st.nextToken().charAt(0);
                    iterator_list.add(alpha);
                }

            }

            StringBuilder sb = new StringBuilder();
            for (char result : alpha_list) {
                sb.append(result);
            }
            System.out.println(sb);

        }
    }
