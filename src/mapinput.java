import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class mapinput {
    
    public static void main(String[] as) {
        getData();
    }

    public static void getData() {
        Map<Integer, String> hashmap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Shashank Pathak\nEnter number of character: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i <n ; i++) {
            Integer b = sc.nextInt();
            String c = sc.nextLine();

            hashmap.put(b, c);
        }

        for (Map.Entry<Integer, String> mp : hashmap.entrySet()) {
            System.out.println("\n" + mp.getKey() + " " + mp.getValue());
        }
    }
}
