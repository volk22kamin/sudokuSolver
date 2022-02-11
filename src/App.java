public class App {



    public static final int GRID_SIZE = 9;
    static int count = 0;

    public static void main(String[] args) throws Exception {



   
        int[][] board2 = {
            {2, 3, 0, 4, 1, 0, 0, 6, 0 },
            {0, 0, 0, 2, 3, 6, 5, 1, 0} ,
            {1, 0, 0, 0, 8, 7, 2, 0, 4} ,
            {0, 1, 0, 0, 9, 4, 0, 2, 0} ,
            {4, 0, 0, 1, 2, 0, 6, 0, 7} ,
            {0, 2, 0, 0, 5, 8, 3, 0, 0} ,
            {0, 0, 0, 5, 0, 0, 1, 0, 2} ,
            {0, 0, 0, 8, 4, 2, 9, 0, 3} ,
            {0, 9, 2, 0, 7, 0, 4, 8, 0} 
        };
        int[][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 7, 0, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3} 
        };
        int g = 0;
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                if(board[i][j] == 0){
                    g++;
                }
            }
        }
        System.out.println(g + " ljkdshvbfsdlkjvs");

        printBoard(board);
        if(solve(board)){
            System.out.println("solved");
        } else{
            System.out.println("error");
        }
        printBoard(board);
        System.out.println(count);
    }

    public static void increment(){
        count++;
    }


    public static boolean solve(int[][] board){
        
        
        for(int row = 0; row < GRID_SIZE; row++){

            for(int col = 0; col < GRID_SIZE; col++){

                if(board[row][col] == 0){

                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++){

                        if(correctPlacement(board, numberToTry, row, col)){

                            board[row][col] = numberToTry;
                            increment();
                            // clear();
                            // printBoard(board);
                            if(solve(board)){
                                return true;
                                
                            } else {
                                
                                board[row][col] = 0;
                                
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isInRow(int[][] board, int number, int row){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }
    public static boolean isInCol(int[][] board, int number, int col){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][col] == number){
                return true;
            }
        }
        return false;
    }


    public static boolean isInBox(int[][] board, int number, int row, int col){
        int topLeftRow = row - row % 3;
        int topLeftCol = col - col % 3;

        for(int i = topLeftRow; i < topLeftRow + 3; i++){
            for(int j = topLeftCol; j < topLeftCol + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean correctPlacement(int[][] board, int number, int row, int col){
        return !isInRow(board, number, row) && !isInCol(board, number, col) && !isInBox(board, number, row, col);
    }

    public static void printBoard(int[][] board) {
        for(int i = 0; i < GRID_SIZE; i++){
            if(i % 3 == 0 && i != 0){
                System.out.println("----------------------------");
            }
            for(int j = 0; j < GRID_SIZE; j++){
                if(j % 3 == 0 && j != 0){
                    System.out.print("|");
                }
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void clear(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}


