package matching_cards;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import javax.sound.sampled.*;

import java.awt.*;
import java.io.File;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.sound.sampled.*;

public class MatchingCards extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(MAIN.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(MAIN.class.getResource("../images/exitButtonBasic.png"));

	private ImageIcon startButtonEnteredImage = new ImageIcon(
			MAIN.class.getResource("../images/startbuttonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(MAIN.class.getResource("../images/startbuttonBasic.png"));

	private ImageIcon gameExplainBasicImage = new ImageIcon(MAIN.class.getResource("../images/gameExplainBasic.png"));
	private ImageIcon gameExplainEnteredImage = new ImageIcon(
			MAIN.class.getResource("../images/gameExplainEntered.png"));

	private ImageIcon homeButtonBasicImage = new ImageIcon(MAIN.class.getResource("../images/homeButtonBasic.png"));
	private ImageIcon homeButtonEnteredImage = new ImageIcon(MAIN.class.getResource("../images/homeButtonEntered.png"));

	private ImageIcon easyButtonBasicImage = new ImageIcon(MAIN.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(MAIN.class.getResource("../images/easyButtonEntered.png"));
	
	private ImageIcon normalButtonBasicImage = new ImageIcon(MAIN.class.getResource("../images/normalButtonBasic.png"));
	private ImageIcon normalButtonEnteredImage = new ImageIcon(MAIN.class.getResource("../images/normalButtonEntered.png"));
	
	private ImageIcon hardButtonBasicImage = new ImageIcon(MAIN.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(MAIN.class.getResource("../images/hardButtonEntered.png"));

	private Image background = new ImageIcon(MAIN.class.getResource("../images/introbackground.png"))
			.getImage();
	private Image gameScore = new ImageIcon(MAIN.class.getResource("../images/gameScore.png"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(MAIN.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton explainButton = new JButton(gameExplainBasicImage);
	private JButton homeButton = new JButton(homeButtonBasicImage);
	
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton normalButton = new JButton(normalButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	private Music introMusic = new Music("introMusic.mp3", true);

	private int mouseX, mouseY;
	
	private boolean isGameScreen = false;
	
	public MatchingCards() {
		setUndecorated(true);
		setTitle("Matching Cards");
		setSize(MAIN.SCREEN_WIDTH, MAIN.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		final Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();


		menuBar.setBounds(0, 0, 1280, 59);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		exitButton.setBounds(1200, 30, 50, 50);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		startButton.setBounds(270, 500, 291, 110);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				startButton.setVisible(false);
				explainButton.setVisible(false);
				homeButton.setVisible(true);
				easyButton.setVisible(true);
				normalButton.setVisible(true);
				hardButton.setVisible(true);
				background = new ImageIcon(MAIN.class.getResource("../images/gameDifficultyScreen.png")).getImage();
				
			}
		});
		add(startButton);

		explainButton.setBounds(740, 500, 291, 110);
		explainButton.setBorderPainted(false);
		explainButton.setContentAreaFilled(false);
		explainButton.setFocusPainted(false);
		explainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				explainButton.setIcon(gameExplainEnteredImage);
				explainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				explainButton.setIcon(gameExplainBasicImage);
				explainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				explainButton.setVisible(false);
				startButton.setVisible(false);
				homeButton.setVisible(true);
				background = new ImageIcon(MAIN.class.getResource("../images/gameExplainScreen.png")).getImage();
			}
		});
		add(explainButton);

		homeButton.setBounds(50, 55, 117, 110);
		homeButton.setBorderPainted(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setFocusPainted(false);
		homeButton.setVisible(false);
		homeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homeButton.setIcon(homeButtonEnteredImage);
				homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				homeButton.setIcon(homeButtonBasicImage);
				homeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				startButton.setVisible(true);
				explainButton.setVisible(true);
				easyButton.setVisible(false);
				normalButton.setVisible(false);
				hardButton.setVisible(false);
				homeButton.setVisible(false);
				background = new ImageIcon(MAIN.class.getResource("../images/introBackground.png")).getImage();
			}
		});
		add(homeButton);
		
		easyButton.setBounds(210, 350, 236, 106);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.setVisible(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				//introMusic.close();
			}
		});
		easyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new easyGame();
			}
		});
		add(easyButton);
		
		normalButton.setBounds(510, 350, 236, 106);
		normalButton.setBorderPainted(false);
		normalButton.setContentAreaFilled(false);
		normalButton.setFocusPainted(false);
		normalButton.setVisible(false);
		normalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				normalButton.setIcon(normalButtonEnteredImage);
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				normalButton.setIcon(normalButtonBasicImage);
				normalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		add(normalButton);
		
		hardButton.setBounds(810, 350, 236, 106);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.setVisible(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		hardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new hardGame();
			}
		});
		add(hardButton);

	}

	public void paint(Graphics g) {
		screenImage = createImage(MAIN.SCREEN_WIDTH, MAIN.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		if(isGameScreen) {
			g.drawImage(gameScore, 850, 80, null);
			
			g.setColor(Color.black);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Elephant", Font.BOLD, 35));
			g.drawString("00", 980, 217);
		}
		paintComponents(g);
		this.repaint();
	}
	
}

