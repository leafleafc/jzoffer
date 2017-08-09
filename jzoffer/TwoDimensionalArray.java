package JZoffer;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int column = 5;
        int row = 5;
        int [][] A = new int[column][row];
        for (int i = 0 ; i < column ; i++){
            for (int j = 0; j< row; j++){
                A[i][j] = i + j;
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
        TwoDimensionalArray array = new TwoDimensionalArray();
        System.out.println(array.find(A, column, row, 9));
    }

    private boolean find(int [][] matrix, int rows, int columns, int target){
        boolean found = false;
        if (matrix != null && rows > 0 && columns > 0){
            for (int row = 0, column = columns - 1; row < rows && column >= 0; ){
                if (matrix[row][column] == target){
                    found = true;
                    break;
                } else if (matrix[row][column] > target){
                    column--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }
}