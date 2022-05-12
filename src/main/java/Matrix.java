import java.util.Random;

public class Matrix {
    public static void indexesOfNullColumns(int[][] matrix){
        System.out.print("Nulloszlopok indexei: ");
        for(int j=0;j< matrix.length;j++){
            int i=0;
            if(matrix[i][j]==0){
                if(matrix[i+1][j]==0){
                    if(matrix[i+2][j]==0){
                        if(matrix[i+3][j]==0){
                            System.out.print((j+1)+" ");
                        }
                    }
                }
            }
        }
    }
    public static void indexOfMaximum(int[][] matrix){
        int maxi=0,maxj=0,max=0;
        for(int i=0;i< matrix.length;i++){
            System.out.println();
            for(int j=0;j< matrix.length;j++){
                System.out.print(matrix[i][j]+"\t");
                if(matrix[i][j]>max){
                    max=matrix[i][j];
                    maxi=i;
                    maxj=j;
                }
            }
        }
        System.out.println("\nMax ertek indexei: "+(maxj+1)+", "+(maxi+1)+"\n");
    }
    public static void main(String[] args) {
        /*Random r=new Random();
        int[][] matrix=new int[4][4];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                matrix[i][j]=r.nextInt(20);
                System.out.print(matrix[i][j]+"\t");
            }

            System.out.print("\n");
        }*/
        int[][] matrix= {{0,5,3,0}, {0,6,4,0},{0,7,9,0},{0,2,3,0}};
        indexesOfNullColumns(matrix);
        indexOfMaximum(matrix);
    }
}