class easyGame extends JFrame implements ActionListener{
	
	static JPanel panelCenter;
	static JPanel panelSide;
	static JLabel labelMessage;
	static JButton[] buttons = new JButton[16];
	static String[] images = {
			"Animal01.png", "Animal02.png", "Animal03.png", "Animal04.png", 
			"Animal05.png", "Animal06.png", "Animal07.png", "Animal08.png",
			"Animal01.png", "Animal02.png", "Animal03.png", "Animal04.png", 
			"Animal05.png", "Animal06.png", "Animal07.png", "Animal08.png",
	};
	
	static int openCount = 0;
	static int buttonIndexSave1 = 0;
	static int buttonIndexSave2 = 0;
	static Timer timer;
	static int tryCount = 0;
	static int successCount = 0;
	
	public easyGame(){
		setTitle("쉬움 난이도 카드 뒤집기");
		setSize(1280,720);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		panelSide = new JPanel() {
			Image panelSideBackgroundImage = new ImageIcon(easyGame.class.getResource
					("../images/sidepanelBackground.png")).getImage();
			public void paint(Graphics g) {
				g.drawImage(panelSideBackgroundImage, 0, 0, null);
				paintComponents(g);
			}
		};
		panelSide.setPreferredSize(new Dimension(540,720));
		add("East", panelSide);
		
		labelMessage = new JLabel("<html>---카드를 뒤집으면---<br>시도 횟수가 표시됩니다!<html>");
		labelMessage.setPreferredSize(new Dimension(540, 720));
		labelMessage.setForeground(Color.BLACK);
		labelMessage.setFont(new Font(("Jalnan"), Font.BOLD,35));
		labelMessage.setHorizontalAlignment(JLabel.CENTER);
		panelSide.add(labelMessage);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(4,4));
		panelCenter.setPreferredSize(new Dimension(720,720));
		for(int i=0; i<16 ;i++)
		{
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(new Dimension(180,180));
			buttons[i].setIcon( changeImage("star.png"));
			buttons[i].addActionListener(this);
			buttons[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
					buttonEnteredMusic.start();
				}
				public void mousePressed(MouseEvent e) {
					Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
					buttonEnteredMusic.start();
				}
			});
			panelCenter.add(buttons[i]);
		}
		add("West", panelCenter);
		mixCard();
		}
		
		static void playSound(String filename) {
			File file = new File("./src/sound/"+filename);
			if(file.exists()) {
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("File Not found!");
			}
		}
		@Override
		
		public void actionPerformed(ActionEvent e) {
			
			if(openCount == 2) {
				return;
			}
			
			JButton  btn= (JButton)e.getSource();
			int index = getButtonIndex(btn);
			btn.setIcon(changeImage(images[index]));
			
			openCount++;
			if(openCount ==1) {
				buttonIndexSave1 = index;
			}
			else if (openCount == 2) {
				buttonIndexSave2 = index;
				tryCount++;
				labelMessage.setText("시도 횟수 : "+ tryCount);
				
				boolean isBingo = checkCard(buttonIndexSave1, buttonIndexSave2);
				if(isBingo == true) {
					Music correctSound = new Music("correct.mp3", false);
					correctSound.start();
					openCount = 0;
					successCount++;
					if(successCount == 8) {
						labelMessage.setText("최종 점수는 " + (108 - tryCount) + " 입니다!");
						Object[] option = {"난이도 선택 화면으로 돌아가기"};
						int complete = JOptionPane.showOptionDialog
								(null, "점수는 " + (108 - tryCount) + " 입니다!" , "축하합니다!" 
										, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
						if(complete == 0) {
							dispose();
						}
						}
				}
				else {
					backToQuestion();
				}
			}
		}
		public void backToQuestion() {
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Timer");
					
					playSound("incorrect.wav");
					openCount = 0;
					buttons[buttonIndexSave1].setIcon(changeImage("star.png"));
					buttons[buttonIndexSave2].setIcon(changeImage("star.png"));
					timer.stop();
				}
			});
			timer.start();
		}
		public boolean checkCard(int index1, int index2)
		{
			if(index1 == index2) {
				return false;
			}
			if(images[index1].equals(images[index2])){
				return true;
					}else {
						return false;
					}
		}
		
		public int getButtonIndex(JButton btn) {
			int index = 0;
			for(int i=0; i < 16 ; i++) {
				if (buttons[i] == btn) {
					index = i;
				}
			}
			return index;
		}
		
	static void mixCard() {
	Random rand = new Random();
	for(int i=0; i<1000 ; i++) {
		int random = rand.nextInt(15) + 1;
		
		String temp = images[0];
		images[0] = images[random];
		images[random] = temp;
		}
	}
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./src/gameimages/" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}

}

class hardGame extends JFrame implements ActionListener{
	
