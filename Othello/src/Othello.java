import java.awt.EventQueue;

import javax.swing.JFrame;

import java.util.*;
import java.awt.Canvas;
import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import static javax.swing.JOptionPane.showMessageDialog;





import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;

import javax.swing.JToggleButton;

import java.awt.Button;

import javax.swing.JLayeredPane;
import javax.swing.JToolBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.plaf.TextUI;
import javax.swing.SwingConstants;

import java.awt.event.MouseMotionAdapter;

import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;


public class Othello implements ActionListener, MouseMotionListener {

	private JFrame frame;
	private JTextField textField;
	private JPanel[] row = new JPanel[8];
	private JButton[][] button=new JButton[8][8];
	private JTextArea textArea = new JTextArea();
	Player player1=new Player();
	Player player2=new Player();
	public final int PLAYER1WINS=1;
	public final int PLAYER2WINS=2;
	public final int INCOMPLETE=3;
	public final int DRAW=4;
	Player currentPlayer=player1;
	Player nextPlayer=player2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Othello window = new Othello();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public Othello() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(20, 20, 1043, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setResizable(false);
		frame.setTitle("OTHELLO GAME");

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		player1.color=Color.BLACK;
		player2.color=Color.LIGHT_GRAY;
		player1.icon=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png"));
		player2.icon=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png"));


		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		panel.setBackground(new Color(204, 51, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);


		textArea.setForeground(new Color(102, 51, 0));
		textArea.setBackground(new Color(102, 204, 51));
		textArea.setFont(new Font("Buxton Sketch", Font.BOLD, 30));
		textArea.setEditable(false);
		textArea.setBounds(780, 110, 235, 369);
		textArea.setBorder(null);
		panel.add(textArea);
		textArea.setCaretPosition(0);
		textArea.setText("\n\n    PLAYER 1 :\n"+"    BLACK X 2\n\n\n"+"    PLAYER 2 :\n"+"    WHITE X 2");


		JButton btnNewButton = new JButton("NEW GAME");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Corbel", Font.BOLD, 12));
		btnNewButton.setBounds(848, 496, 98, 48);
		btnNewButton.setBorder(null);
		panel.add(btnNewButton);


		JButton btnNewButton_1 = new JButton("QUIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnNewButton_1.setFont(new Font("Corbel", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(848, 588, 98, 48);
		panel.add(btnNewButton_1);

		textField = new JTextField();
		textField.setForeground(new Color(102, 51, 0));
		textField.setBackground(new Color(102, 204, 51));
		textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(144, 23, 524, 70);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText("");





		for(int i=0;i<8;i++){

			row[i]=new JPanel();
			row[i].setBounds(1, 110+67*i, 764, 67);
			panel.add(row[i]);
			row[i].setLayout(new GridLayout(1, 0, 0, 0));
			row[i].setBackground(new Color(204, 51, 0));

			for(int j=0;j<8;j++){

				button[i][j]=new JButton("");
				button[i][j].setBackground(Color.CYAN);
				button[i][j].addActionListener(this);
				button[i][j].addMouseMotionListener(this);
				button[i][j].setIcon(null);
				row[i].add(button[i][j]);
			}
		}

		button[3][3].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")));
		button[4][3].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")));
		button[4][4].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")));
		button[3][4].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")));


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						button[i][j].setIcon(null);
					}
				}

				button[3][3].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")));
				button[4][3].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")));
				button[4][4].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")));
				button[3][4].setIcon(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")));

				player1.color=Color.BLACK;
				player2.color=Color.LIGHT_GRAY;

				player1.icon=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png"));
				player2.icon=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png"));

				currentPlayer=player1;
				nextPlayer=player2;


				textField.setText("");
				JFrame newFrame=new JFrame();
				newFrame.setBounds(200, 200, 400, 400);
				newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				newFrame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
				newFrame.setVisible(true);

				JPanel newPanel=new JPanel();
				newFrame.getContentPane().add(newPanel);
				newPanel.setLayout(null);
				newPanel.setBackground(new Color(204, 51, 0));


				JPanel panel_1=new JPanel();
				panel_1.setBounds(0,50,400,50);
				panel_1.setBackground(Color.BLACK);
				panel_1.setLayout(new GridLayout(1, 0, 0, 0));
				newPanel.add(panel_1);

				JLabel label_1=new JLabel();
				label_1.setText("NAME OF PLAYER 1");
				label_1.setFont(new Font("Arial Black", Font.BOLD, 15));
				label_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_1.setBackground(Color.BLACK);
				label_1.setForeground(Color.WHITE);
				panel_1.add(label_1);

				JTextField field_1=new JTextField();
				field_1.setFont(new Font("Arial Black", Font.BOLD, 15));
				field_1.setHorizontalAlignment(SwingConstants.CENTER);
				field_1.setBackground(new Color(102, 204, 51));
				field_1.setEditable(true);
				panel_1.add(field_1);

				JPanel panel_2=new JPanel();

				panel_2.setBounds(0,150,400,50);
				panel_2.setBackground(Color.WHITE);
				panel_2.setLayout(new GridLayout(1, 0, 0, 0));
				newPanel.add(panel_2);

				JLabel label_2=new JLabel();
				label_2.setText("NAME of PLAYER 2");
				label_2.setFont(new Font("Arial Black", Font.BOLD, 15));
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setBackground(Color.WHITE);
				panel_2.add(label_2);

				JTextField field_2=new JTextField();
				field_2.setFont(new Font("Arial Black", Font.BOLD, 15));
				field_2.setBackground(new Color(102, 204, 51));
				field_2.setHorizontalAlignment(SwingConstants.CENTER);
				field_2.setEditable(true);
				panel_2.add(field_2);

				JButton newButton=new JButton();
				newButton.setText("  OK ");
				newButton.setBackground(Color.CYAN);
				newButton.setHorizontalAlignment(SwingConstants.CENTER);
				newButton.setBounds(150, 250, 80, 40);
				newPanel.add(newButton);

				newButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String name1=field_1.getText();
						String name2=field_2.getText();
						player1.name=name1;
						player2.name=name2;
						textArea.setText("\n\n    "+player1.name+" :\n"+"    "+"BLACK X 2\n\n\n"+"    "+player2.name+" :\n"+"    "+"WHITE X 2");
						//printPossibleMoves(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")));
						newFrame.dispose();
					}
				});				
			}
		});
	}

	public boolean move(Icon symbol,int x,int y){

		int[] xDir={0,0,1,1,1,-1,-1,-1};
		int[] yDir={-1,1,0,1,-1,0,-1,1};

		if(button[x][y].getIcon()!=null){
			return false;
		}

		Icon prevSymbol=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")) ;
		if(symbol.toString().equals(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")).toString())){
			prevSymbol=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png"));
		}


		boolean MovePossible=false;;
		boolean makeMove=false;
		for(int i=0;i<xDir.length;i++){

			int xStep=xDir[i];
			int yStep=yDir[i];

			int currentX=x+xStep;
			int currentY=y+yStep;
			makeMove=false;

			while(currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&button[currentX][currentY].getIcon()!=null&&button[currentX][currentY].getIcon().toString().equals(prevSymbol.toString())){

				currentX+=xStep;
				currentY+=yStep;
				makeMove=true;
			}

			if(makeMove&&currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&button[currentX][currentY].getIcon()!=null&&button[currentX][currentY].getIcon().toString().equals(symbol.toString())){
				int j=currentX-xStep;
				int k=currentY-yStep;
				MovePossible=true;
				while(button[j][k].getIcon()!=null&&button[j][k].getIcon().toString().equals(prevSymbol.toString())){
					button[j][k].setIcon(symbol);
					j-=xStep;
					k-=yStep;
				}
				button[j][k].setIcon(symbol);
			}
		}
		return MovePossible;
	}

	public boolean movePossible(Icon symbol,int x,int y){

		int[] xDir={0,0,1,1,1,-1,-1,-1};
		int[] yDir={-1,1,0,1,-1,0,-1,1};

		if(button[x][y].getIcon()!=null){
			return false;
		}

		Icon prevSymbol=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")) ;
		if(symbol.toString().equals(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")).toString())){
			prevSymbol=new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png"));
		}


		boolean makeMove=false;

		for(int i=0;i<xDir.length;i++){

			makeMove=false;
			int xStep=xDir[i];
			int yStep=yDir[i];

			int currentX=x+xStep;
			int currentY=y+yStep;

			while(currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&button[currentX][currentY].getIcon()!=null&&button[currentX][currentY].getIcon().toString().equals(prevSymbol.toString())){

				currentX+=xStep;
				currentY+=yStep;
				makeMove=true;
			}

			if(makeMove&&currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&button[currentX][currentY].getIcon()!=null&&button[currentX][currentY].getIcon().toString().equals(symbol.toString())){		
				return true;
			}
		}
		return false;
	}

	public int gameStatus(Icon symbol){

		for(int i=0;i<button.length;i++){
			for(int j=0;j<button[i].length;j++){

				if(movePossible(symbol,i,j)){
					return INCOMPLETE;
				}
			}
		}

		int countBlack=0;
		int countWhite=0;

		for(int i=0;i<button.length;i++){
			for(int j=0;j<button[i].length;j++){

				if(button[i][j].getIcon()!=null&&button[i][j].getIcon().toString().equals(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")).toString())){
					countBlack++;
				}

				if(button[i][j].getIcon()!=null&&button[i][j].getIcon().toString().equals(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")).toString())){
					countWhite++;
				}
			}
		}

		if(countBlack>countWhite){
			return PLAYER1WINS;
		}

		if(countBlack<countWhite){
			return PLAYER2WINS;
		}

		return DRAW;	
	}


	public void printPossibleMoves(Icon symbol){

		Color color=Color.BLACK;
		if(symbol.toString().equals((new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png"))).toString())){
			color=Color.LIGHT_GRAY;
		}

		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){

				button[i][j].setBackground(Color.cyan);
			}
		}

		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){

				if(movePossible(symbol,i,j)){

					button[i][j].setBackground(color);
				}
			}
		}	
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){

				if(e.getSource()==button[i][j]&&button[i][j].getBackground()==currentPlayer.color){

					button[i][j].setBackground(Color.CYAN);
					move(currentPlayer.icon, i, j);

					int countBlack=0;
					int countWhite=0;

					for(int k=0;k<button.length;k++){
						for(int l=0;l<button[k].length;l++){

							if(button[k][l].getIcon()!=null&&button[k][l].getIcon().toString().equals(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-dark.png")).toString())){
								countBlack++;
							}

							if(button[k][l].getIcon()!=null&&button[k][l].getIcon().toString().equals(new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png")).toString())){
								countWhite++;
							}
						}
					}

					textArea.setText("\n\n    "+player1.name+" :\n"+"    "+"BLACK X "+countBlack+"\n\n\n"+"    "+player2.name+" :\n"+"    "+"WHITE X "+countWhite);

					if(gameStatus(nextPlayer.icon)==INCOMPLETE){
						//printPossibleMoves(nextPlayer.icon);
						textField.setText(nextPlayer.name+"'S TURN");
						Player temp=currentPlayer;
						currentPlayer=nextPlayer;
						nextPlayer=temp;

					}

					else if(gameStatus(currentPlayer.icon)==INCOMPLETE){
						//printPossibleMoves(currentPlayer.icon);
					}

					else if(gameStatus(currentPlayer.icon)==PLAYER1WINS){
						textField.setText("!! CONGRATS "+player1.name+" HAS WON THE GAME !!");
						showMessageDialog(frame, "!! CONGRATS "+player1.name+" HAS WON THE GAME !!");
					}
					else if(gameStatus(currentPlayer.icon)==PLAYER2WINS){
						textField.setText("!! CONGRATS "+player2.name+" HAS WON THE GAME !!");
						showMessageDialog(frame, "!! CONGRATS "+player2.name+" HAS WON THE GAME !!");
					}

					else if(gameStatus(currentPlayer.icon)==DRAW){
						textField.setText("!! IT'S A DRAW !!");
						showMessageDialog(frame, "!! IT'S A DRAW !!");
					}
				}

				else if(e.getSource()==button[i][j]&&button[i][j].getBackground()!=currentPlayer.color){
					showMessageDialog(frame, "!! INVALID MOVE TRY AGAIN !!");

					if(currentPlayer.name!=null)
						textField.setText(currentPlayer.name+"'s TURN ");
				}
			}
		}
	}

	public void autoMation(){
		
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){

					button[i][j].setBackground(Color.cyan);				
			}
		}
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){

				if(e.getSource()==button[i][j]&&movePossible(currentPlayer.icon, i, j)){
					Color color=Color.BLACK;
					if(currentPlayer.icon.toString().equals((new ImageIcon(Othello.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/vk-light.png"))).toString())){
						color=Color.LIGHT_GRAY;
					}
					button[i][j].setBackground(color);
				}

			}
		}
	}
}
