/**
 * Write a description of BoardGeneration here.
 * 
 * This class is intended to create bitboards for each different piece in the chess board.
 * So there will be 12 bitboards created. 
 * Here the notations used are : 
 * King    - K  for white and k  for black
 * Queen   - Q  for white and q  for black
 * Bishop  - B  for white and b  for black
 * Knight  - N  for white and n  for black
 * Rook    - R  for white and r  for black
 * Pawn    - P  for white and p  for black
 * 
 * @author   AKSHAY J NAMBIAR 
 * @version  1.0
 * @date     12/9/2015
 */

import java.util.*;

public class BitboardGeneration {
    
    //  Variables to represent the 12 bitboards
    private static long K, Q, B, N, R, P, k, q, b, n, r, p;
    private static boolean debug = true;
    
    /**
     *  This function is the first function to be called and it initializes the chess board 
     *  to the standard arrangement.  
     * 
     *  @param void
     *  @return void
     */
    public static void initializeStandardChessBoard() {
        
        // Initialize the bitboards to O 
        K = Q = B = N = R = P = k = q = b = n = r = p = 0L;
        
        //  String to represent the standard chess board
        String zeroes="";
        for(int i=0;i<32;i++) zeroes+="0";
        
        String chessBoard = "rnbqkbnrpppppppp" + zeroes + "PPPPPPPPRNBQKBNR";

        //  Convert to bit boards 
        convertToBitboards(chessBoard);
    }
    
    /**
     * This function is used to initialize the bitboard variables according to the 
     * arrangement in the chessBoard string. This will be a 64 bit binary. 
     * 
     * @param chessBoard
     * @return void
     */
    public static void convertToBitboards(String chessBoard) {
        // Variable used to convert to Bitboards
        String Bits;
        
        for(int i=0;i<64;i++) {
        	
            Bits="";
            for(int j=0;j<64;j++){
                Bits+="0";
            }
            
            Bits = Bits.substring(i+1)+"1"+Bits.substring(0, i);
            
            switch(chessBoard.charAt(i)) {
                
                case 'K' : K += parseLongPositive(Bits); break;
                case 'Q' : Q += parseLongPositive(Bits); break;
                case 'B' : B += parseLongPositive(Bits); break;
                case 'N' : N += parseLongPositive(Bits); break;
                case 'R' : R += parseLongPositive(Bits); break;
                case 'P' : P += parseLongPositive(Bits); break;
                case 'k' : k += parseLongPositive(Bits); break;
                case 'q' : q += parseLongPositive(Bits); break;
                case 'b' : b += parseLongPositive(Bits); break;
                case 'n' : n += parseLongPositive(Bits); break;
                case 'r' : r += parseLongPositive(Bits); break;
                case 'p' : p += parseLongPositive(Bits); break;
                
            }
            
        }
        
        if(debug) {
                printChessBoard();
            }
    }
        
    /**
     * This function is used to convert the binary string to a long value 
     * without getting a negative value (in the case of s[0]=1)
     * 
     * @param s(String containing the bitboard representation)
     * @return long(The long value of the binary representation)
     */
    private static long parseLongPositive(String s) {
        if (s.charAt(0)=='0') {     //not going to be a negative number
            return Long.parseLong(s, 2);
        } else {
            return Long.parseLong("1"+s.substring(2), 2)*2;
        }
    }
    
    /** 
     *   Only for debug to print the chessboard.
     *    
     *   @param void
     *   @return void
     */
     public static void printChessBoard() {
         String chessBoard[][]=new String[8][8];
         for (int i=0;i<64;i++) {
             chessBoard[i/8][i%8]=" ";
         }
         for (int i=0;i<64;i++) {
             
             if (((P>>i)&1)==1) {chessBoard[i/8][i%8]="P";}
             if (((N>>i)&1)==1) {chessBoard[i/8][i%8]="N";}
             if (((B>>i)&1)==1) {chessBoard[i/8][i%8]="B";}
             if (((R>>i)&1)==1) {chessBoard[i/8][i%8]="R";}
             if (((Q>>i)&1)==1) {chessBoard[i/8][i%8]="Q";}
             if (((K>>i)&1)==1) {chessBoard[i/8][i%8]="K";}
             if (((p>>i)&1)==1) {chessBoard[i/8][i%8]="p";}
             if (((n>>i)&1)==1) {chessBoard[i/8][i%8]="n";}
             if (((b>>i)&1)==1) {chessBoard[i/8][i%8]="b";}
             if (((r>>i)&1)==1) {chessBoard[i/8][i%8]="r";}
             if (((q>>i)&1)==1) {chessBoard[i/8][i%8]="q";}
             if (((k>>i)&1)==1) {chessBoard[i/8][i%8]="k";}
         }
         for (int i=0;i<8;i++) {
             System.out.println(Arrays.toString(chessBoard[i]));
         }
     }
  
}
