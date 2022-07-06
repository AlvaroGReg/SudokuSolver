public class Methods {

    int loops = 1;
    int numbersChanged = 0;
    public Methods() {
    }

    public int getLoops() {
        return loops;
    }

    int[][] sudokuTable = new int[9][9];

    public void solve() {

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                if (sudokuTable[y][x] == 0) {
                    sudokuTable[y][x] = setCellValue(y, x);
                }
            }
        }
        if(isSolved()){
            System.out.println("Sudoku solved! <3 Loops needed:" + getLoops());
            printTable();
            return;
        }else if(numbersChanged!=0){
            solve();
        }else {
            System.out.println("I have no more ideas. Loops trying:" + getLoops());
            printTable();
            return;
        }

    }

    public void fillTable(int[][] sudokuToSolve) {

        for (int x = 0; x<9; x++){
            for(int y = 0; y<9; y++){
                sudokuTable[y][x]=sudokuToSolve[y][x];
            }
        }

    }

    public void printTable() {

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (y == 8) {
                    if(x!=8){
                        System.out.println(sudokuTable[y][x]);
                    }else{
                        System.out.println(sudokuTable[y][x]);
                        System.out.println();
                    }
                } else {
                    System.out.print(sudokuTable[y][x]);
                }
            }
        }

    }

    //COMPARAR CON OTRAS CELLS CON VALOR Y Y DESCARTAR SUS NÚMEROS
    public int[] checkRow(int row, int column) {

        //DECLARAMOS ARRAY DE NUMEROS RELLENADO DEL 1 AL 9
        int[] arrayRaw = new int[9];

        for (int x = 0; x < 9; x++) {
            arrayRaw[x] = x + 1;
        }

//RECORREMOS EL ARRAY CONVIRTIENDO EN 0 LOS VALORES NO VÁLIDOS

        for (int x = 0; x < 9; x++) {

            if (sudokuTable[x][column]!=0) {

                arrayRaw[(sudokuTable[x][column]) - 1] = 0;
            }
        }

        return arrayRaw;
    }

    public int[] checkColumn(int row, int column) {

        int[] value = new int[9];

        for (int x = 0; x < 9; x++) {
            value[x] = x + 1;
        }

        for (int x = 0; x < 9; x++) {

            if (sudokuTable[row][x]!=0) {
                value[(sudokuTable[row][x]) - 1] = 0;
            }
        }

        return value;
    }

    // PUEDEN ESTAR LOS CUADROS INVERTIDOS NEED TO TEST

    public int[] checkSquare(int row, int column) {

        int[] value = new int[9];

        for (int x = 0; x < 9; x++) {
            value[x] = x + 1;
        }

        if (row < 3) {
            if (column < 3) {

                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }
            } else if (column > 2 && column < 6) {

                for (int x = 3; x < 6; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            } else if (column > 5) {
                for (int x = 6; x < 9; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            }

        } else if (row > 2 && row < 6) {

            if (column < 3) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 3; y < 6; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            } else if (column > 2 && column < 6) {
                for (int x = 3; x < 6; x++) {
                    for (int y = 3; y < 6; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            } else if (column > 5) {
                for (int x = 6; x < 9; x++) {
                    for (int y = 3; y < 6; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }


            }

        } else if (row > 5) {

            if (column < 3) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 6; y < 9; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            } else if (column > 2 && column < 6) {
                for (int x = 3; x < 6; x++) {
                    for (int y = 6; y < 9; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            } else if (column > 5) {
                for (int x = 6; x < 9; x++) {
                    for (int y = 6; y < 9; y++) {
                        if (sudokuTable[y][x]!=0) {
                            value[(sudokuTable[y][x]) - 1] = 0;
                        }
                    }
                }

            }
        }

        return value;
    }

    public int setCellValue(int row, int column) {

        boolean[] booleanRow = new boolean[9];
        boolean[] booleanColumn = new boolean[9];
        boolean[] booleanSquare = new boolean[9];
        boolean[] booleansCommon = new boolean[9];
        boolean unique = false;
        int correctNumber = 0;

        //CHECK ROW AND RETURN NUMBER AS BOOLEAN IF IT WORKS
        for (int x = 0; x < 9; x++) {

            if (checkRow(row, column)[x] != 0) {
                booleanRow[x]=true;
            }
        }

        //CHECK IF THERE IS ONLY ONE VALID NUMBER
        for (int x = 0; x < 9; x++) {

            if(booleanRow[x] && !unique){
                unique=true;
                correctNumber=x+1;

            } else if (booleanRow[x] && unique) {
                unique=false;
                correctNumber=0;
                break;
            }
            if (x==8 && unique) {
                numbersChanged++;
                return correctNumber;
            }
        }

        //CHECK COLUMN AND RETURN NUMBER IF IT WORKS

        for (int x = 0; x < 9; x++) {

            if (checkColumn(row, column)[x] != 0) {
                booleanColumn[x]=true;
            }
        }

        for (int x = 0; x < 9; x++) {

            if(booleanColumn[x] && !unique){
                unique=true;
                correctNumber=x+1;

            } else if (booleanColumn[x] && unique) {
                unique=false;
                correctNumber=0;
                break;
            }
            if (x==8 && unique) {
                numbersChanged++;
                return correctNumber;
            }
        }
        //CHECK SQUARE AND RETURN NUMBER IF IT WORKS

        for (int x = 0; x < 9; x++) {

            if (checkSquare(row, column)[x] != 0) {
                booleanSquare[x]=true;
            }
        }

        for (int x = 0; x < 9; x++) {

            if(booleanSquare[x] && !unique){
                unique=true;
                correctNumber=x+1;

            } else if (booleanSquare[x] && unique) {
                unique=false;
                correctNumber=0;
                break;
            }
            if (x==8 && unique) {
                return correctNumber;
            }
        }
        //COMPARARO LOS [BOOLEAN] PARA SACAR UN NÚMERO
        for (int x = 0; x<9; x++){
            if(booleanRow[x] && booleanColumn[x] && booleanSquare[x]){
                booleansCommon[x]=true;
            }
        }
        //COMPRUEBO SI SOLO HAY UN VALOR VÁLIDO
        for (int x=0;x<9;x++){
            if (booleansCommon[x] && !unique){
                unique=true;
                correctNumber=x+1;
            }else if(booleansCommon[x] && unique){
                unique=false;
                correctNumber=0;
                break;
            }
            if (x==8 && unique) {
                numbersChanged++;
                return correctNumber;
            }
        }

        //TODO:CHECK IF ==1 CELL CAN GET A NUMBER IN ROW COLUMN AND SQUARE

        return 0;
    }

    public boolean isSolved(){

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                if(sudokuTable[y][x]==0){
                    System.out.println("Bucle: " + loops);
                    System.out.println("Numbers changed: " + numbersChanged);
                    numbersChanged=0;
                    printTable();
                    loops++;
                    return false;
                }
            }
        }

        return true;
    }
}


