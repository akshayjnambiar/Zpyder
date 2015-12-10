import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class UserInterface extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static long WP=0L,WN=0L,WB=0L,WR=0L,WQ=0L,WK=0L,BP=0L,BN=0L,BB=0L,BR=0L,BQ=0L,BK=0L;
    static long UniversalWP=0L,UniversalWN=0L,UniversalWB=0L,UniversalWR=0L,UniversalWQ=0L,UniversalWK=0L,UniversalBP=0L,UniversalBN=0L,UniversalBB=0L,UniversalBR=0L,UniversalBQ=0L,UniversalBK=0L;
    static int humanIsWhite=1;
    static int rating=0;
    static int border=10;//the amount of empty space around the frame
    static double squareSize=64;//the size of a chess board square
    static JFrame javaF=new JFrame("Zpyder");//must be declared as static so that other class' can repaint
    static UserInterface javaUI=new UserInterface();//must be declared as static so that other class' can repaint
    
    public static void main(String[] args) {
        javaF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        javaF.add(javaUI);
        javaF.setSize(757, 570);
        javaF.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-javaF.getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-javaF.getHeight())/2);
        javaF.setVisible(true);
        newGame();
        javaF.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(200, 200, 200));
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                squareSize=(double)(Math.min(getHeight(), getWidth()-200-border)-2*border)/8;
                System.out.println(squareSize);
            }
        });
        drawBorders(g);
        drawBoard(g);
        drawPieces(g);
    }
    
    public void drawBorders(Graphics g) {
        g.setColor(new Color(150, 150, 150));
        g.fill3DRect(0, border, border, (int)(8*squareSize), true);
        g.fill3DRect((int)(8*squareSize)+border, border, border, (int)(8*squareSize), true);
        g.fill3DRect(border, 0, (int)(8*squareSize), border, true);
        g.fill3DRect(border, (int)(8*squareSize)+border, (int)(8*squareSize), border, true);
        
        g.setColor(Color.BLACK);
        g.fill3DRect(0, 0, border, border, true);
        g.fill3DRect((int)(8*squareSize)+border, 0, border, border, true);
        g.fill3DRect(0, (int)(8*squareSize)+border, border, border, true);
        g.fill3DRect((int)(8*squareSize)+border, (int)(8*squareSize)+border, border, border, true);
        g.fill3DRect((int)(8*squareSize)+2*border+200, 0, border, border, true);
        g.fill3DRect((int)(8*squareSize)+2*border+200, (int)(8*squareSize)+border, border, border, true);
        
        g.setColor(new Color(150,150,150));
        g.fill3DRect((int)(8*squareSize)+2*border, 0, 200, border, true);
        g.fill3DRect((int)(8*squareSize)+2*border+200, border, border, (int)(8*squareSize), true);
        g.fill3DRect((int)(8*squareSize)+2*border, (int)(8*squareSize)+border, 200, border, true);
    }
    
    public void drawBoard(Graphics g) {
        for (int i=0;i<64;i+=2) {//draw chess board
            g.setColor(new Color(50, 50, 255));
            g.fillRect((int)((i%8+(i/8)%2)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)squareSize, (int)squareSize);
            g.setColor(new Color(200, 200, 200));
            g.fillRect((int)(((i+1)%8-((i+1)/8)%2)*squareSize)+border, (int)(((i+1)/8)*squareSize)+border, (int)squareSize, (int)squareSize);
        }
    }
    
    public void drawPieces(Graphics g) {
    	File sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IBK.png");
    	Image IBK, IBQ, IBB, IBN, IBR, IBP, IWK, IWQ, IWB, IWN, IWR, IWP;
        //Image chessPieceImage = new ImageIcon(System.getProperty("user.dir")+"\\ChessPieces.png").getImage();
    	IBK=IBQ=IBB=IBN=IBR=IBP=IWK=IWQ=IWB=IWN=IWR=IWP=null;
		try {
			IBK = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IBQ.png");
			IBQ = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IBB.png");
			IBB = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IBN.png");
			IBN = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IBR.png");
			IBR = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IBP.png");
			IBP = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IWK.png");
			IWK = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IWQ.png");
			IWQ = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IWB.png");
			IWB = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IWN.png");
			IWN = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IWR.png");
			IWR = ImageIO.read(sourceimage);
			sourceimage = new File("C:\\Users\\akshayjnambiar\\workspace\\Zpyder\\src\\images\\IWP.png");
			IWP = ImageIO.read(sourceimage);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
        
        for (int i=0;i<64;i++) {
            int j=-1,k=-1;
            if (((WP>>i)&1)==1) {j=5; k=1-humanIsWhite;}
            else if (((BP>>i)&1)==1) {j=5; k=humanIsWhite;}
            else if (((WB>>i)&1)==1) {j=3;k=1-humanIsWhite;}
            else if (((BB>>i)&1)==1) {j=3;k=humanIsWhite;}
            else if (((WN>>i)&1)==1) {j=4;k=1-humanIsWhite;}
            else if (((BN>>i)&1)==1) {j=4;k=humanIsWhite;}
            else if (((WQ>>i)&1)==1) {j=1;k=1-humanIsWhite;}
            else if (((BQ>>i)&1)==1) {j=1;k=humanIsWhite;}
            else if (((WR>>i)&1)==1) {j=2;k=1-humanIsWhite;}
            else if (((BR>>i)&1)==1) {j=2;k=humanIsWhite;}
            else if (((WK>>i)&1)==1) {j=0;k=1-humanIsWhite;}
            else if (((BK>>i)&1)==1) {j=0;k=humanIsWhite;}
            if (j!=-1 && k!=-1) {
            	switch(j) {
            		case 0 : 
            			if(k==0) g.drawImage(IWK,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			else  g.drawImage(IBK,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			break;
            		case 1 :
            			if(k==0) g.drawImage(IWQ,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			else g.drawImage(IBQ,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			break;
            		case 2:
            			if(k==0) g.drawImage(IWR,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			else g.drawImage(IBR,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			break;
            		case 3:
            			if(k==0) g.drawImage(IWB,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			else g.drawImage(IBB,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			break;
            		case 4:
            			if(k==0) g.drawImage(IWN,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			else g.drawImage(IBN,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			break;
            		case  5:
            			if(k==0) g.drawImage(IWP,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			else g.drawImage(IBP,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, 0, 0, 64, 64, this);
            			break;
            	}
               // g.drawImage(IBQ,(int)((i%8)*squareSize)+border, (int)((i/8)*squareSize)+border, (int)((i%8+1)*squareSize)+border, (int)((i/8+1)*squareSize)+border, j*64, k*64, (j+1)*64, (k+1)*64, this);
            }
        }
    }
    
    public static void newGame() {
        BitboardGeneration.initializeStandardChessBoard();
    }
}