package main.java;

public class Matrix {

    //matrixi tanımla
    int[][] elements;
    public Matrix(int[][] input){
        this.elements = input;
    }

    public int[][] rotate90right(){
        //transpoze
        for (int i=0; i< elements.length; i++){
            for (int j=i; j<elements[i].length; j++){
                    int temp = elements[i][j];
                    elements[i][j] = elements[j][i];
                    elements[j][i] = temp;
            }
        }
        //swap the columns
        for (int i=0; i < elements.length; i++){
            for (int j=0; j < elements[i].length / 2; j++){
                int temp = elements[i][j];
                elements[i][j] = elements[i][elements.length - j - 1];
                elements[i][elements.length - j - 1] = temp;
            }
        }
        return elements;
    }

    public void printMatrix(){
        for(int i=0; i < elements.length; i++){
            for(int j=0; j <elements[i].length; j++){
                System.out.print(elements[i][j]+" " +"\t");
            }
            System.out.println();
        }
    }

    public static boolean isEqualMatrix(int[][] matrix1, int[][] matrix2){
        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[i].length; j++){
                if (matrix1[i][j] != matrix2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