	static JPanel panelCenter;
	static JPanel panelSide;
	static JLabel labelMessage;
	static JButton[] buttons = new JButton[36];
	static String[] images = {
			"Animal01.png", "Animal02.png", "Animal03.png", "Animal04.png", 
			"Animal05.png", "Animal06.png", "Animal07.png", "Animal08.png",
			"Animal01.png", "Animal02.png", "Animal03.png", "Animal04.png", 
			"Animal05.png", "Animal06.png", "Animal07.png", "Animal08.png",
			"Animal09.png", "Animal10.png", "Animal11.png", "Animal12.png",
			"Animal13.png", "Animal14.png", "Animal15.png", "Animal16.png",
			"Animal09.png", "Animal10.png", "Animal11.png", "Animal12.png",
			"Animal13.png", "Animal14.png", "Animal15.png", "Animal16.png",
			"Animal17.png", "Animal18.png", "Animal17.png", "Animal18.png",
	};
	
	static int openCount = 0;
	static int buttonIndexSave1 = 0;
	static int buttonIndexSave2 = 0;
	static Timer timer;
	static int tryCount = 0;
	static int successCount = 0;
	
	public hardGame(){
		setTitle("어려움 난이도 카드 뒤집기");
		setSize(1280,720);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		panelSide = new JPanel() {
			Image panelSideBackgroundImage = new ImageIcon(hardGame.class.getResource
					("../images/sidepanelBackgroundhard.png")).getImage();
			public void paint(Graphics g) {
				g.drawImage(panelSideBackgroundImage, 0, 0, null);
				paintComponents(g);
			}
		};
		panelSide.setPreferredSize(new Dimension(540,720));
		add("East", panelSide);
		
		labelMessage = new JLabel("<html>---카드를 뒤집으면---<br>시도 횟수가 표시됩니다!<html>");
		labelMessage.setPreferredSize(new Dimension(540, 720));
		labelMessage.setForeground(Color.BLACK);
		labelMessage.setFont(new Font(("Jalnan"), Font.BOLD,35));
		labelMessage.setHorizontalAlignment(JLabel.CENTER);
		panelSide.add(labelMessage);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(6,6));
		panelCenter.setPreferredSize(new Dimension(720,720));
		for(int i=0; i<36 ;i++)
		{
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(new Dimension(120,120));
			buttons[i].setIcon( changeImage("star.png"));
			buttons[i].addActionListener(this);
			buttons[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
					buttonEnteredMusic.start();
				}
				public void mousePressed(MouseEvent e) {
					Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
					buttonEnteredMusic.start();
				}
			});
			panelCenter.add(buttons[i]);
		}
		add("West", panelCenter);
		mixCard();
		}
		
		static void playSound(String filename) {
			File file = new File("./src/sound/"+filename);
			if(file.exists()) {
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("File Not found!");
			}
		}
		@Override
		
		public void actionPerformed(ActionEvent e) {
			
			if(openCount == 2) {
				return;
			}
			
			JButton  btn= (JButton)e.getSource();
			int index = getButtonIndex(btn);
			btn.setIcon(changeImage(images[index]));
			
			openCount++;
			if(openCount ==1) {
				buttonIndexSave1 = index;
			}
			else if (openCount == 2) {
				buttonIndexSave2 = index;
				tryCount++;
				labelMessage.setText("시도 횟수 : "+ tryCount);
				
				boolean isBingo = checkCard(buttonIndexSave1, buttonIndexSave2);
				if(isBingo == true) {
					Music correctSound = new Music("correct.mp3", false);
					correctSound.start();
					openCount = 0;
					successCount++;
					if(successCount == 18) {
						labelMessage.setText("최종 점수는 " + (118 - tryCount) + " 입니다!");
						Object[] option = {"난이도 선택 화면으로 돌아가기"};
						int complete = JOptionPane.showOptionDialog
								(null, "점수는 " + (118 - tryCount) + " 입니다!" , "축하합니다!" 
										, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
						if(complete == 0) {
							dispose();
						}
						}
				}
				else {
					backToQuestion();
				}
			}
		}
		public void backToQuestion() {
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Timer");
					
					playSound("incorrect.wav");
					openCount = 0;
					buttons[buttonIndexSave1].setIcon(changeImage("star.png"));
					buttons[buttonIndexSave2].setIcon(changeImage("star.png"));
					timer.stop();
				}
			});
			timer.start();
		}
		public boolean checkCard(int index1, int index2)
		{
			if(index1 == index2) {
				return false;
			}
			if(images[index1].equals(images[index2])){
				return true;
					}else {
						return false;
					}
		}
		
		public int getButtonIndex(JButton btn) {
			int index = 0;
			for(int i=0; i < 36 ; i++) {
				if (buttons[i] == btn) {
					index = i;
				}
			}
			return index;
		}
		
	static void mixCard() {
	Random rand = new Random();
	for(int i=0; i<1000 ; i++) {
		int random = rand.nextInt(35) + 1;
		
		String temp = images[0];
		images[0] = images[random];
		images[random] = temp;
		}
	}
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./src/gameimages/" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}

}



