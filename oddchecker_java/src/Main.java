public class Main {
    double matrix_A[][];
    double matrix_B[][];
    
    public Main(double matriz_a[][], double matriz_b[][]) {
        this.matrix_A = matriz_a;
        this.matrix_B = matriz_b;
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
    
    public void doOperations(double[][] matrix_select){
        ArrayFunction obj = new ArrayFunction();
        
        System.out.println("You chose matrix:");
        System.out.println(obj.printMatrix(matrix_select));
        
        System.out.println("Length of matrix");
        System.out.println(obj.getLength(matrix_select));
        
        System.out.println("Verifying diagonal:");
        System.out.println(obj.checkDiagonal(matrix_select));
        
        System.out.println("Verifying matrix");
        System.out.println(obj.checkMatrix(matrix_select));
        
        System.out.println("-----------------");
    }
    
    public static void main(String args[]) {
        double mA[][] = {{1,2,3},{2,3,4},{5,6,7}};
        double mB[][] = {{3.5,2.3,0.1},{1,2,3.2},{1.1,3,0.8}};
        String option = "";
        java.util.Scanner scnr = new java.util.Scanner(System.in);
        
        Main obj = new Main(mA, mB);
        System.out.println("Select option: ");
        option = scnr.next().toString();
        
        try {
            obj.Select(Integer.parseInt(option));
        } catch (Exception e) {System.out.println("This is not a number");}
        
    }
}
