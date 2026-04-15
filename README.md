# Sodoku-Generator
AP CSA Project: Sodoku Puzzle Generator 

# Project Title
Sudoku Generator

# Name
Kennedy Boughal

## Description
This program generates a fully solved 9x9 Sudoku board using Java. It creates a random first row and then builds the rest of the board by copying and shifting rows until they follow Sudoku rules (no duplicates in columns or 3x3 boxes).

## How to Run it
1. Make sure you have Java installed
2. Open the file in an IDE or compile using terminal
3. Run the `SudokuGenerator` class
4. The solved Sudoku board will print in the console

## Summary of How the Sudoku Board is Generated
The program starts by creating a shuffled list of numbers from 1 to 9 and placing them into the first row of a 9x9 board. Then, for each new row, it copies the previous row and shifts the values to the right until the row is valid. A helper method checks that there are no duplicate values in any column or 3x3 box. This process repeats until all rows are filled, resulting in a complete and valid Sudoku board.

## List of Files Included in the Project
- `SudokuGenerator.java` – Main program file that contains all logic for generating and printing the Sudoku board
