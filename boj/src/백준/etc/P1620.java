package 백준.etc;

import java.util.HashMap;
import java.util.Scanner;

public class P1620 {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<String, String> pokemons = new HashMap<>();
    private static int N, M;

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String pokemon = sc.next();
            pokemons.put(pokemon, String.valueOf(i));
            pokemons.put(String.valueOf(i), pokemon);
        }
    }

    private static void solve() {
        for (int i = 0; i < M; i++) {
            System.out.println(pokemons.get(sc.next()));
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
