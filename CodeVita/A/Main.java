package CodeVita.A;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // int N = Integer.parseInt(sc.nextLine().trim());
        int N = sc.nextInt();
        sc.nextLine(); // "shuffled"
        sc.nextLine();
        String[] shuffled = new String[N];
        for (int i = 0; i < N; i++)
            shuffled[i] = sc.nextLine();

        sc.nextLine(); // "original"
        // sc.nextLine();
        String[] original = new String[N];
        for (int i = 0; i < N; i++)
            original[i] = sc.nextLine();

        System.out.println();
        System.out.println("Shuffled: ");
        for(String s : shuffled){
            System.out.print(s+", ");
        }
        System.out.println("---");
        System.out.println("Original: ");
        for(String s : original){
            System.out.print(s+", ");
        }


        // int N = 5;

        // // Number index => 1, 2, 4, 0, 3
        // String[] shuffled = {"Whisk the onion", "Bake the butter", "Season the garlic", "Fold the flour", "Fold the lettuce"}; 

        // // NUmber index => 0, 1, 2, 3, 4
        // String[] original = {"Fold the flour", "Whisk the onion", "Bake the butter", "Fold the lettuce", "Season the garlic"}; 


        // int N = 6;

        // Number index => 2, 4, 0, 5, 1, 3 
        // String[] shuffled = {"Dice the onion", "Dice the rice", "Pour the onion", "Stir the egg", "Fold the lettuce", "Serve the tomato"}; 

        // Number index => 0, 1, 2, 3, 4, 5
        // String[] original = {"Pour the onion", "Stir the egg", "Fold the lettuce", "Dice the onion", "Dice the rice", "Serve the tomato"};

        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++)
            indexMap.put(original[i], i);

        int[] shuffArr = new int[N];
        for (int i = 0; i < N; i++)
            shuffArr[i] = indexMap.get(shuffled[i]);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (shuffArr[i] > shuffArr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // int swap = 0;
        // for(int i = 0; i<N; i++){
        //     int takeout = -1;
        //     for(int j = 0; j<N; j++){
        //         if(shuffArr[i] - i != 0){
        //             takeout = Math.max(takeout, Math.abs(shuffArr[i] - i));
        //         }
        //     }
        //     if(takeout == -1) break;

        //     swap++;



        // }

        // return swap;

        int longest = 0;
        for (int d : dp) longest = Math.max(longest, d);

        System.out.println(N - longest);
    }

    static boolean isSorted(String[] shuf, String[] orig, int N){
        for(int i = 0; i<N; i++){
            if(shuf[i] != orig[i]) return false;
        }

        return true;
    }
}
