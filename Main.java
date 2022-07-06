public class Main {

    public static void main(String[] args) {

        Methods methods = new Methods();

        int[][] newSudoku = new int[9][9];

        newSudoku[0][0] = 0;
        newSudoku[0][1] = 7;
        newSudoku[0][2] = 0;
        newSudoku[0][3] = 0;
        newSudoku[0][4] = 0;
        newSudoku[0][5] = 0;
        newSudoku[0][6] = 0;
        newSudoku[0][7] = 0;
        newSudoku[0][8] = 0;
        newSudoku[1][0] = 0;
        newSudoku[1][1] = 0;
        newSudoku[1][2] = 0;
        newSudoku[1][3] = 0;
        newSudoku[1][4] = 0;
        newSudoku[1][5] = 4;
        newSudoku[1][6] = 0;
        newSudoku[1][7] = 0;
        newSudoku[1][8] = 2;
        newSudoku[2][0] = 4;
        newSudoku[2][1] = 0;
        newSudoku[2][2] = 0;
        newSudoku[2][3] = 3;
        newSudoku[2][4] = 0;
        newSudoku[2][5] = 0;
        newSudoku[2][6] = 0;
        newSudoku[2][7] = 9;
        newSudoku[2][8] = 0;
        newSudoku[3][0] = 0;
        newSudoku[3][1] = 0;
        newSudoku[3][2] = 6;
        newSudoku[3][3] = 0;
        newSudoku[3][4] = 0;
        newSudoku[3][5] = 0;
        newSudoku[3][6] = 4;
        newSudoku[3][7] = 8;
        newSudoku[3][8] = 0;
        newSudoku[4][0] = 1;
        newSudoku[4][1] = 0;
        newSudoku[4][2] = 0;
        newSudoku[4][3] = 9;
        newSudoku[4][4] = 0;
        newSudoku[4][5] = 0;
        newSudoku[4][6] = 0;
        newSudoku[4][7] = 0;
        newSudoku[4][8] = 6;
        newSudoku[5][0] = 3;
        newSudoku[5][1] = 0;
        newSudoku[5][2] = 0;
        newSudoku[5][3] = 5;
        newSudoku[5][4] = 8;
        newSudoku[5][5] = 0;
        newSudoku[5][6] = 0;
        newSudoku[5][7] = 0;
        newSudoku[5][8] = 9;
        newSudoku[6][0] = 0;
        newSudoku[6][1] = 0;
        newSudoku[6][2] = 0;
        newSudoku[6][3] = 0;
        newSudoku[6][4] = 0;
        newSudoku[6][5] = 3;
        newSudoku[6][6] = 0;
        newSudoku[6][7] = 0;
        newSudoku[6][8] = 0;
        newSudoku[7][0] = 0;
        newSudoku[7][1] = 2;
        newSudoku[7][2] = 0;
        newSudoku[7][3] = 0;
        newSudoku[7][4] = 0;
        newSudoku[7][5] = 0;
        newSudoku[7][6] = 0;
        newSudoku[7][7] = 0;
        newSudoku[7][8] = 5;
        newSudoku[8][0] = 5;
        newSudoku[8][1] = 0;
        newSudoku[8][2] = 0;
        newSudoku[8][3] = 1;
        newSudoku[8][4] = 0;
        newSudoku[8][5] = 0;
        newSudoku[8][6] = 6;
        newSudoku[8][7] = 0;
        newSudoku[8][8] = 0;

        methods.fillTable(newSudoku);

        methods.printTable();

        methods.solve();



    }}
