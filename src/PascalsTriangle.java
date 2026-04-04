import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generatePascalTriangle(numRows);
        System.out.println(result);
    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0){
            return triangle;
        }
        for (int i = 0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++){
                if (j==0 || j==i) {
                    row.add(1);
                }else {
                    int num = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                    row.add(num);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
