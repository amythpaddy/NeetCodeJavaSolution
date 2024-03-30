import java.util.List;

public class Helper {
    public static void printListofListInt(List<List<Integer>> input) {
        for (List<Integer> arr : input) {
            for (int num : arr) {
                System.out.print(num + "--");
            }
            System.out.println();
        }
    }

    public static void printListofListStr(List<List<String>> input) {
        for (List<String> arr : input) {
            for (String num : arr) {
                System.out.print(num + "--");
            }
            System.out.println();
        }
    }
}
