package com.wstevens.gameoflife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import com.wstevens.gameoflife.Cell;
import com.wstevens.gameoflife.GameOfLife;
import com.wstevens.gameoflife.Grid;

// Unit tests for methods in the Cell class
public class CellTest {
    
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
    public void testGetNumLiveNeighbors() {
        assertEquals(grid.getCellAtCoordinate(1, 0).getNumLiveNeighbors(), 3);
        assertEquals(grid.getCellAtCoordinate(7, 0).getNumLiveNeighbors(), 2);
        assertEquals(grid.getCellAtCoordinate(1, 3).getNumLiveNeighbors(), 0);
        assertEquals(grid.getCellAtCoordinate(3, 5).getNumLiveNeighbors(), 3);
    }
    
    @Test
    public void testCellCopy() {
        Cell c1 = grid.getCellAtCoordinate(0, 0);
        Cell c2 = new Cell(new Grid(binaryInput), c1);
        assertNotEquals(c1.getGrid(), c2.getGrid());
        assertEquals(c1.getState(), c2.getState());
        assertEquals(c1.getX(), c2.getX());
        assertEquals(c1.getY(), c2.getY());
    }
}
