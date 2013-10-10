public class Main {
    double matrix_A[][];
    double matrix_B[][];
    
    public Main(double matrix_a[][], double matrix_b[][]) {
        this.matrix_A = matrix_a;
        this.matrix_B = matrix_b;
    }
    
    public void Select(int option){
        double matrix_select[][] = null;
        
        switch(option) {
            case 3:
                    matrix_select = this.matrix_A;
                break;
            case 5:
                    matrix_select = this.matrix_B;
                break;
        }
        
        this.doOperations(matrix_select);
    }
    
    public void doOperations(double matrix_select[][]){
        ArrayFunction obj = new ArrayFunction();
        
        System.out.println("You chose matrix:");
        System.out.println(obj.printMatrix(matrix_select));
        
        System.out.println("Verifying diagonal:");
        System.out.println(obj.checkDiagonal(matrix_select));
        
        System.out.println("Verifying matrix");
        System.out.println(obj.checkMatrix(matrix_select));
        
        System.out.println("-----------------");
    }
    
    public static void main(String args[]) {
        double mA[][] = {{1,2,3},{2,3,4},{5,6,7}};
        double mB[][] = {{3,2,0,5,7},{3,5,21,2,3},{1,43,0,5,19},{11,51,3,6,19},{7,32,18,4,2}};
        String option = "";
        java.util.Scanner scnr = new java.util.Scanner(System.in);
        
        Main obj = new Main(mA, mB);
        System.out.println("Choose matrix 3x3 or 5x5 (3/5) ");
        option = scnr.next().toString();
        
        try {
            obj.Select(Integer.parseInt(option));
        } catch (Exception e) {System.out.println("This is not a number");}
        
    }
}
