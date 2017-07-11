public class SparseMatrix {

    private MatrixEntry [] array;
	private int numEntries;
    
    private final int m;
    private final int n;
    
    //ordered insert
    public SparseMatrix(String str){
    	str = str.replaceAll("\\s","");
    	String[] sArray = str.split(",");
    	this.numEntries = sArray.length;
		this.array = new MatrixEntry[this.numEntries]; 
		int maxRow=0, maxCol =0;
		
		//get size of array from string and ordered insert
    	for(int i=0;i<this.numEntries;i++){
    		int val = Integer.parseInt(sArray[i].substring(0, sArray[i].indexOf("r")));
    		int row = Integer.parseInt(sArray[i].substring(sArray[i].indexOf("r")+1,sArray[i].indexOf("c")));
    		int col = Integer.parseInt(sArray[i].substring(sArray[i].lastIndexOf("c") + 1 ));
    		
    		if(row>maxRow){
    			maxRow = row;
    		}
    		if(col>maxCol){
    			maxCol = col;
    		}
    		if(i==0){
    		this.array[i] = new MatrixEntry(val,row,col);
    		}
    		else{
    		int index = i;
    		while(index>0 && row<=this.array[index-1].getRow()){
    			if(row<this.array[index-1].getRow()){
    				this.array[index] = this.array[index-1];
    			}
    			else{
    				if(col<this.array[index-1].getCol()){
    					this.array[index] = this.array[index-1];
    				}
    				else{
    					break;
    				}
    			}
				index--;

    		}
			this.array[index] = new MatrixEntry(val,row,col);

    		}
    	}
    	this.m = maxRow;
    	this.n = maxCol;
    }
    
    //using one extra MAtrixEntry object and then compare
//   public SparseMatrix(String str){
//    	str = str.replaceAll("\\s","");
//    	String[] sArray = str.split(",");
//    	this.numEntries = sArray.length;
//    	MatrixEntry[] temp  = new MatrixEntry[this.numEntries];
//		this.array = new MatrixEntry[this.numEntries]; 
//		int maxRow=0, maxCol =0;
//		
//		//get size of array from string
//    	for(int i=0;i<this.numEntries;i++){
//    		int val = Integer.parseInt(sArray[i].substring(0, sArray[i].indexOf("r")));
//    		int row = Integer.parseInt(sArray[i].substring(sArray[i].indexOf("r")+1,sArray[i].indexOf("c")));
//    		int col = Integer.parseInt(sArray[i].substring(sArray[i].lastIndexOf("c") + 1 ));
//    		
//    		if(row>maxRow){
//    			maxRow = row;
//    		}
//    		if(col>maxCol){
//    			maxCol = col;
//    		}
//    		temp[i] = new MatrixEntry(val,row,col);
//    	}
//    	this.m = maxRow;
//    	this.n = maxCol;
//    	
//    	//sort the value and make the matrix entry
//        int counter =0;
//        for(int i=1;i<this.m+1;i++){
//            for(int j=1;j<this.n+1;j++){
//                for(MatrixEntry obj:temp){
//                    if (obj.getRow()==i && obj.getCol()==j){
//                        this.array[counter]=new MatrixEntry(obj.getValue(),obj.getRow(),obj.getCol());
//                        //System.out.println(obj.getRow()+"-"+obj.getCol());
//                        counter++;
//                    }
//                }
//            }
//        }	
//    }
//    
    public SparseMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        
        this.array = new MatrixEntry[4];
    }
    public SparseMatrix(int m, int n, String type){
    	this.m = m;
    	this.n = n;
    	int entries=0;
    	switch(type){
    		case "TypeC":for(int i=1;i<this.m+1;i++){
    			for(int j =1;j<this.n+1;j++){
    				if((i+j)%2==0){
				    	entries++;
				    }
    			}
    		}	
    		break;
    		case "TypeD":for(int i=1;i<this.m+1;i++){
    			for(int j =1;j<this.n+1;j++){
    				if((i*j)%4==0){
	    				entries++;
	    			}
    			}
    		}	
    		break;
    		case "TypeE":for(int i=1;i<this.m+1;i++){
    				if((i%10)==0){
	    				entries = entries+this.n;
	    			}
    		}	
    		break;
    		case "TypeF":for(int i=1;i<this.m+1;i++){
    				if(i%5==0){
	    				entries = entries+this.n;
	    			}		
    		}	
    		break;
    		case "TypeG":for(int i=1;i<this.m+1;i++){
    			int increment = 1;
    			if(i%2!=0){
    				increment = 2;
    			}
    			for(int j =1; j<=i/2;j=j+increment){
    				if(i%j==0){
	    			entries++;
    				}
	    			
    			}
    			entries++;

    		}	
    		break;
    	}
    	
    	//System.out.println("NumEntries-"+entries);
    	MatrixEntry[] temp = new MatrixEntry[entries];
    	int counter = 0;
    	switch(type){
    		case "TypeC":for(int i=1;i<this.m+1;i++){
        		for(int j=1;j<this.n+1;j++){
        			if((i+j)%2==0){
        				temp[counter] = new MatrixEntry(i*j,i,j);
        				counter++;
        			}
        		}
        	}
    		break;
    		case "TypeD":for(int i=1;i<this.m+1;i++){
        		for(int j=1;j<this.n+1;j++){
        			if((i*j)%4==0){
        				temp[counter] = new MatrixEntry(i+j,i,j);
        				counter++;	
        			}
        		}
        	}
    		break;
    		case "TypeE":for(int i=1;i<this.m+1;i++){
        		for(int j=1;j<this.n+1;j++){
        			if((i%10)==0){
        				temp[counter] = new MatrixEntry(i+(2*j),i,j);
        				counter++;
        			}
        		}
        	}
    		break;
    		case "TypeF":for(int i=1;i<this.m+1;i++){
        		for(int j=1;j<this.n+1;j++){
        			if((i%5)==0){
        				temp[counter] = new MatrixEntry(5*i,i,j);
        				counter++;
        			}
        		}
        	}
    		break;
    		case "TypeG":for(int i=1;i<this.m+1;i++){
    			int increment = 1;
    			if(i%2!=0){
    				increment = 2;
    			}
        		for(int j=1;j<=i/2;j=j+increment){
        			if(i%j==0){
        				temp[counter] = new MatrixEntry(i+j,i,j);
        				counter++;	
        			}
        		}
        		temp[counter] = new MatrixEntry(i+i,i,i);
        		counter++;
        	}
    		break;
    	}
    	
    	this.numEntries = temp.length;
    	this.array = temp;
    }
    public void print() {
    	int rowCount = this.m;
    	int colCount = this.n;
    	StringBuilder sb = new StringBuilder();
    	if(this.numEntries==-1){
    		System.out.println("-");
    	}
    	else if(this.numEntries!=0){
    		printMatrix(1,rowCount,1,colCount,sb); 
    	}
    	else{
    		print0Matrix(1,rowCount,1,colCount,sb);
    	}
        System.out.println(sb.toString());
    }
    
    public void printMatrix(int startR,int endR,int startC,int endC, StringBuilder sb){
    	int counter = 0;
    	boolean checkGreater = false;
    	for(int i=startR;i<=endR;i++){
            sb.append("\n");
            if(i==3&&endR>6){
        		sb.append("...\n");
        		i=endR-1;
                checkGreater = true;
        	}
	            for(int j=startC;j<=endC;j++){
	            	if(j==3&&endC>6){
	            		if(i==1){
	            			sb.append("...\t");
	            		}
	            		else{
		            		sb.append("\t");
		            	}
	            		j=endC-1;
	            		checkGreater = true;
	            	}
	            	boolean found = false;
	            	if(!checkGreater){
		            	if(counter<this.array.length){
		            		if(this.array[counter].getRow()==i && this.array[counter].getCol()==j){
		            			 sb.append(this.array[counter].getValue()+"\t");
			                    found = true;
			                    counter++;
		            		}
		            	}
	            	}
	            	else{
		                for(MatrixEntry obj:this.array){
		                    if (obj.getRow()==i && obj.getCol()==j){
		                        sb.append(obj.getValue()+"\t");
		                    	found = true;
		                        break;
		                    }
		                }
	            	}
	                if(!found){
	                	sb.append("0\t");
	                }
	            }        	
        }	
        
    }
    public void print0Matrix(int startR,int endR,int startC,int endC, StringBuilder sb){
    	for(int i=startR;i<=endR;i++){
            sb.append("\n");
            if(i==3&&endR>6){
        		sb.append("...\n");
        		i=endR-1;
        	}
	            for(int j=startC;j<=endC;j++){
	            	if(j==3&&endC>6){
	            		if(i==1){
	            			sb.append("...\t");
	            		}
	            		else{
		            		sb.append("\t");
		            	}
	            		j=endC-1;
	            	}
	                	sb.append("0\t");
	                
	            }        	
        }	

    }
    public boolean equals(SparseMatrix m) {
        boolean equal = false;
        //check if array sizes are equal
        if(this.m!=m.m || this.n!=m.n){
        	return false;
        }
        //check for non-zero values
        if(this.numEntries!=m.numEntries){
        	return false;
        }
        //check for values
        for(int i=0;i<this.numEntries;i++){
            if (this.array[i].getRow()!=m.array[i].getRow() || this.array[i].getCol()!=m.array[i].getCol()||this.array[i].getValue()!=m.array[i].getValue()){
                break;
            }
            else{
            	equal = true;
            }
        }
        return equal;
    }
    
    public SparseMatrix scalarMultiply(int c) {
       MatrixEntry[] temp  = new MatrixEntry[this.numEntries];
       for(int i=0;i<this.numEntries;i++){
    	   int val = this.array[i].getValue()*c;
    	   temp[i] = new MatrixEntry(val,this.array[i].getRow(),this.array[i].getCol());
       }
       SparseMatrix result = new SparseMatrix(this.m, this.n);
       result.array = temp;
       result.numEntries = this.numEntries;
       //System.out.println(result.array.length);
       return result; 
    }
    
    public SparseMatrix add(SparseMatrix m) {
        SparseMatrix result = new SparseMatrix(this.m, this.n);
        MatrixEntry[] temp  = new MatrixEntry[this.numEntries*m.numEntries];
        int count1 = 0;
        int count2 = 0,count = 0;

    	if(this.m == m.m && this.n == m.n){
	        for(int i =1;i<this.m+1;i++){
	        	for(int j=1;j<this.n+1;j++){
	        		int val1 = 0, val2 = 0, res=0;
        			//System.out.println(this.array.length+"-"+count1);
	        		if(this.array[count1].getRow()==i && this.array[count1].getCol()==j){
	        			val1 = this.array[count1].getValue();
	        			//System.out.println("val1-"+val1);
	        			if(count1<this.array.length-1){
	        				count1++;
	        			}
	        		}
	        		
	        		if(m.array[count2].getRow()==i && m.array[count2].getCol()==j){
	        			val2 = m.array[count2].getValue();
	        			//System.out.println("val1-"+val1);
	        			if(count2<m.array.length-1){
	        				count2++;
	        			}
	        		}
	        		res = val1 + val2;
	        		if(res!=0){
	        			temp[count] = new MatrixEntry(res,i,j);
	        			count++;
	        		}
	        	}
	        }
	        MatrixEntry[] temp_res  = new MatrixEntry[count];
	        for(int i =0;i<count;i++){
	        	temp_res[i] = temp[i];
	        }

	        result.array = temp_res;
	        result.numEntries = count;

    	}
    	else{
    		result.numEntries = 0;
    		result.array = new MatrixEntry[result.numEntries];
    		System.out.println("Two Matrices are not of equal size");
    	}

        return result;
    	
    }
    
    
    public SparseMatrix subtract(SparseMatrix m) {
    	SparseMatrix result = new SparseMatrix(this.m, this.n);
        MatrixEntry[] temp  = new MatrixEntry[this.numEntries*m.numEntries];
        int count1 = 0;
        int count2 = 0,count = 0;

    	if(this.m == m.m && this.n == m.n){
	        for(int i =1;i<this.m+1;i++){
	        	for(int j=1;j<this.n+1;j++){
	        		int val1 = 0, val2 = 0, res=0;
        			//System.out.println(this.array.length+"-"+count1);
	        		if(this.array[count1].getRow()==i && this.array[count1].getCol()==j){
	        			val1 = this.array[count1].getValue();
	        			//System.out.println("val1-"+val1);
	        			if(count1<this.array.length-1){
	        				count1++;
	        			}
	        		}
	        		
	        		if(m.array[count2].getRow()==i && m.array[count2].getCol()==j){
	        			val2 = m.array[count2].getValue();
	        			//System.out.println("val1-"+val1);
	        			if(count2<m.array.length-1){
	        				count2++;
	        			}
	        		}
	        		res = val1 - val2;
	        		if(res!=0){
	        			temp[count] = new MatrixEntry(res,i,j);
	        			count++;
	        		}
	        	}
	        }
	        MatrixEntry[] temp_res  = new MatrixEntry[count];
	        for(int i =0;i<count;i++){
	        	temp_res[i] = temp[i];
	        }

	        result.array = temp_res;
	        result.numEntries = count;
    	}
    	else{
    		result.numEntries = 0;
    		result.array = new MatrixEntry[result.numEntries];
    		System.out.println("Two Matrices are not of equal size");
    	}

        return result;
        
    }
    
    public int[] initialiseRow1(){
    	int[] R1 = new int[this.m];
    	int counter = 0;
    	for(MatrixEntry obj:this.array){
    		boolean present = false;
    		for(int i=0;i<R1.length;i++){
    			if(R1[i]==obj.getRow()){
    				present = true;
    				break;
    			}
    		}
    		if(!present){
    			R1[counter] = obj.getRow();
    			counter++;
    		}
    	}
    	int[] finalR = new int[counter];
    	for(int i=0;i<counter;i++){
    		finalR[i] = R1[i];
    	}
		return finalR;
    }
    public int[] initialiseCol2(SparseMatrix m){
    	int[] C1 = new int[m.n];
    	int counter = 0;
    	for(MatrixEntry obj:m.array){
    		boolean present = false;
    		for(int i=0;i<C1.length;i++){
    			if(C1[i]==obj.getCol()){
    				present = true;
    				break;
    			}
    		}
    		if(!present){
    	    	int index = counter;   		
    	    	while(index>0 && obj.getCol()<=C1[index-1]){
    	    		if(obj.getCol()<C1[index-1]){
    	    			C1[index] = C1[index-1];
    	    		}
    				index--;
    	    	}
    			C1[index] = obj.getCol();
    			counter++;
    		}
    	}
    	int[] finalC = new int[counter];
    	for(int i=0;i<counter;i++){
    		finalC[i] = C1[i];
    	}
    	return finalC;
    }
    public SparseMatrix multiply(SparseMatrix m) {
    	int col1 = this.n;
    	int row2 = m.m;
    	SparseMatrix result = new SparseMatrix(this.m, m.n);
        MatrixEntry[] temp  = new MatrixEntry[this.numEntries*m.numEntries];
    	if(col1!=row2) {
    		System.out.println("Two Matrices cannot be multiplied");
    		result.numEntries = -1;
    		//result.array = new MatrixEntry[result.numEntries];
    		return result;
    	}
    	int[] R1 = initialiseRow1();
    	int[] C1 = initialiseCol2(this);
    	int[] C2 = initialiseCol2(m);
        int index = 0;
        //System.out.println("length"+R1.length+"-"+C1.length+"-"+C2.length);
        for(int i=0;i<R1.length;i++){
        	if(R1[i]!=0){
        	for(int j =0;j<C2.length;j++){
    			int sum = 0;
        		for(int k =0;k<C1.length;k++){
        			int valA = 0, valB = 0;
        			for(MatrixEntry obj:this.array){
	                    if (obj.getRow()==R1[i] && obj.getCol()==C1[k]){
	                       valA = obj.getValue(); 
	                       break;
	                    }
	                }
        			for(MatrixEntry obj:m.array){
	                    if (obj.getRow()==C1[k] && obj.getCol()==C2[j]){
	                       valB = obj.getValue(); 
	                       break;
	                    }
	                }
        			sum = sum + valA*valB;
        			}
        		if(sum!=0){
        			temp[index] = new MatrixEntry(sum,R1[i],C2[j]);
        			index++;
        		}
        	}}
        }
        MatrixEntry[] temp_res  = new MatrixEntry[index];
        for(int i =0;i<index;i++){
        	temp_res[i] = temp[i];
        }
        result.array = temp_res;
        result.numEntries = index;
        return result;
    }
	
    
    public SparseMatrix power(int p){
    	SparseMatrix result = new SparseMatrix(this.m,this.n);
    	if(this.m!=this.n){
			System.out.println("MAtrix needs to be a square matrix");
			result.numEntries = -1;
    		//result.array = new MatrixEntry[result.numEntries];
    		return result;
			
		}
    	if(p==1){
    		return this;
    	}
    	result = this.power(p/2);
    	if(p%2==0){
    		SparseMatrix temp = result.multiply(result);
    		return temp;
    	}
    	else{
    		SparseMatrix temp = this.multiply(result);
    		return temp.multiply(result);
    				
    	}
    }
    public SparseMatrix transpose() {
    	SparseMatrix result = new SparseMatrix(this.n, this.m);
        MatrixEntry[] temp  = new MatrixEntry[this.numEntries];
        int maxRow = 0,maxCol=0;
    	for(int i=0;i<this.numEntries;i++){
    		int val = this.array[i].getValue();
    		int row = this.array[i].getCol();
    		int col = this.array[i].getRow();
    		
    		if(row>maxRow){
    			maxRow = row;
    		}
    		if(col>maxCol){
    			maxCol = col;
    		}
    		if(i==0){
    		temp[i] = new MatrixEntry(val,row,col);
    		}
    		else{
    		int index = i;
    		while(index>0 && row<=temp[index-1].getRow()){
    			if(row<temp[index-1].getRow()){
    				temp[index] = temp[index-1];
    			}
    			else{
    				if(col<temp[index-1].getCol()){
    					temp[index] = temp[index-1];
    				}
    				else{
    					break;
    				}
    			}
				index--;

    		}
			temp[index] = new MatrixEntry(val,row,col);

    		}
    	}
    	
        result.array = temp;
        result.numEntries = this.numEntries;
        
    	return result;
    }
	
}
