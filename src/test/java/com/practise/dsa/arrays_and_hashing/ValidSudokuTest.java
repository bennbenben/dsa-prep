package com.practise.dsa.arrays_and_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidSudokuTest {

  private final ValidSudoku validSudoku = new ValidSudoku();

  @Test
  void testValidSudoku1() {
    char[][] board = new char[][] {
      {'1','2','.','.','3','.','.','.','.'},
      {'4','.','.','5','.','.','.','.','.'},
      {'.','9','8','.','.','.','.','.','3'},
      {'5','.','.','.','6','.','.','.','4'},
      {'.','.','.','8','.','3','.','.','5'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','.','.','.','.','.','2','.','.'},
      {'.','.','.','4','1','9','.','.','8'},
      {'.','.','.','.','8','.','.','7','9'}
    };
    Assertions.assertTrue(validSudoku.isValidSudoku(board));
  }
  
  @Test
  void testValidSudoku2() {
    char[][] board = new char[][] {
      {'1','2','.','.','3','.','.','.','.'},
      {'4','.','.','5','.','.','.','.','.'},
      {'.','9','1','.','.','.','.','.','3'},
      {'5','.','.','.','6','.','.','.','4'},
      {'.','.','.','8','.','3','.','.','5'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','.','.','.','.','.','2','.','.'},
      {'.','.','.','4','1','9','.','.','8'},
      {'.','.','.','.','8','.','.','7','9'}
    };
    Assertions.assertFalse(validSudoku.isValidSudoku(board));
  }
  
}
