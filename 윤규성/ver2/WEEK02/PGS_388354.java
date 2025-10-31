import java.util.*;
import java.io.*;

class PGS388354 {
    static class Node {
        int weight;
        List<Integer> childs = new ArrayList<>();
        
        public Node(int weight) {
            this.weight = weight;
        }
    }
    
    static Node[] nodeList;
    static Map<Integer, Integer> map, count;
    public int[] solution(int[] nodes, int[][] edges) {
        int[] result = new int[2];
        
        nodeList = new Node[nodes.length];
        map = new HashMap<>();
        count = new HashMap<>(); // 자식 노드의 개수가 짝수인지 홀수인지를 파악하기 위해
        
        for(int i = 0; i < nodes.length; i++) {
            nodeList[i] = new Node(nodes[i]);
            map.put(nodes[i], i); // {노드 번호, Node[] 배열의 인덱스}
            count.put(nodes[i], 0);
        }
        
        int a, b;
        for(int i = 0; i < edges.length; i++) {
            a = edges[i][0];
            b = edges[i][1];
            
            nodeList[map.get(a)].childs.add(b);
            nodeList[map.get(b)].childs.add(a);
            
            count.put(a, count.getOrDefault(a, 0) + 1);
            count.put(b, count.getOrDefault(b, 0) + 1);
        }
        
        for(int i = 0; i < nodes.length; i++) {
            int root = nodes[i]; // 현재 루트 노드의 번호
            
            Set<Integer> visited = new HashSet<>();
            
            
            // 1. 루트 노드가 홀짝 트리인지 검증
            if(isValid(root, root, visited)) {
                // 1-1. 홀짝 트리인지 검증하고, 맞다면 result++;
                if(solve(root, visited)) {
                    result[0]++;
                }
            }
            
            visited = new HashSet<>();
            
            // 1-2. 역홀짝 트리가 맞는지 검증한다.
            if(!isValid(root, root, visited)) {
                if(reverse(root, visited)) {
                    result[1]++;
                }
            }
        }
        
        return result;
        
    }
    
    static boolean solve(int root, Set<Integer> visited) {
        // 홀짝 트리 여부 확인
        // DFS + memoization
        visited.add(root);
        
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        stk.push(root);
        
        while(!stk.isEmpty()) {
            int p = stk.pop();
            
            for(Integer next : nodeList[map.get(p)].childs) {
                
                if(visited.contains(next)) continue;
                
                // 만약 하나라도 홀짝 트리에 위배된다면 불가능
                if(!isValid(root, next, visited)) return false;
                
                stk.push(next);
                visited.add(next);
            }
        }
        
        return true;
            
    }
    
    static boolean reverse(int root, Set<Integer> visited) {
        // 역홀짝 트리가 맞는지 검증
        // DFS + memoization
        
        visited.add(root);
        
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        stk.push(root);
        
        while(!stk.isEmpty()) {
            
            int p = stk.pop();
                        
            for(Integer next : nodeList[map.get(p)].childs) {
                
                if(visited.contains(next)) continue;
                
                if(isValid(root, next, visited)) return false;
                
                stk.push(next);
                visited.add(next);
            }   
        }
        
        return true;
        
    }
    
    // 홀짝 트리에 대한 유효성 검증
    static boolean isValid(int root, int start, Set<Integer> visited) {
        int cnt = count.get(start);
        if(root != start) cnt--;
        
        if((start & 1) == 0) {
            // 짝수
            if((cnt & 1) == 0) return true;
            else return false;
        } else {
            // 홀수
            if((cnt & 1) == 1) return true;
            else return false;
        }
    }
}