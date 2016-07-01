package Othello_Game;

import java.awt.event.*;

import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
 

public class Othello extends JFrame implements ActionListener {

	private static Scanner s;

	private static final long serialVersionUID = 1L;
	JPanel[] row = new JPanel[9];
    JButton[] button = new JButton[64];
   
    int[] dimW = {300,45,100,90};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(800, 800);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(2,20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    
   Othello() {
        super("Othello");
        setDesign();
        setSize(800, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(8,8);
        setLayout(grid);
        
        for(int i = 0; i < 4; i++)
            function[i] = false;
        
       FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        for(int i = 0; i < 9; i++)
            row[i] = new JPanel();
        row[0].setLayout(f1);
        for(int i = 0; i < 9; i++)
            row[i].setLayout(f2);
        
        for(int i = 0; i < 64; i++) {
            button[i] = new JButton();
            button[i].setText("");
            button[i].setBackground(Color.white);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);
        
        for(int i = 0; i < 64; i++)
            button[i].setPreferredSize(regularDimension);
        
//        row[0].add(display);
//        add(row[0]);
        
        for(int i = 0; i < 8; i++)
            row[1].add(button[i]);
        add(row[1]);
        
        for(int i = 8; i < 16; i++)
            row[2].add(button[i]);
        add(row[2]);
        
        for(int i = 16; i < 24; i++)
            row[3].add(button[i]);
        add(row[3]);
 
        for(int i = 24; i < 32; i++)
            row[4].add(button[i]);
        add(row[4]);
        
        for(int i = 32; i < 40; i++)
            row[5].add(button[i]);
        add(row[5]);
        
        for(int i = 40; i < 48; i++)
            row[6].add(button[i]);
        add(row[6]);
        
//        for(int i = 48; i < 56; i++)
//            row[7].add(button[i]);
//        add(row[7]);
//        
//        for(int i = 56; i < 64; i++)
//            row[8].add(button[i]);
//        add(row[8]);
////        
        setVisible(true);
    }
    
    public void clear() {
        try {
            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } catch(NullPointerException e) {  
        }
    }
    
    public void getSqrt() {
        try {
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));
        } catch(NumberFormatException e) {
        }
    }
    
    
    
    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {   
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	
        if(ae.getSource() == button[0])
            display.append("7");
        if(ae.getSource() == button[1])
            display.append("8");
        if(ae.getSource() == button[2])
            display.append("9");
        if(ae.getSource() == button[3]) {
        	//button[3].setText("H");
            //add function[0]
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(ae.getSource() == button[4])
            display.append("4");
        if(ae.getSource() == button[5])
            display.append("5");
        if(ae.getSource() == button[6])
            display.append("6");
        if(ae.getSource() == button[7]) {
            //subtract function[1]
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(ae.getSource() == button[8])
            display.append("1");
        if(ae.getSource() == button[9])
            display.append("2");
        if(ae.getSource() == button[10])
            display.append("3");
        if(ae.getSource() == button[11]) {
            //multiply function[2]
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(ae.getSource() == button[12])
            display.append(".");
        if(ae.getSource() == button[13]) {
            //divide function[3]
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(ae.getSource() == button[14])
            clear();
       
    }
    
	
	
	public static void main(String[] args) {

	     startGame();
		//Othello oth=new Othello();

	}

	public static void startGame(){

		s=new Scanner (System.in);

		int num=1;
		Players player1=takeinput(num++);
		Players player2=takeinput(num);
		while(player1.symbol==player2.symbol){
			System.out.println("SYMBOL TAKEN...CHOOSE ANOTHER ONE!!");
			player2=takeinput(num);
		}

		OthelloBoard board=new OthelloBoard(player1.symbol,player2.symbol);
		board.printBoard();

		boolean player1Turn=true;
		boolean done;
		Players currentPlayer=player1;
		Players nextPlayer=player2;

		while(board.gameStatus(currentPlayer.symbol)==board.INCOMPLETE||board.gameStatus(nextPlayer.symbol)==board.INCOMPLETE){
			if(player1Turn&&board.gameStatus(currentPlayer.symbol)==board.INCOMPLETE){
				board.printPossibleMoves(player1.symbol);
				done=false;
				while(!done){
					System.out.println("PLAYER 1's TURN:");
					System.out.println("ENTER X & Y COORDINATES:");
					int x=s.nextInt();
					int y=s.nextInt();
					done=board.move(player1.symbol, x, y);
					if(!done){
						System.out.println("INVALID MOVE TRY AGAIN !!");
					}
				}
				player1Turn=false;
				currentPlayer=player2;
				nextPlayer=player1;
			}
			else {
				done=false;
				board.printPossibleMoves(player2.symbol);
				while(!done&&board.gameStatus(currentPlayer.symbol)==board.INCOMPLETE){
					System.out.println("PLAYER 2's TURN:");
					System.out.println("ENTER X & Y COORDINATES:");
					int x=s.nextInt();
					int y=s.nextInt();
					done=board.move(player2.symbol, x, y);
					if(!done){
						System.out.println("INVALID MOVE TRY AGAIN !!");
					}
				}
				player1Turn=true;
				currentPlayer=player1;
				nextPlayer=player2;
			}
			board.printBoard();
		}
		System.out.println();
		if(board.gameStatus(currentPlayer.symbol)==board.PLAYER1WINS){
			System.out.println("!! CONGRATS "+player1.name+" HAS WON THE GAME !!");
		}
		if(board.gameStatus(currentPlayer.symbol)==board.PLAYER2WINS){
			System.out.println("!! CONGRATS "+player2.name+" HAS WON THE GAME !!");
		}
		
		if(board.gameStatus(currentPlayer.symbol)==board.DRAW){
			System.out.println("!! IT'S A DRAW !!");
		}
		
	}

	public static Players takeinput(int num){

		s = new Scanner(System.in);
		System.out.println("ENTER THE NAME AND SYMBOL OF PLAYER "+num+":");
		String name=s.nextLine();
		char symbol=s.next().charAt(0);
		while(symbol!='b'&&symbol!='w'){
			System.out.println("INVALID SYMBOL!! ENTER b or w");
			symbol=s.next().charAt(0);
		}
		Players player=new Players(name, symbol);
		return player;
	}

}
