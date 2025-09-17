import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC721 {
    public static void main(String[] args) {
        LC721 solution = new LC721();
        List<List<String>> input1 = List.of(
            List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
            List.of("John","johnsmith@mail.com","john00@mail.com"),
            List.of("Mary","mary@mail.com"),
            List.of("John","johnnybravo@mail.com")
        );
        List<List<String>> input2 = List.of(
            List.of("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
            List.of("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
            List.of("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
            List.of("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
            List.of("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")
        );

        boolean test1 = solution.accountsMerge(input1).equals(solution.CorrectAns(input1));
        boolean test2 = solution.accountsMerge(input2).equals(solution.CorrectAns(input2));
        System.out.println(test1);
        System.out.println(test2);
    }

    static int[] parent;
    static int[] rank;

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    
    static void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        
        if(ra != rb){
            if(rank[ra] > rank[rb]){
                parent[rb] = ra;
            }else if(rank[ra] < rank[rb]){
                parent[ra] = rb;
            }else{
                parent[ra] = rb;
                rank[rb]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        

        int V = accounts.size();

        parent = new int[V];
        rank = new int[V];

        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> tempAccounts = new ArrayList();

        for(int i = 0; i<V; i++){
            parent[i] = i;
            tempAccounts.add(new ArrayList<>());
        }

        for(int i = 0; i<V; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){
                String s = accounts.get(i).get(j);
                if(map.containsKey(s)){
                    union(i, map.get(s));
                }else{
                    map.put(s, i);
                }
            }
        }
        
        for(int i = 0; i<V; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){
                String s = accounts.get(i).get(j);
                int root = find(map.get(s));
                if(tempAccounts.get(root).contains(s)) continue;
                tempAccounts.get(root).add(s);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i<V; i++){
            if(tempAccounts.get(i).size() == 0) continue;

            List<String> temp = tempAccounts.get(i);
            Collections.sort(temp);

            List<String> tempAns = new ArrayList<>();
            tempAns.add(accounts.get(i).get(0));

            tempAns.addAll(temp);
            ans.add(tempAns);

        }

        return ans;
    }

    public List<List<String>> CorrectAns(List<List<String>> details) {
        
        // String -> index
        HashMap<String, Integer> map = new HashMap();
        int n = details.size();
        
        parent = new int[n];
        
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        
        rank = new int[n];
        
        for(int i = 0; i<n; i++){
            for(int j = 1; j<details.get(i).size(); j++){
                
                String mail = details.get(i).get(j);
                
                if(map.containsKey(mail)){
                    union(i, map.get(mail));
                    continue;
                }
                
                map.put(mail, i);
            }
        }
        
        List<List<String>> temp = new ArrayList();
        
        for(int i = 0; i<n; i++){
            temp.add(new ArrayList());
        }
        
        
        for(int i = 0; i<n; i++){
            for(int j = 1; j<details.get(i).size(); j++){
                String mail = details.get(i).get(j);
                int root = find(map.get(mail));
                if(!temp.get(root).contains(mail))temp.get(root).add(mail);
            }
        }
        
        List<List<String>> ans = new ArrayList();
        
        for(int i = 0; i<n; i++){
            
            if(temp.get(i).size() == 0) continue;
            
            List<String> sortedEmail = temp.get(i);
            Collections.sort(sortedEmail);
            
            List<String> ansTemp = new ArrayList();
            ansTemp.add(details.get(i).get(0));
            
            for(String s : sortedEmail){
                ansTemp.add(s);
            }
            
            ans.add(ansTemp);
            
        }
        
        return ans;
    }
}