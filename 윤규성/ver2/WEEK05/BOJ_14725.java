import java.io.*;
import java.util.*;

public class BOJ_14725 {

  public static class Node {
    int idx, parentIdx;
    String name;

    public Node(int idx, String name, int parentIdx) {
      this.idx = idx;
      this.parentIdx = parentIdx;
      this.name = name;
    }
  }

  // 트리 출력용 DFS
  public static void dfs(Node node, int depth, ArrayList<ArrayList<Node>> list, StringBuilder sb) {
    // 깊이(depth)만큼 "--" 붙이기
    for (int i = 0; i < depth; i++) sb.append("--");
    sb.append(node.name).append('\n');

    int nextDepth = depth + 1;
    if (nextDepth >= list.size()) return;

    // 다음 depth에서 현재 노드의 자식들 찾기
    ArrayList<Node> children = new ArrayList<>();
    for (Node nd : list.get(nextDepth)) {
      if (nd.parentIdx == node.idx) {
        children.add(nd);
      }
    }

    // 이름순 정렬
    children.sort(Comparator.comparing(n -> n.name));

    // 자식들에 대해 재귀 호출
    for (Node child : children) {
      dfs(child, nextDepth, list, sb);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    ArrayList[] Inputlist = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      Inputlist[i] = new ArrayList<String>();
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int L = Integer.parseInt(st.nextToken());
      for (int j = 0; j < L; j++) {
        Inputlist[i].add(st.nextToken());
      }
    }

    ArrayList<ArrayList<Node>> list = new ArrayList<>();
    ArrayList<HashSet<String>> setList = new ArrayList<>();

    int list_idx = 0;
    ArrayList<Node> rootArr = new ArrayList<>();
    list.add(rootArr);                 // depth 0
    setList.add(new HashSet<String>()); // depth 0의 (parentIdx+name) 저장용

    // 1) 루트 바로 아래(첫 단어들) 채우기
    for (int i = 0; i < N; i++) {
      String name = Inputlist[i].get(0).toString();
      String key = 0 + " " + name;   // parentIdx=0 을 포함한 키

      if (!setList.get(0).contains(key)) {
        setList.get(0).add(key);
        list.get(0).add(new Node(++list_idx, name, 0));
      }
    }

    // 2) 나머지 깊이(depth) 채우기
    for (int i = 0; i < N; i++) {
      int parentIdx = 0;                 // 항상 루트(0)에서 시작
      int L = Inputlist[i].size();

      for (int d = 0; d < L; d++) {      // d = depth
        String name = Inputlist[i].get(d).toString();

        // 해당 depth의 리스트/셋이 없으면 생성
        if (list.size() <= d) {
          list.add(new ArrayList<Node>());
          setList.add(new HashSet<String>());
        }

        String key = parentIdx + " " + name;
        Node child = null;

        if (!setList.get(d).contains(key)) {
          // 아직 (parentIdx, name) 조합의 노드가 없으면 새로 생성
          setList.get(d).add(key);
          child = new Node(++list_idx, name, parentIdx);
          list.get(d).add(child);
        } else {
          // 이미 있는 경우 → 해당 노드를 찾아서 재사용
          for (Node nd : list.get(d)) {
            if (nd.parentIdx == parentIdx && nd.name.equals(name)) {
              child = nd;
              break;
            }
          }
        }

        parentIdx = child.idx; // 다음 depth의 부모 idx 갱신
      }
    }

    // 3) 정렬 + 출력
    StringBuilder sb = new StringBuilder();

    ArrayList<Node> roots = list.get(0);
    roots.sort(Comparator.comparing(n -> n.name));

    for (Node rootNode : roots) {
      dfs(rootNode, 0, list, sb);
    }

    System.out.print(sb.toString());
  }
}
