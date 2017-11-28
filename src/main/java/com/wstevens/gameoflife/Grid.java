package com.wstevens.gameoflife;


/**
* A Grid is a rectangular grouping of cells making up the Game Of Life. Each cell is either alive or 
* dead.
* https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
*
* @author  Weston Stevens
* @version 1.0
* @since   2017-11-25 
*/
public class Grid {
    private int length;
    private int width;
    private Cell[][] gridState = new Cell[length][width];
    
    /** 
     * Class constructor. Only used by other constructors.
     * 
     * @param length  The length of the grid.
     * @param width   The width of the grid.
     */
    private Grid(int length, int width) {
        this.length = length;
        this.width = width;
        this.gridState = new Cell[length][width];
    }
    
    /** 
     * Class constructor. Takes a very simple binary state representation and builds a grid object from it.
     * This makes it easiest to specify the desired grid dimensions and its initial state.
     * 
     * @param binaryStateRep  Binary state representation of what the grid is to be built on.
     */
    public Grid(int[][] binaryStateRep) {
        this(binaryStateRep[0].length, binaryStateRep.length);
        
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.length; j++) {
                this.gridState[j][i] = new Cell(this, binaryStateRep[i][j] == 1 ? Cell.CellState.alive : Cell.CellState.dead, j, i);
            }
        }
    }
    
    /** 
     * Class copy constructor. Duplicates a full copy from the passed grid object.
     * 
     * @param orig  The grid to be copied.
     */
    public Grid(Grid orig) {
        this(orig.getLength(), orig.getWidth());
        
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.length; j++) {
                this.gridState[j][i] = new Cell(this, orig.getCellAtCoordinate(j, i));
            }
        }
    }
    
    /** 
     * Returns the cell at the given x, y coordinate in this grid.
     * 
     * @param x  The x coordinate of the cell.
     * @param y  The y coordinate of the cell.
     * @return   The cell at the specified coordinates.
     */
    public Cell getCellAtCoordinate(int x, int y) {
        return this.gridState[x][y];
    }
    
    /** 
     * Sets the state of the cell at the specified x, y coordinates in the grid.
     * 
     * @param x      The x coordinate of the cell.
     * @param y      The y coordinate of the cell.
     * @param state  The new state of the cell, either dead or alive.
     */
    public void setCellAtCoordinate(int x, int y, Cell.CellState state) {
        this.gridState[x][y].setState(state);
    }
    
    /** 
     * Returns a simplified binary state representation of this grid object.
     * 
     * @return  Simplified binary state representation of this grid object
     */
    public int[][] getBinaryRepresentation() {
        int[][] binaryResult = new int[width][length];
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.length; j++) {
                binaryResult[i][j] = this.gridState[j][i].getState() == Cell.CellState.alive ? 1 : 0;
            }
        }
        
        return binaryResult;
    }
    
    /** 
     * Prints the current state of the grid in easily understood ASCII.
     */
    public void display() {
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.length; j++) {
                if(this.gridState[j][i].getState() == Cell.CellState.alive) {
                    System.out.print("O"); // Alive
                } else {
                    System.out.print("."); // Dead
                }
            }
            System.out.println();
        }
    }
    
    /** 
     * Returns the width of the grid in # of cells.
     * 
     * @return  Width of the grid in # of cells.
     */
    public int getWidth() {
        return this.width;
    }
    
    /** 
     * Returns the length of the grid in # of cells.
     * 
     * @return  Length of the grid in # of cells.
     */
    public int getLength() {
        return this.length;
    }
}
