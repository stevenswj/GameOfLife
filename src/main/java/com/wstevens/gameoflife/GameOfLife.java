package com.wstevens.gameoflife;


/**
* My attempt at Conway's Game of Life. Contains all the game logic and also used to run the game.
* https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
*
* @author  Weston Stevens
* @version 1.0
* @since   2017-11-25 
*/
public class GameOfLife {
    private Grid grid;
    
    /** 
     * Class constructor.
     */
    public GameOfLife(Grid grid) {
        this.grid = grid;
    }

    /**
     * Changes the GOL state to be that of the next generation according to the following logic:
     * 1) Any live cell with fewer than 2 neighbors dies, as if caused by underpopulation.
     * 2) Any live cell with more than than 3 live neighbors dies, as if caused by overcrowding.
     * 3) Any live cell with 2 or 3 live neighbors lives onto the next generation.
     * 4) Any dead cell with exactly 3 live neighbors becomes a live cell.
     * 5) A cell's neighbors are those cells which are horizontally, vertically or diagonally adjacent.
     *    Most cells will have 8 neighbors. Cells placed on the edge of the grid will have fewer.
     */
    public void nextGeneration() {
        Cell cur = null;
        int numLiveNeighbors;
        
        // Create a copy grid so that modifying the grid will be in reference to how the grid used to 
        // look instead of how it looks now.
        Grid previousGrid = new Grid(this.grid);
        
        for(int i = 0; i < previousGrid.getWidth(); i++) {
            for(int j = 0; j < previousGrid.getLength(); j++) {
                cur = previousGrid.getCellAtCoordinate(j, i);
                numLiveNeighbors = cur.getNumLiveNeighbors();
                
                // Sets the cell to be alive or dead based on # of neighbors
                if(cur.getState() == Cell.CellState.alive) {
                    if(numLiveNeighbors < 2 || numLiveNeighbors > 3)
                        this.grid.getCellAtCoordinate(j, i).setState(Cell.CellState.dead);
                } else {
                    if(numLiveNeighbors == 3)
                        this.grid.getCellAtCoordinate(j, i).setState(Cell.CellState.alive);
                }
            }
        }
    }
    
    /**
     * Runs a simple scenario of the Game of Life.
     * 
     * @param args Unused.
     */
    public static void main(String[] args) {
        
    	// Initializes grid with a very simple binary representation of the grid.
        Grid grid = new Grid(new int[][] {
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 1, 1, 1, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 }
        });
        
        System.out.println("Initial state:");
        GameOfLife game = new GameOfLife(grid);
        grid.display();
        
        System.out.println("\nUpdated state:");
        game.nextGeneration();
        grid.display();
    }
}
