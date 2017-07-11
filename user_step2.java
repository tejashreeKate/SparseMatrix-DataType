
public class user_step2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println("\n-----------------");
		System.out.println("Initialising sparse matrices A-G");
		// TODO Auto-generated method stub
		String input1 ="-5r4c4, 5r1c4, 2r2c2, 5r3c1, -3r3c2, 6r4c2, -7r2c3, 3r1c1";
		String input2 ="1r1c1, 1r2c2, 1r4c1, 1r3c3, 1r4c4, 1r1c5, 1r2c6";

		//initialise matrices
		SparseMatrix matrixA = new SparseMatrix(input1);
		SparseMatrix matrixB = new SparseMatrix(input2);
		SparseMatrix matrixC = new SparseMatrix(5,6,"TypeC");
		SparseMatrix matrixD = new SparseMatrix(6,5,"TypeD");
		SparseMatrix matrixE = new SparseMatrix(200,200,"TypeE");
		SparseMatrix matrixF = new SparseMatrix(200,1,"TypeF");
	
		System.out.println("\n*********STEP1*******");
		System.out.println("Sparse Matrix A is:");
		matrixA.print();
		System.out.println("Sparse Matrix B is:");
		matrixB.print();
		System.out.println("Sparse Matrix C is:");
		matrixC.print();
		System.out.println("Sparse Matrix D is:");
		matrixD.print();
		System.out.println("Sparse Matrix E is:");
		matrixE.print();	
		System.out.println("Sparse Matrix F is:");
		matrixF.print();
		
		System.out.println("\n-----------------");
//		//scalar multiply
		SparseMatrix scalarA = matrixA.scalarMultiply(5);
		System.out.println("Matrix A multiplied by 5 is:");
		scalarA.print();
		SparseMatrix scalarB = matrixB.scalarMultiply(5);
		System.out.println("Matrix B multiplied by 5 is:");
		scalarB.print();
		SparseMatrix scalarC = matrixC.scalarMultiply(5);
		System.out.println("Matrix C multiplied by 5 is:");
		scalarC.print();
		SparseMatrix scalarD = matrixD.scalarMultiply(5);
		System.out.println("Matrix D multiplied by 5 is:");
		scalarD.print();
		SparseMatrix scalarE = matrixE.scalarMultiply(5);
		System.out.println("Matrix E multiplied by 5 is:");
		scalarE.print();
		SparseMatrix scalarF = matrixF.scalarMultiply(5);
		System.out.println("Matrix F multiplied by 5 is:");
		scalarF.print();
		System.out.println("\n-----------------");
