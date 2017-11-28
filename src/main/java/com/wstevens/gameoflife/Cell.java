package com.wstevens.gameoflife;


/**
* A cell represents an alive or dead state within a Grid. Each cell has a coordinate within the Grid
* used to locate the Cell and its neighbors. A cell is aware of the grid for which it is a part of.
* https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
* 
* @author  Weston Stevens
* @version 1.0
* @since   2017-11-25 
*/
public class Cell {
    public enum CellState {
        alive,
        dead
    }
    
    private Grid grid;
    private CellState state;
    private int x;
    private int y;
    
    /** 
     * Class constructor.
     * 
     * @param grid   The grid with which the Cell is associated.
     * @param state  The state of the cell, alive or dead.
     * @param x  The x coordinate of the cell.
     * @param y  The y coordinate of the cell.
     */
    public Cell(Grid grid, CellState state, int x, int y) {
        this.grid = grid;
        this.state = state;
        this.x = x;
        this.y = y;
    }
    
    /** 
     * Class copy constructor. Duplicates a full copy from the passed cell object.
     * 
     * @param grid  The grid with which the cell is associated.
     * @param orig  The cell to be copied.
     */
    public Cell(Grid grid, Cell orig) {
        this.grid = grid;
        this.state = orig.getState();
        this.x = orig.getX();
        this.y = orig.getY();
    }
    
    /** 
     * Returns the grid for which the cell is associated.
     * 
     * @return  The associated grid object.
     */
    public Grid getGrid() {
        return this.grid;
    }
    
    /** 
     * Sets the new state of the cell.
     * 
     * @param state  The new state of the cell.
     */
    public void setState(CellState state) {
        this.state = state;
    }
    
    /** 
     * Returns the state of the cell (alive or dead).
     * 
     * @return  The state of the cell.
     */
    public CellState getState() {
        return this.state;
    }
    
    /** 
     * Sets the x coordinate of the cell.
     * 
     * @param x  The x coordinate of the cell.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /** 
     * Returns the x coordinate of the cell.
     * 
     * @return  The x coordinate of the cell.
     */
    public int getX() {
        return this.x;
    }
    
    /** 
     * Sets the y coordinate of the cell.
     * 
     * @param y  The y coordinate of the cell.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /** 
     * Returns the y coordinate of the cell.
     * 
     * @return  The y coordinate of the cell.
     */
    public int getY() {
        return this.y;
    }
    
    /** 
     * Most cells have 8 neighbors. The ones on the edges have fewer. Returns how many "alive" 
     * neighbors this cell has, which is used to determine if the cell is to be alive or dead.
     * 
     * @return  The "alive" neighbor count for this cell.
     */
    public int getNumLiveNeighbors() {
        int count = 0;
        
        // Cell east (if exists)
        if(x+1 < grid.getLength())
            count += (this.grid.getCellAtCoordinate(x+1, y).getState() == CellState.alive) ? 1 : 0;
        
        // Cell west (if exists)
        if(x-1 >= 0)
            count += (this.grid.getCellAtCoordinate(x-1, y).getState() == CellState.alive) ? 1 : 0;
        
        // Cell north (if exists)
        if(y-1 >= 0)
            count += (this.grid.getCellAtCoordinate(x, y-1).getState() == CellState.alive) ? 1 : 0;
        
        // Cell south (if exists)
        if(y+1 < grid.getWidth())
            count += (this.grid.getCellAtCoordinate(x, y+1).getState() == CellState.alive) ? 1 : 0;
        
        // Cell northeast (if exists)
        if((x+1 < grid.getLength()) && (y-1 >= 0))
            count += (this.grid.getCellAtCoordinate(x+1, y-1).getState() == CellState.alive) ? 1 : 0;
        
        // Cell northwest (if exists)
        if((x-1 >= 0) && (y-1 >= 0))
            count += (this.grid.getCellAtCoordinate(x-1, y-1).getState() == CellState.alive) ? 1 : 0;
        
        // Cell southeast (if exists)
        if((x+1 < grid.getLength()) && (y+1 < grid.getWidth()))
            count += (this.grid.getCellAtCoordinate(x+1, y+1).getState() == CellState.alive) ? 1 : 0;
        
        // Cell southwest (if exists)
        if((x-1 >= 0) && (y+1 < grid.getWidth()))
            count += (this.grid.getCellAtCoordinate(x-1, y+1).getState() == CellState.alive) ? 1 : 0;
        
        return count;
    }
}
