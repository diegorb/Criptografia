package mx.Iteso;

/**
 * Created by Angel on 9/8/16.
 */
public class MathUtils {

    static char[] abecedario = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                         'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static int getIndex(char letter) {
        for (int i = 0; i < abecedario.length; i++)
            if(abecedario[i] == letter)
                return i;

        return -1;
    }

    public static boolean hasInverse(int[][] matrix) {
        int determinant = determinant(matrix) % 26;

        if(determinant == 0 || getGCD(26, determinant) != 1)
            return false;

        return true;
    }

    public static int determinant(int[][] matrix){ //method sig. takes a matrix (two dimensional array), returns determinant.
        int sum=0;
        int s;
        if(matrix.length==1){  //bottom case of recursion. size 1 matrix determinant is itself.
            return(matrix[0][0]);
        }
        for(int i=0;i<matrix.length;i++){ //finds determinant using row-by-row expansion
            int[][]smaller= new int[matrix.length-1][matrix.length-1]; //creates smaller matrix- values not in same row, column
            for(int a=1;a<matrix.length;a++){
                for(int b=0;b<matrix.length;b++){
                    if(b<i){
                        smaller[a-1][b]=matrix[a][b];
                    }
                    else if(b>i){
                        smaller[a-1][b-1]=matrix[a][b];
                    }
                }
            }
            if(i%2==0){ //sign changes based on i
                s=1;
            }
            else{
                s=-1;
            }
            sum+=s*matrix[0][i]*(determinant(smaller)); //recursive step: determinant of larger determined by smaller.
        }
        return(sum % 26); //returns determinant value. once stack is finished, returns final determinant.
    }

    public static int getGCD(int number1, int number2) {
        if(number2 == 0)
            return number1;

        return getGCD(number2, number1%number2);
    }

}
