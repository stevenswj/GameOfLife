package com.wstevens.gameoflife;


import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import com.wstevens.gameoflife.GameOfLife;
import com.wstevens.gameoflife.Grid;

// Unit tests the next generation functionality in the GameOfLife class
public class UpdateTest {
    
    @Test
    public void testUpdate() {
        int[][] binaryInput = new int[][] {
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 1, 1, 1, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 }
        };
        
        Grid grid = new Grid(binaryInput);
        GameOfLife game = new GameOfLife(grid);
        game.nextGeneration();
        
        int[][] binaryResult = grid.getBinaryRepresentation();
        assertArrayEquals(binaryResult[0], new int[] { 0, 1, 0, 0, 0, 0, 0, 0 });
        assertArrayEquals(binaryResult[1], new int[] { 0, 1, 0, 0, 0, 1, 1, 1 });
        assertArrayEquals(binaryResult[2], new int[] { 0, 1, 0, 0, 0, 0, 0, 0 });
        assertArrayEquals(binaryResult[3], new int[] { 0, 0, 0, 0, 0, 0, 0, 0 });
        assertArrayEquals(binaryResult[4], new int[] { 0, 0, 0, 1, 1, 0, 0, 0 });
        assertArrayEquals(binaryResult[5], new int[] { 0, 0, 0, 1, 1, 0, 0, 0 });
    }
}
