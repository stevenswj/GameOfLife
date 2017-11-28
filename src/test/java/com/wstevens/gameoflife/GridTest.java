package com.wstevens.gameoflife;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.wstevens.gameoflife.GameOfLife;
import com.wstevens.gameoflife.Grid;
import com.wstevens.gameoflife.Cell.CellState;

// Unit tests for methods in the Grid class
public class GridTest {
    
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
    
    @Test
    public void testDimensions() {
        assertEquals(grid.getLength(), 8);
        assertEquals(grid.getWidth(), 6);
    }
    
    @Test
    public void testCellState() {
        assertEquals(grid.getCellAtCoordinate(1, 0).getState(), CellState.dead);
        assertEquals(grid.getCellAtCoordinate(7, 3).getState(), CellState.dead);
        assertEquals(grid.getCellAtCoordinate(3, 5).getState(), CellState.alive);
        assertEquals(grid.getCellAtCoordinate(0, 1).getState(), CellState.alive);
    }
    
    @Test
    public void testGetBinaryRepresentation() {
        int[][] binaryResult = grid.getBinaryRepresentation();
        assertArrayEquals(binaryResult[0], new int[] { 0, 0, 0, 0, 0, 0, 1, 0 });
        assertArrayEquals(binaryResult[1], new int[] { 1, 1, 1, 0, 0, 0, 1, 0 });
        assertArrayEquals(binaryResult[2], new int[] { 0, 0, 0, 0, 0, 0, 1, 0 });
        assertArrayEquals(binaryResult[3], new int[] { 0, 0, 0, 0, 0, 0, 0, 0 });
        assertArrayEquals(binaryResult[4], new int[] { 0, 0, 0, 1, 1, 0, 0, 0 });
        assertArrayEquals(binaryResult[5], new int[] { 0, 0, 0, 1, 1, 0, 0, 0 });
    }
    
    @Test
    public void testGridCopy() {
        Grid copy = new Grid(grid);
        int[][] binaryResultGrid = grid.getBinaryRepresentation();
        int[][] binaryResultCopy = copy.getBinaryRepresentation();
        assertEquals(copy.getLength(), grid.getLength());
        assertEquals(copy.getWidth(), grid.getWidth());
        assertArrayEquals(binaryResultGrid[0], binaryResultCopy[0]);
        assertArrayEquals(binaryResultGrid[1], binaryResultCopy[1]);
        assertArrayEquals(binaryResultGrid[2], binaryResultCopy[2]);
        assertArrayEquals(binaryResultGrid[3], binaryResultCopy[3]);
        assertArrayEquals(binaryResultGrid[4], binaryResultCopy[4]);
        assertArrayEquals(binaryResultGrid[5], binaryResultCopy[5]);
    }
}