//
		//equals method
		outputCompare('A','A',matrixA.equals(matrixA));
		outputCompare('A','B',matrixA.equals(matrixB));
		outputCompare('A','C',matrixA.equals(matrixC));
		outputCompare('A','D',matrixA.equals(matrixD));
		outputCompare('A','E',matrixA.equals(matrixE));
		outputCompare('A','F',matrixA.equals(matrixF));
		
		outputCompare('B','B',matrixB.equals(matrixB));
		outputCompare('B','C',matrixB.equals(matrixC));
		outputCompare('B','D',matrixB.equals(matrixD));
		outputCompare('B','E',matrixB.equals(matrixE));
		outputCompare('B','F',matrixB.equals(matrixF));
		
		outputCompare('C','C',matrixC.equals(matrixC));
		outputCompare('C','D',matrixC.equals(matrixD));
		outputCompare('C','E',matrixC.equals(matrixE));
		outputCompare('C','F',matrixC.equals(matrixF));
		
		outputCompare('D','D',matrixD.equals(matrixD));
		outputCompare('D','E',matrixD.equals(matrixE));
		outputCompare('D','F',matrixD.equals(matrixF));
		
		outputCompare('E','E',matrixE.equals(matrixE));
		outputCompare('E','F',matrixE.equals(matrixF));
		
		outputCompare('F','F',matrixF.equals(matrixF));
		
		System.out.println("\n*********STEP2*******");
		System.out.println("\n--------------Test Case 1---");
		System.out.println("A + A = ");
		long s1 = System.nanoTime();
		SparseMatrix addA = matrixA.add(matrixA);
		addA.print();
		long e1 = System.nanoTime();
		long t1 = e1 - s1;
		System.out.println("time-"+t1+" ns");
		
		System.out.println("B + B = ");
		long s2 = System.nanoTime();
		SparseMatrix addB = matrixB.add(matrixB);
		addB.print();
		long e2 = System.nanoTime();
		long t2 = e2 - s2;
		System.out.println("time-"+t2+" ns");
		
		System.out.println("C + C = ");
		long s3 = System.nanoTime();
		SparseMatrix addC = matrixC.add(matrixC);
		addC.print();
		long e3 = System.nanoTime();
		long t3 = e3 - s3;
		System.out.println("time-"+t3+" ns");
		
		System.out.println("D + D = ");
		long s4 = System.nanoTime();
		SparseMatrix addD = matrixD.add(matrixD);
		addD.print();
		long e4 = System.nanoTime();
		long t4 = e4 - s4;
		System.out.println("time-"+t4+" ns");
		
		System.out.println("E + E = ");
		long s5 = System.nanoTime();
		SparseMatrix addE = matrixE.add(matrixE);
		addE.print();
		long e5 = System.nanoTime();
		long t5 = e5 - s5;
		System.out.println("time-"+t5+" ns");
		
		System.out.println("F + F = ");
		long s6 = System.nanoTime();
		SparseMatrix addF = matrixF.add(matrixF);
		addF.print();
		long e6 = System.nanoTime();
		long t6 = e6 - s6;
		System.out.println("time-"+t6+" ns");

		System.out.println("\n--------------Test Case 2---");
		System.out.println("A - A = ");
		long s7 = System.nanoTime();
		SparseMatrix subtractA = matrixA.subtract(matrixA);
		subtractA.print();
		long e7 = System.nanoTime();
		long t7 = e7 - s7;
		System.out.println("time-"+t7+" ns");
		
		System.out.println("B - B = ");
		long s8 = System.nanoTime();
		SparseMatrix subtractB = matrixB.subtract(matrixB);
		subtractB.print();
		long e8 = System.nanoTime();
		long t8 = e8 - s8;
		System.out.println("time-"+t8+" ns");

		System.out.println("C - C = ");
		long s9 = System.nanoTime();
		SparseMatrix subtractC = matrixC.subtract(matrixC);
		subtractC.print();
		long e9 = System.nanoTime();
		long t9 = e9 - s9;
		System.out.println("time-"+t9+" ns");

		System.out.println("D - D = ");
		long s10 = System.nanoTime();
		SparseMatrix subtractD = matrixD.subtract(matrixD);
		subtractD.print();
		long e10 = System.nanoTime();
		long t10 = e10 - s10;
		System.out.println("time-"+t10+" ns");

		System.out.println("E - E = ");
		long s11 = System.nanoTime();
		SparseMatrix subtractE = matrixE.subtract(matrixE);
		subtractE.print();
		long e11 = System.nanoTime();
		long t11 = e11 - s11;
		System.out.println("time-"+t11+" ns");

		
		System.out.println("F - F = ");
		long s12 = System.nanoTime();
		SparseMatrix subtractF = matrixF.subtract(matrixF);
		subtractF.print();
		long e12 = System.nanoTime();
		long t12 = e12 - s12;
		System.out.println("time-"+t12+" ns");

		System.out.println("\n--------------Test Case 3---");
		System.out.println("5A - A = ");
		long s13 = System.nanoTime();
		//SparseMatrix scalarA = matrixA.scalarMultiply(5);
		SparseMatrix res3A = scalarA.subtract(matrixA);
		res3A.print();
		long e13 = System.nanoTime();
		long t13 = e13 - s13;
		System.out.println("time-"+t13+" ns");

		
		System.out.println("5B - B = ");
		long s14 = System.nanoTime();
		//SparseMatrix scalarB = matrixB.scalarMultiply(5);
		SparseMatrix res3B = scalarB.subtract(matrixB);
		res3B.print();
		long e14 = System.nanoTime();
		long t14 = e14 - s14;
		System.out.println("time-"+t14+" ns");
		
		System.out.println("5C - C = ");
		long s15 = System.nanoTime();
		//SparseMatrix scalarC = matrixC.scalarMultiply(5);
		SparseMatrix res3C = scalarC.subtract(matrixC);
		res3C.print();
		long e15 = System.nanoTime();
		long t15 = e15 - s15;
		System.out.println("time-"+t15+" ns");

		System.out.println("5D - D = ");
		long s16 = System.nanoTime();
		//SparseMatrix scalarD = matrixD.scalarMultiply(5);
		SparseMatrix res3D = scalarD.subtract(matrixD);
		res3D.print();
		long e16 = System.nanoTime();
		long t16 = e16 - s16;
		System.out.println("time-"+t16+" ns");

		System.out.println("5E - E = ");
		long s17 = System.nanoTime();
		//SparseMatrix scalarE = matrixE.scalarMultiply(5);
		SparseMatrix res3E = scalarE.subtract(matrixE);
		res3E.print();
		long e17 = System.nanoTime();
		long t17 = e17 - s17;
		System.out.println("time-"+t17+" ns");

		System.out.println("5F - F = ");
		long s18 = System.nanoTime();
		//SparseMatrix scalarF = matrixF.scalarMultiply(5);
		SparseMatrix res3F = scalarF.subtract(matrixF);
		res3F.print();
		long e18 = System.nanoTime();
		long t18 = e18 - s18;
		System.out.println("time-"+t18+" ns");

		System.out.println("\n--------------Test Case 4---");
		System.out.println("Multiply B with transpose C =");
		long s19 = System.nanoTime();
		SparseMatrix transposeC1 = matrixC.transpose();
		SparseMatrix res41 = matrixB.multiply(transposeC1);
		res41.print();
		long e19 = System.nanoTime();
		long t19 = e19 - s19;
		System.out.println("time-"+t19+" ns");

		System.out.println("Multiply matrix C with matrix D =");
		long s20 = System.nanoTime();
		SparseMatrix res42 = matrixC.multiply(matrixD);
		res42.print();
		long e20 = System.nanoTime();
		long t20 = e20 - s20;
		System.out.println("time-"+t20+" ns");

		System.out.println("Multiply matrix D with matrix C =");
		long s21 = System.nanoTime();
		SparseMatrix res43 = matrixD.multiply(matrixC);
		res43.print();
		long e21 = System.nanoTime();
		long t21 = e21 - s21;
		System.out.println("time-"+t21+" ns");

		System.out.println("Multiply matrix E with matrix F =");
		long s22 = System.nanoTime();
		SparseMatrix res44 = matrixE.multiply(matrixF);
		res44.print();
		long e22 = System.nanoTime();
		long t22 = e22 - s22;
		System.out.println("time-"+t22+" ns");

		System.out.println("\n--------------Test Case 5---");
		System.out.println("Multiply A*A =");
		long s23 = System.nanoTime();
		SparseMatrix multiplyA = matrixA.multiply(matrixA);
		multiplyA.print();
		long e23 = System.nanoTime();
		long t23 = e23 - s23;
		System.out.println("time-"+t23+" ns");

		System.out.println("Multiply E*E =");
		long s24 = System.nanoTime();
		SparseMatrix multiplyE = matrixE.multiply(matrixE);
		multiplyE.print();
		long e24 = System.nanoTime();
		long t24 = e24 - s24;
		System.out.println("time-"+t24+" ns");

		System.out.println("\n--------------Test Case 6---");
		System.out.println("A^5 =");
		long s25 = System.nanoTime();
		SparseMatrix powerA1 = matrixA.power(5);
		powerA1.print();
		long e25 = System.nanoTime();
		long t25 = e25 - s25;
		System.out.println("time-"+t25+" ns");

		System.out.println("A^25 =");
		long s26 = System.nanoTime();
		SparseMatrix powerA2 = matrixA.power(25);
		powerA2.print();
		long e26 = System.nanoTime();
		long t26 = e26 - s26;
		System.out.println("time-"+t26+" ns");

		System.out.println("B^5 =");
		long s27 = System.nanoTime();
		SparseMatrix powerB1 = matrixB.power(5);
		powerB1.print();
		long e27 = System.nanoTime();
		long t27 = e27 - s27;
		System.out.println("time-"+t27+" ns");

		System.out.println("B^25 =");
		long s28 = System.nanoTime();
		SparseMatrix powerB2 = matrixB.power(25);
		powerB2.print();
		long e28 = System.nanoTime();
		long t28 = e28 - s28;
		System.out.println("time-"+t28+" ns");
		
		System.out.println("C^5 =");
		long s29 = System.nanoTime();
		SparseMatrix powerC1 = matrixC.power(5);
		powerC1.print();
		long e29 = System.nanoTime();
		long t29 = e29 - s29;
		System.out.println("time-"+t29+" ns");

		System.out.println("C^25 =");
		long s30 = System.nanoTime();
		SparseMatrix powerC2 = matrixC.power(25);
		powerC2.print();
		long e30 = System.nanoTime();
		long t30 = e30 - s30;
		System.out.println("time-"+t30+" ns");

		System.out.println("D^5 =");
		long s31 = System.nanoTime();
		SparseMatrix powerD1 = matrixD.power(5);
		powerD1.print();
		long e31 = System.nanoTime();
		long t31 = e31 - s31;
		System.out.println("time-"+t31+" ns");

		System.out.println("D^25 =");
		long s32 = System.nanoTime();
		SparseMatrix powerD2 = matrixD.power(25);
		powerD2.print();
		long e32 = System.nanoTime();
		long t32 = e32 - s32;
		System.out.println("time-"+t32+" ns");

		System.out.println("E^5 =");
		long s33 = System.nanoTime();
		SparseMatrix powerE1 = matrixE.power(5);
		powerE1.print();
		long e33 = System.nanoTime();
		long t33 = e33 - s33;
		System.out.println("time-"+t33+" ns");

		System.out.println("E^25 =");
		long s34 = System.nanoTime();
		SparseMatrix powerE2 = matrixE.power(25);
		powerE2.print();
		long e34 = System.nanoTime();
		long t34 = e34 - s34;
		System.out.println("time-"+t34+" ns");

		System.out.println("F^5 =");
		long s35 = System.nanoTime();
		SparseMatrix powerF1 = matrixF.power(5);
		powerF1.print();
		long e35 = System.nanoTime();
		long t35 = e35 - s35;
		System.out.println("time-"+t35+" ns");

		System.out.println("F^25 =");
		long s36 = System.nanoTime();
		SparseMatrix powerF2 = matrixF.power(25);
		powerF2.print();
		long e36 = System.nanoTime();
		long t36 = e36 - s36;
		System.out.println("time-"+t36+" ns");

		System.out.println("\n--------------Test Case 7---");
		System.out.println("Transpose of matrix A =");
		long s37 = System.nanoTime();
		SparseMatrix transposeA = matrixA.transpose();
		transposeA.print();
		long e37 = System.nanoTime();
		long t37 = e37 - s37;
		System.out.println("time-"+t37+" ns");

		System.out.println("Transpose of matrix B =");
		long s38 = System.nanoTime();
		SparseMatrix transposeB = matrixB.transpose();
		transposeB.print();
		long e38 = System.nanoTime();
		long t38 = e38 - s38;
		System.out.println("time-"+t38+" ns");

		System.out.println("Transpose of matrix C =");
		long s39 = System.nanoTime();
		SparseMatrix transposeC = matrixC.transpose();
		transposeC.print();
		long e39 = System.nanoTime();
		long t39 = e39 - s39;
		System.out.println("time-"+t39+" ns");
		
		System.out.println("Transpose of matrix D =");
		long s40 = System.nanoTime();
		SparseMatrix transposeD = matrixD.transpose();
		transposeD.print();
		long e40 = System.nanoTime();
		long t40 = e40 - s40;
		System.out.println("time-"+t40+" ns");

		
		System.out.println("Transpose of matrix E =");
		long s41 = System.nanoTime();
		SparseMatrix transposeE = matrixE.transpose();
		transposeE.print();
		long e41 = System.nanoTime();
		long t41 = e41 - s41;
		System.out.println("time-"+t41+" ns");

		System.out.println("Transpose of matrix F =");
		long s42 = System.nanoTime();
		SparseMatrix transposeF = matrixF.transpose();
		transposeF.print();
		long e42 = System.nanoTime();
		long t42 = e42 - s42;
		System.out.println("time-"+t42+" ns");

		System.out.println("\n--------------Test Case 8---");
		System.out.println("A*(TransposeA) =");
		long s43 = System.nanoTime();
		SparseMatrix res8A1 = matrixA.multiply(transposeA);
		res8A1.print();
		long e43 = System.nanoTime();
		long t43 = e43 - s43;
		System.out.println("time-"+t43+" ns");

		System.out.println("(TransposeA)*A =");
		long s44 = System.nanoTime();
		SparseMatrix res8A2 = transposeA.multiply(matrixA);
		res8A2.print();
		long e44 = System.nanoTime();
		long t44 = e44 - s44;
		System.out.println("time-"+t44+" ns");

		System.out.println("B*(TransposeB) =");
		long s45 = System.nanoTime();
		SparseMatrix res8B1 = matrixB.multiply(transposeB);
		res8B1.print();
		long e45 = System.nanoTime();
		long t45 = e45 - s45;
		System.out.println("time-"+t45+" ns");

		System.out.println("(TransposeB)*B =");
		long s46 = System.nanoTime();
		SparseMatrix res8B2 = transposeB.multiply(matrixB);
		res8B2.print();
		long e46 = System.nanoTime();
		long t46 = e46 - s46;
		System.out.println("time-"+t46+" ns");

		System.out.println("C*(TransposeC) =");
		long s47 = System.nanoTime();
		SparseMatrix res8C1 = matrixC.multiply(transposeC);
		res8C1.print();
		long e47 = System.nanoTime();
		long t47 = e47 - s47;
		System.out.println("time-"+t47+" ns");

		System.out.println("(TransposeC)*C =");
		long s48 = System.nanoTime();
		SparseMatrix res8C2 = transposeC.multiply(matrixC);
		res8C2.print();
		long e48 = System.nanoTime();
		long t48 = e48 - s48;
		System.out.println("time-"+t48+" ns");

		System.out.println("D*(TransposeD) =");
		long s49 = System.nanoTime();
		SparseMatrix res8D1 = matrixD.multiply(transposeD);
		res8D1.print();
		long e49 = System.nanoTime();
		long t49 = e49 - s49;
		System.out.println("time-"+t49+" ns");

		System.out.println("(TransposeD)*D =");
		long s50 = System.nanoTime();
		SparseMatrix res8D2 = transposeD.multiply(matrixD);
		res8D2.print();
		long e50 = System.nanoTime();
		long t50 = e50 - s50;
		System.out.println("time-"+t50+" ns");

		System.out.println("E*(TransposeE) =");
		long s51 = System.nanoTime();
		SparseMatrix res8E1 = matrixE.multiply(transposeE);
		res8E1.print();
		long e51 = System.nanoTime();
		long t51 = e51 - s51;
		System.out.println("time-"+t51+" ns");
		
		System.out.println("(TransposeE)*E =");
		long s52 = System.nanoTime();
		SparseMatrix res8E2 = transposeE.multiply(matrixE);
		res8E2.print();
		long e52 = System.nanoTime();
		long t52 = e52 - s52;
		System.out.println("time-"+t52+" ns");

		System.out.println("F*(TransposeF) =");
		long s53 = System.nanoTime();
		SparseMatrix res8F1 = matrixF.multiply(transposeF);
		res8F1.print();
		long e53 = System.nanoTime();
		long t53 = e53 - s53;
		System.out.println("time-"+t53+" ns");

		System.out.println("(TransposeF)*F =");
		long s54 = System.nanoTime();
		SparseMatrix res8F2 = transposeF.multiply(matrixF);
		res8F2.print();
		long e54 = System.nanoTime();
		long t54 = e54 - s54;
		System.out.println("time-"+t54+" ns");

		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time-"+totalTime+" ms");
	}
	public static void outputCompare(char matrix1,char matrix2, boolean res){
		if(res){
			System.out.println("Matrices "+matrix1+" and "+matrix2+" are equal");
		}
		else{
			System.out.println("Matrices "+matrix1+" and "+matrix2+" are not equal");
		}
	}


}
