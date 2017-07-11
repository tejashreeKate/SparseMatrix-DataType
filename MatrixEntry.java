public class MatrixEntry {
    
    private final int value;
    
    private final int row;
    private final int col;
    
    public MatrixEntry(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col =  col;
    }

    // TODO: Getters and setters?
    int getValue(){
    	return this.value;
    }
    int getRow(){
    	return this.row;
    }
    int getCol(){
    	return this.col;
    }
    
}
