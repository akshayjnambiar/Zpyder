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
    
    public static void initializeStandardChessBoard() {
        
        // Initialize the bitboards to O 
        K = Q = B = N = R = P = k = q = b = n = r = p = 0L;
        
        //  String to represent the standard chessboard
        String zeroes="";
        for(int i=0;i<32;i++) zeroes+="0";
        
        String chessBoard = "rnbqkbnrpppppppp" + zeroes + "PPPPPPPPRNBQKBNR";
        
        
        
        //  Convert to bit boards 
        convertToBitboards(chessBoard);
    }
    
    public static void convertToBitboards(String chessBoard) {
        // Variable used to convert to Bitboards
        String Bits;
        
        for(int i=0;i<64;i++) {
            
            if(chessBoard.charAt(i) == ' ') continue;
            System.out.println(chessBoard.charAt(i));
            
            Bits="";
            for(int j=0;j<64;j++){
                Bits+="0";
            }
            
            Bits = Bits.substring(i+1)+"1"+Bits.substring(0, i);
            
            switch(chessBoard.charAt(i)) {
                
                case 'K' : K += parseLong(Bits); break;
                case 'Q' : Q += parseLong(Bits); break;
                case 'B' : B += parseLong(Bits); break;
                case 'N' : N += parseLong(Bits); break;
                case 'R' : R += parseLong(Bits); break;
                case 'P' : P += parseLong(Bits); break;
                case 'k' : k += parseLong(Bits); break;
                case 'q' : q += parseLong(Bits); break;
                case 'b' : b += parseLong(Bits); break;
                case 'n' : n += parseLong(Bits); break;
                case 'r' : r += parseLong(Bits); break;
                case 'p' : p += parseLong(Bits); break;
                
            }
            
        }
        
        if(debug) {
                printChessBoard();
            }
    }
        
    private static long parseLong(String s) {
        if (s.charAt(0)=='0') {//not going to be a negative number
            return Long.parseLong(s, 2);
        } else {
            return Long.parseLong("1"+s.substring(2), 2)*2;
        }
    }
    
    /* 
     *   Only for debug to print the chessboard. 
     * 
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
     
     public static void main(String args) {
         initializeStandardChessBoard();
     }
}
