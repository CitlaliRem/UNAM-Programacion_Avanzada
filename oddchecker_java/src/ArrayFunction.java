public class ArrayFunction {
    
    public int getLength(double matrix[][]){
        return matrix.length;
    }
    
    public boolean checkEven(double value){
        if(value % 2 == 0 ) return true;
        return false;
    }
    
    public String checkDiagonal(double matrix[][]) {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i == j ){
                   if(checkEven(matrix[i][j])) {
                       result += "["+i+"]["+j+"]:\t "+"even";
                   	   result += "\n";
                   } else {
                       result += "["+i+"]["+j+"]:\t "+"odd";
                   	   result += "\n";
                   }
                }
            }
        }
        return result;
    }
    
    public String checkMatrix(double matrix[][]){
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(checkEven(matrix[i][j])) {
                       result += "["+i+"]["+j+"]:\t "+"even";
                   	   result += "\n";
                } else {
                       result += "["+i+"]["+j+"]:\t "+"odd";
                   	   result += "\n";
                }
            }
        }
        return result;
    }
    
    public String printMatrix(double matrix[][]){
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result += matrix[i][j]+" \t";
            }
            result +="\n";
        }
        
        return result;
    }
}