package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FirstScreen implements MouseListener,KeyListener {
	boolean endgamePass=false;
	//ImageIcon narutoGif=new ImageIcon("spaceBackground.png");
	ImageIcon narutoGifImage=new ImageIcon("tetrisSpace.png");
	
	JLabel narutoLabel=new JLabel();
	
	ImageIcon tetrisTextImage=new ImageIcon("tetris.png");
	JLabel tetrisTextLabel=new JLabel();
	
	ImageIcon playButtonImage=new ImageIcon("tetrisPlay.png");
	JLabel playButtonLabel=new JLabel();
	
	ImageIcon frameImage=new ImageIcon("frame.png");
	JLabel frameLabel=new JLabel();
	
	int score=0;
	
	boolean oneTimePass=true;
	
	JLabel scoreLabel=new JLabel((score/1000+""+((score/100)%10)+""+((score/10)%10)+""+(score%10)));
	JLabel scoreLabel1=new JLabel("SCORE    D to rotate");
	

	JLabel highestScoreLabel=new JLabel();
	JLabel highestScoreLabel1=new JLabel("HIGHEST SCORE");
	
	ImageIcon nextBlockImage=new ImageIcon("");
	JLabel nextBlockLabel=new JLabel();
	
	JLabel nextTextLabel=new JLabel("Next");
	
//	ImageIcon yellowBlockImage=new ImageIcon("yellowBlock.png");
//	ImageIcon blueBlockImage=new ImageIcon("blueBlock.png");
//	ImageIcon redBlockImage=new ImageIcon("greenBlock.png");
//	ImageIcon orangeBlockImage=new ImageIcon("orangeBlock.png");
//	ImageIcon lightBlueBlockImage=new ImageIcon("lightBlueBlock.png");
//	ImageIcon purpleBlockImage=new ImageIcon("purpleBlock.png");
//	ImageIcon greenBlockImage=new ImageIcon("greenBlock.png");
	
	int x=0;
	int y=0;
	
	boolean passMove=false;
	Timer timer=new Timer();
	
	Block[]blockTypes= {new YellowBlock(0,0),
			                 new RedBlock(0,0), 
			                 new BlueBlock(0,0),
			                 new OrangeBlock(0,0),
			                 new LightBlueBlock(0,0),
			                 new PurpleBlock(0,0),
			                 new GreenBlock(0,0)};
	
	
	
	
	ImageIcon blockImage=new ImageIcon("");
	JLabel blockLabel=new JLabel();
	
	JLabel blockLabel1=new JLabel();
	JLabel blockLabel2=new JLabel();
	JLabel blockLabel3=new JLabel();
	JLabel blockLabel4=new JLabel();
	
	JFrame frame=new JFrame("Tetris");
	Random random=new Random();
	
	boolean pass=true;
	
	Queue<Block>blockQueue=new LinkedList<>();
	
	Block[] blocks;
	Block[]nextBlocks;
	Block block=null;
	Block nextBlock=null;
	
	int turn=1;
	int count=1;
	Hashtable<String,JLabel> blockLabelTable=new Hashtable<>(15000);
	
	boolean space[][]=new boolean[16][10];
	
	 JLabel[]blockLabels;
	 JLabel[]nextBlockLabels;
	 
	 boolean[]activeKey=new boolean[69];
	 
	 boolean[]leader=new boolean[69];
	 
	 long start=0;
	 boolean keyPressFixerPass=true;
	 boolean testPass=false;
	 int testCount=0;
	 
int explosionTimer=0;
int explosionTimer1=0;
		

File gameMusic=new File("onePieceDrumsOfLiberation.wav");

File endGameMusic=new File("felixMusic.wav");
File explosionSound=new File("explosionSound.wav"); 
File playySound=new File("readySound.wav");
File multiExplosionSound=new File("multiExplosionSound.wav");
File blockDropSound=new File("blockDrops.wav");

Clip blockDropClip;
Clip playSoundClip;
Clip gameMusicClip;
Clip endGameMusicClip;
Clip explosionSoundClip;
Clip multiExplosionSoundClip;

boolean rotatingObjectColliderFixerPass=true;
private void soundEffects() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

	
    AudioInputStream input=AudioSystem.getAudioInputStream(gameMusic);
    gameMusicClip=AudioSystem.getClip();
    gameMusicClip.open(input);
    
    AudioInputStream input1=AudioSystem.getAudioInputStream(endGameMusic);
    endGameMusicClip=AudioSystem.getClip();
    endGameMusicClip.open(input1);
    
    AudioInputStream input2=AudioSystem.getAudioInputStream(explosionSound);
    explosionSoundClip=AudioSystem.getClip();
    explosionSoundClip.open(input2);
    
    AudioInputStream input3=AudioSystem.getAudioInputStream(playySound);
    playSoundClip=AudioSystem.getClip();
    playSoundClip.open(input3);
    
    AudioInputStream input4=AudioSystem.getAudioInputStream(multiExplosionSound);
    multiExplosionSoundClip=AudioSystem.getClip();
    multiExplosionSoundClip.open(input4);
    
    AudioInputStream input5=AudioSystem.getAudioInputStream(blockDropSound);
    blockDropClip=AudioSystem.getClip();
    blockDropClip.open(input5);
    
    
    
}

	public FirstScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		soundEffects();
		
		
//		Timer timer=new Timer();
//		TimerTask task=new TimerTask() {
//
//			@Override
//			public void run() {
//				
//String url="";
//			
//url="narutoImage"+count+".png";
//				//System.out.println(url);
//
//narutoGifImage=new ImageIcon(url);
//				narutoLabel.setIcon(narutoGifImage);
//			
//			
//count++;
//		
//if(count>=36)count=1;
//						
//				
//			}
//		
//			
//		
//		};
//		
//		timer.schedule(task, 0, 50);
		
//		int dice=random.nextInt(0,2);
//		if(dice==1)narutoGif=new ImageIcon("spaceBackground3.png");
		
//		 block=blockTypes[random.nextInt(0,7)];
//		blockImage=new ImageIcon(block.image);
//		blockLabel.setIcon(blockImage);
		
		
		
		
		nextTextLabel.setFont(new Font("Consolas",Font.PLAIN,70));
		nextTextLabel.setForeground(new Color(0,225,100));
		
		scoreLabel.setFont(new Font("Consolas",Font.PLAIN,60));
		scoreLabel.setForeground(new Color(0,225,100));
		scoreLabel1.setFont(new Font("Consolas",Font.PLAIN,60));
		scoreLabel1.setForeground(new Color(0,225,100));
		
		highestScoreLabel.setFont(new Font("Consolas",Font.PLAIN,60));
		highestScoreLabel.setForeground(new Color(0,225,100));
		highestScoreLabel1.setFont(new Font("Consolas",Font.PLAIN,60));
		highestScoreLabel1.setForeground(new Color(0,225,100));
		
		
		
		frameLabel.setIcon(frameImage);
		
		narutoLabel.setIcon(narutoGifImage);
		narutoLabel.setBounds(0, 0, 1440, 1000);
		
		
		tetrisTextLabel.setIcon(tetrisTextImage);
		tetrisTextLabel.setBounds((1440-500)/2-200, 100, 900 , 300);
		
		playButtonLabel.setIcon(playButtonImage);
		playButtonLabel.setBounds(590, 450, 230, 67);
		playButtonLabel.addMouseListener(this);
		
		
	
		frame.setVisible(true);
		frame.setSize(1440,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(tetrisTextLabel);
		frame.add(playButtonLabel);
		frame.add(narutoLabel);
		frame.setLayout(null);
		frame.addKeyListener(this);
		
		
	}
	
	
	
	
	
	








//	private void multiKeyController() {
//		
//Timer timer=new Timer();
//
//TimerTask task=new TimerTask() {
//
//	@Override
//	public void run() {
//		multipleKey();
//		
//	}
//	
//};
//
//timer.schedule(task, 0,1000);
//		
//	}







	private void gameScreen() {
	
		frameLabel.setBounds(356, -310, 823, 1407);
		scoreLabel1.setBounds(802, 200, 800, 600);
		scoreLabel.setBounds(820, 276, 800, 600);
		nextTextLabel.setBounds(820,-150,800,600);
		nextBlockLabel.setIcon(new ImageIcon(""));
		nextBlockLabel.setBounds(800, 220, 154, 76);
		
		//blockLabel.setBounds(365, 73, block.length, block.length);
		frame.add(frameLabel);
		frame.add(scoreLabel);
		frame.add(scoreLabel1);
frame.add(nextTextLabel);

frame.add(nextBlockLabel);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(narutoLabel);
		frame.setVisible(false);
		frame.setVisible(true);
	
		
		
		
		
		
		TimerTask task=new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				update();
			}
			
		};
		
		timer.schedule(task, 1000, 15);
		
		
		
		

		
		
		TimerTask task1=new TimerTask() {

			@Override
			public void run() {
				if(gameMusicClip.getMicrosecondLength()==gameMusicClip.getMicrosecondPosition() || gameMusicClip.isRunning()==false) {
					gameMusicClip.setMicrosecondPosition(0);
					String url=gameMusic.getPath();
					
					//System.out.println(url);
					
					if(url.equals("demonSlayerOpening.wav")) {
						
						
						gameMusic=new File("JJK_Specialz.wav");
					
					}
					else if(url.equals("onePieceDrumsOfLiberation.wav")) {
						
						
						gameMusic=new File("demonSlayerOpening.wav");
					}
					else
						
						gameMusic=new File("onePieceDrumsOfLiberation.wav");
					
					
					  AudioInputStream input=null;
					try {
						
						input = AudioSystem.getAudioInputStream(gameMusic);
					} catch (UnsupportedAudioFileException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					    try {
							gameMusicClip=AudioSystem.getClip();
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    try {
							gameMusicClip.open(input);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						} 
					    
					
				gameMusicClip.start();
				}
				// TODO Auto-generated method stub
				try {
					fall();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				explosion();
			}
			
			
		};
		
		timer.schedule(task1, 1000, 200);
		
		
		
	}
	
	private void update(){
		
//		frame.remove(narutoLabel);
		
		
		if(pass) {                                                 pass=false;
			
		
		
			turn=1;
			//int num=(765-365)/10;
			int upperBound=10;
		int lowerBound=365;
			
		if(oneTimePass) { oneTimePass=false;
		blockQueue.add(blockTypes[random.nextInt(0,7)]);
		
		}

			int blockNum=random.nextInt(0,7);
			blockQueue.offer(blockTypes[blockNum]);
			
		 block=blockQueue.poll();
		 
			 nextBlock=blockQueue.peek();
		 //System.out.println(blockNum);
		 
		 switch(block.color) {
		 case "yellow":  upperBound-=2;       break;
		 case "red":    upperBound-=3;       break;
		 case "blue":        upperBound-=3;      break;
		 case "lightBlue":       upperBound-=4;       break;
		 case "green":        upperBound-=3;      break;
		 case "purple":     upperBound-=3; lowerBound+=block.length;         break;
		 case "orange":       upperBound-=3;       break;
		 }
		 
		 
		 switch(nextBlock.color) {
		 case "yellow":  nextBlockLabel.setIcon(new ImageIcon("fullYellowBlock.png"));  nextBlockLabel.setBounds(865, 220, 154, 76);	 	 break;
		 case "red":     nextBlockLabel.setIcon(new ImageIcon("fullRedBlock.png"));    nextBlockLabel.setBounds(850, 220, 154, 76);   break;
		 case "blue":          nextBlockLabel.setIcon(new ImageIcon("fullBlueBlock.png")); nextBlockLabel.setBounds(845, 220, 154, 76);        break;
		 case "lightBlue":         nextBlockLabel.setIcon(new ImageIcon("fullLightBlueBlock.png"));    nextBlockLabel.setBounds(835, 220, 154, 76);       break;
		 case "green":          nextBlockLabel.setIcon(new ImageIcon("fullGreenBlock.png"));        nextBlockLabel.setBounds(850, 220, 154, 76);  break;
		 case "purple":       nextBlockLabel.setIcon(new ImageIcon("fullPurpleBlock.png"));   nextBlockLabel.setBounds(850, 220, 154, 76);  break;
		 case "orange":        nextBlockLabel.setIcon(new ImageIcon("fullOrangeBlock.png"));  nextBlockLabel.setBounds(845, 220, 154, 76);     break;
		 }
		
		 	x=lowerBound+random.nextInt(0,upperBound)*block.length;
			
			y=73;
		 
		
		 blocks= block.shape(x, y,turn);
		
		 
		 
		 blockLabels=new JLabel[4];
		 //narutoLabel.setBounds(0, 0, 0, 0);
		 
		 
		 for(int i=0;i<4;i++) {
		
			 
			 blockLabels[i]=new JLabel();
			 blockLabels[i].setIcon(new ImageIcon(blocks[i].image));
			 blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
			 frame.add(blockLabels[i]);
		 }
		 
		 
		
		 passMove=true;
		 
		 
//				 blockLabelList.put(blockLabels.toString(), blockLabels);
		 narutoLabel.setBounds(0, 0, 1440, 1000);
		 frame.remove(narutoLabel);
		frame.add(narutoLabel);	 
		
     
		
		
		
		 block.mainPass=pass;
		 
		}

		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	}
	
	

	private void fall() throws IOException {
		
		
		if(passMove==false) return;
		
		for(int j=0;j<4;j++) {
			 
			//boolean occupied=space[(blocks[j].x-365)/20 +1][(blocks[j].y-67)/20] ;
			
			if((blocks[j].y-y)/block.length<0) {blocks=block.shape(blocks[0].x, blocks[0].y+40,turn);
			
			
			for(int k=0;k<4;k++) {
				 
				blockLabels[k].setBounds(blocks[j].x, blocks[k].y, blocks[k].length, blocks[k].length);
				
			 }
			
			}
			
			if(blocks[j].y>=640+y ||(blocks[j].y-y)/block.length ==15 || (blocks[j].x-365)/block.length<0 ||space[(blocks[j].y-y)/block.length +1][(blocks[j].x-365)/block.length]==true) {
				passMove=false;
				pass=true;
				block.mainPass=pass;
				
				for(int i=0;i<blocks.length;i++) {
					
					

					
					int column=(blocks[i].x-365)/block.length;                                           blocks[i].column=column;
					int row=(blocks[i].y-y)/block.length;                          blocks[i].row=row;
					
					if(row<0 && endgamePass==false) { endgame(); return;}
					space[row][column]=true;
					//System.out.println("row "+row +"    column "+column);
					String key=row+"/"+column;
					
					 blockLabelTable.put(key, blockLabels[i]);
				}
				 if(blockDropClip.getMicrosecondLength()==blockDropClip.getMicrosecondPosition() || blockDropClip.isRunning()==false) {
					 blockDropClip.setMicrosecondPosition(0);
					 blockDropClip.start();
					}
				
				return;
			}
		 }
		
		
		
		
		blocks=block.shape(blocks[0].x, blocks[0].y+40,turn);
		
		
		for(int j=0;j<4;j++) {
			 
			blockLabels[j].setBounds(blocks[j].x, blocks[j].y, blocks[j].length, blocks[j].length);
			
		 }
		

		
		
		
		
		
		
		
		
		
	}







private void explosion() {
	int explosiveRow=-1;
	
	
	for(int row=space.length-1;row>=0;row--) { boolean explode=true;     boolean pass=false;
	
		for(int column=0;column<space[row].length;column++) {
			if(pass)continue;
			
			if(space[row][column]==false) {
				
				
				explode=false;
				pass=true;
				
			}
		}
		
		if(explode==true) {//omitting the complete row
			
			if(explosionSoundClip.getMicrosecondLength()==explosionSoundClip.getMicrosecondPosition() || explosionSoundClip.isRunning()==false) {
				explosionSoundClip.setMicrosecondPosition(0);
				explosionSoundClip.start();
			}
			
			if(explosionTimer1!=0 && explosionTimer-explosionTimer1<=1) {
				score+=200;
				if(multiExplosionSoundClip.getMicrosecondPosition()== multiExplosionSoundClip.getMicrosecondLength() ||multiExplosionSoundClip.isRunning()==false) {
					multiExplosionSoundClip.setMicrosecondPosition(0);
					multiExplosionSoundClip.start();
				}
					
				
		 scoreLabel.setText((score/1000+""+((score/100)%10)+""+((score/10)%10)+""+(score%10))); 
			}
			else {
				score+=100;
				 scoreLabel.setText((score/1000+""+((score/100)%10)+""+((score/10)%10)+""+(score%10))); 
			}
			
			explosiveRow=row;
			explosionTimer1=explosionTimer;
			
			//System.out.println("explosiveRow "+explosiveRow);
			
			int digit=(int)Math.log10(explosiveRow)+1;
			
			String rowKey=explosiveRow+"";
			
			String key1="";
			
			int labelRow=-1;
			int labelColumn=-1;
//			
//			Hashtable<String,JLabel>table=new Hashtable<>();
//			table=blockLabelTable;
			
		
			
			
			for(int i=0;i<space.length;i++) {
				String key=rowKey+"/"+i;
				if(blockLabelTable.get(key)==null)continue;
				
				int index=key.indexOf('/');
				
				key1=key.substring(0,index);
				
//				System.out.println(key1+" key1");
//				System.out.println(rowKey+" rowKey");
				if(key1.equals(rowKey)) {
					
					
				labelRow=Integer.parseInt(key1);
				labelColumn=Integer.parseInt(key.substring(index+1));
				
				
				space[labelRow][labelColumn]=false;	
					blockLabelTable.get(key).setBounds(-1000, -1000, 0, 0);
					
				
					
					blockLabelTable.remove(key);
				    //frame.remove(blockLabelTable.get(key));
				}
				
			}
			
		       //key1=explosiveRow+"";
			        
			     
			
		       for(int row1=space.length-1;row1>=0;row1--) {
		    	   
					
					
					
					
                	  
				
				if(row1<explosiveRow) {
					 for(int column1=space[row1].length-1;column1>=0;column1--) {
						 
						 String keyValue=row1+"/"+column1;
							
							
					if(blockLabelTable.get(keyValue)==null || space[row1][column1]==false)continue;
//					System.out.println("key2 "+key2);
//					System.out.println("key1 "+key1);
					
					space[row1][column1]=false;	
					String newKeyValue;  
					
int count=0;
					do {
					
					
					
					 newKeyValue=(row1+1+count)+"/"+column1;
	
					
					blockLabelTable.get(keyValue).setBounds(blockLabelTable.get(keyValue).getX(), blockLabelTable.get(keyValue).getY()+block.length, block.length, block.length);
					 
					count++;
					}while(row1+1+count<space.length && space[row1+1+count][column1]==false);
					blockLabelTable.put(newKeyValue,blockLabelTable.get(keyValue));
					
					blockLabelTable.remove(keyValue);
					
					space[row1+count][column1]=true;	
					
					 }
				}
				
				
				
			}
			
			
			
			
			
		}
	}
	
	
	explosionTimer++;
	
}


	
	
	
	
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==playButtonLabel) {
			
			playSoundClip.start();
		ImageIcon image=new ImageIcon("tetrisPlayPressed.png");
		playButtonLabel.setIcon(image);
		playButtonLabel.setBounds(playButtonLabel.getX()+10, playButtonLabel.getY()+3, 210, 61);
		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.getSource()==playButtonLabel) {
			if(playButtonLabel.isValid()) {
			playButtonLabel.setIcon(playButtonImage);
			playButtonLabel.setBounds(590, 450, 230, 67);

			
			
			TimerTask task=new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					playButtonLabel.setBounds(0,0,-1000, 1000);
					tetrisTextLabel.setBounds(0,0,-1000, 1000);
					frame.remove(playButtonLabel);
					frame.remove(tetrisTextLabel);
					frame.remove(narutoLabel);
//					frame.setVisible(false);
//					frame.setVisible(true);
					
					
					gameScreen();
				}

				
				
			};
			timer.schedule(task, 500);
			
			
			}
		}
		
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}







	@Override
	public void keyPressed(KeyEvent e) {//39 right    38 up     37 left    40 down     68 d
		
		if(passMove==false || endgamePass) return;//if passMove==false return
		int count=0;
		
//		for(int i=2;i<activeKey.length;i++)
//			if(activeKey[i]==true)count++;
//		
//		if(count>1) {
//			keyPressFixertimer.cancel();
//			
//		}
//		
//		else keyPressFixerPass=true;
		
		
		if(keyPressFixerPass) {
			keyPressFixer(e);
			keyPressFixerPass=false;
		}

		
		int hashCode=e.getKeyCode();
		int speed=40;
	if(hashCode==39) {//right
		
		for(int j=0;j<4;j++) {
			//boolean occupied=space[(blocks[j].x-365)/20][(blocks[j].y-67)/20 +1] ;
			
			if((blocks[j].y-y)/block.length>=0)
			   if(!(blocks[j].x<=725) || (blocks[j].x-365)/block.length==9|| space[(blocks[j].y-y)/block.length][(blocks[j].x-365)/block.length+1]==true) {
				   return;
			   }
		 }

	   activeKey[39]=true;
	   leader=new boolean[69];
leader[hashCode]=true;

	   
		blocks=block.shape(blocks[0].x+speed, blocks[0].y,turn);
		
		
		for(int i=0;i<4;i++) {
			 
			blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
			//System.out.println("block "+i+" "+blocks[i].x);
		 }
	}
	
//	else if(hashCode==38) {//up
//		
//blocks=block.shape(blocks[0].x, blocks[0].y-speed);
//		
//		
//		for(int i=0;i<4;i++) {
//			 
//			blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
//			
//		 }
//		
//	}
//	
	
	else if(hashCode==37) {//left
		
		
		for(int j=0;j<4;j++) {
			//boolean occupied=space[(blocks[j].x-365)/20][(blocks[j].y-67)/20 -1] ;
			if((blocks[j].y-y)/block.length>=0)
			   if( !(blocks[j].x>365) || (blocks[j].x-365)/block.length==0|| space[(blocks[j].y-y)/block.length][(blocks[j].x-365)/block.length-1]==true ) {
				   
				   return;
			   }
		 }
		 activeKey[37]=true;
		 leader=new boolean[69];
		 leader[hashCode]=true;
		 
		blocks=block.shape(blocks[0].x-speed, blocks[0].y,turn);
		
		
		for(int i=0;i<4;i++) {
			 
			blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
			
		 }
		
		//if()
		
	}
	
	else if(hashCode==40 ) {//down
		

		
		for(int j=0;j<4;j++) {
			 
			//boolean occupied=space[(blocks[j].x-365)/20 +1][(blocks[j].y-67)/20] ;
			
			if((blocks[j].y-y)/block.length>=0)
			if(blocks[j].y>=y+15*block.length ||space[(blocks[j].y-y)/block.length +1][(blocks[j].x-365)/block.length]==true) {
				return;
			}
		 }
		activeKey[40]=true;
		leader=new boolean[69];
		leader[hashCode]=true;
		
		
blocks=block.shape(blocks[0].x, blocks[0].y+speed,turn);
		

		
		for(int i=0;i<4;i++) {
			 
			blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
			
		 }
	}
	
	
	else if(hashCode==68) {//rotate
		
		

		
		//rotatingObjectColliderFixer(e,hashCode);
		
		
		activeKey[68]=true;
		leader=new boolean[69];
		leader[hashCode]=true;
	
	turn++;
	
	if(turn==5) turn=1;
	
	blocks=block.shape(blocks[0].x, blocks[0].y,turn);
	
	rotateFixer();

	
	for(int i=0;i<4;i++) {
		 
		blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
		
	 }
	}
	
	
	multipleKeys(e,hashCode);
	
	rotatingObjectColliderFixer(e,hashCode);
		
		
		
	
	
	}







	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()<=68) {
		 activeKey[e.getKeyCode()]=false;
		if(leader[e.getKeyCode()]==true)leader[e.getKeyCode()]=false;
		}
		
		
	}

	private void keyPressFixer(KeyEvent e) {
		KeyEvent keyEvent=e;
		keyEvent.setKeyCode(1);
		
		//Timer timer=new Timer();
		
		TimerTask task=new TimerTask() {

			@Override
			public void run() {
				int count=0;
				for(int i=37;i<activeKey.length;i++) {
					if(activeKey[i]==true && leader[i]==false) count++;
					if(leader[i]==true)return;
				}
				
				if(count==0 ) return;

					
										
				
				keyPressed(keyEvent);
				
				
			}
			
		};
		timer.schedule(task, 0, 30);
		
	}
	
	private void multipleKeys(KeyEvent e,int keyCode) {
		
//System.out.println("multipleKeys working "+keyCode);
		
		
		int speed=block.length;
		
		if(activeKey[37]==true && keyCode!=37) {
			
			for(int j=0;j<4;j++) {
				//boolean occupied=space[(blocks[j].x-365)/20][(blocks[j].y-67)/20 -1] ;
				if((blocks[j].y-y)/block.length>=0)
				   if( !(blocks[j].x>365)  || (blocks[j].x-365)/block.length ==0|| space[(blocks[j].y-y)/block.length][(blocks[j].x-365)/block.length-1]==true || endgamePass) {
					   
					   return;
				   }
			 }
			
			
			blocks=block.shape(blocks[0].x-speed, blocks[0].y,turn);
			
			
			for(int i=0;i<4;i++) {
				 
				blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
				
			 }
			
		}


if(activeKey[39]==true && keyCode!=39) {
	
	for(int j=0;j<4;j++) {
		//boolean occupied=space[(blocks[j].x-365)/20][(blocks[j].y-67)/20 +1] ;
		
		if((blocks[j].y-y)/block.length>=0)
		   if(!(blocks[j].x<=725) || (blocks[j].x-365)/block.length==9|| space[(blocks[j].y-y)/block.length][(blocks[j].x-365)/block.length+1]==true) {
			   return;
		   }
	 }

  
	
	blocks=block.shape(blocks[0].x+speed, blocks[0].y,turn);
	
	
	for(int i=0;i<4;i++) {
		 
		blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
		//System.out.println("block "+i+" "+blocks[i].x);
	 }
	
}

if(activeKey[40]==true && keyCode!=40) {
	
	

	
	for(int j=0;j<4;j++) {
		 
		//boolean occupied=space[(blocks[j].x-365)/20 +1][(blocks[j].y-67)/20] ;
		
		if((blocks[j].y-y)/block.length>=0)
		if(blocks[j].y>=y+15*block.length || (blocks[j].y-y)/block.length==9 ||space[(blocks[j].y-y)/block.length +1][(blocks[j].x-365)/block.length]==true) {
			return;
		}
	 }
	
	
blocks=block.shape(blocks[0].x, blocks[0].y+speed,turn);
	

	
	for(int i=0;i<4;i++) {
		 
		blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
		
	 }
}

if(activeKey[68]==true && keyCode!=68) {
	
	
	
	 
	
	
	
	
	
turn++;

if(turn==5) turn=1;

blocks=block.shape(blocks[0].x, blocks[0].y,turn);

rotateFixer();



for(int i=0;i<4;i++) {
	 
	blockLabels[i].setBounds(blocks[i].x, blocks[i].y, blocks[i].length, blocks[i].length);
	
 }

rotatingObjectColliderFixer(e,keyCode);

}
		
	}
	
	private void rotateFixer() { // to be called after the change in blocks attribute coordinates and before the change in block label's coordinates.
		
		for(int i=0;i<4;i++) {
			 
			int x=blocks[i].x;
			int y=blocks[i].y;
			
			int row=(y-this.y)/block.length;
			int column=(x-365)/block.length;
			
			//if(!(blocks[i].y<667) ||!(blocks[i].x>365) || !(blocks[i].x<=755) || space[row][column]==true) {
			
			
			
			if(!(blocks[i].y<600+this.y)) {
				while(!(blocks[i].y<600+this.y))
				blocks=block.shape(blocks[0].x, blocks[0].y-block.length,turn);
			}
			
			if(!(blocks[i].x>=365)) { 
				
				
				
				while(!(blocks[i].x>=365))
					blocks=block.shape(blocks[0].x+block.length, blocks[0].y,turn);
			}
			
			if(!(blocks[i].x<=725)) {
				while(!(blocks[i].x<=725))
					blocks=block.shape(blocks[0].x-block.length, blocks[0].y,turn);
			}
			
//			if(space[row][column]==true)
//				for(int j=1;j<4;j++) {
//					
//					int fakeTurn=turn+j;
//					
//					if(fakeTurn>=5) fakeTurn-=4;
//					
//					System.out.println(fakeTurn);
//					blocks=block.shape(blocks[0].x, blocks[0].y,fakeTurn);
//				}
			
			
		 }
	}
	
      private void rotatingObjectColliderFixer(KeyEvent e, int hashCode) {// broken method (thus, there is a bug)
    	 
    	  
    	  if(rotatingObjectColliderFixerPass==false) return ;
    	  rotatingObjectColliderFixerPass=false; 
    		
    	
    		
    		for(int i=0;i<4;i++) {
    			
    			int x=blocks[i].x;
    			int y=blocks[i].y;
    			
    			int row=(y-this.y)/block.length;
    			int column=(x-365)/block.length;
    			
    			//boolean occupied=space[x][y];
    			
    			try {
    				
    			
    			if(space[row][column]==true) {
    				System.out.println("false is returned");
    				
    				for(int j=0;j<4;j++) {
    					
    					e.setKeyCode(hashCode);
    					keyPressed(e);
    				}
    			}
    			}
    			catch(ArrayIndexOutOfBoundsException ex) {
    				System.out.println("false is returned");
    				return ;
    			}
    			
    		 }
    		
    		
    		rotatingObjectColliderFixerPass=true;
      }
      
      
      
      
      
      
      
      
      
      
      
      
      

private void endgame() throws IOException {
	endgamePass=true;
	timer.cancel();
	playSoundClip.close();
gameMusicClip.close();
explosionSoundClip.close();
multiExplosionSoundClip.close();

endGameMusicClip.start();
	
	frame.setEnabled(false);
	frame.setVisible(false);
	
	FileReader reader=new FileReader("HighestScore.txt");
	
	
	String scoreText="";
	int score=reader.read();
	
	while(score!=-1) {
	 scoreText+=(char)score+"";
	score=reader.read();
	}
	
	

	highestScoreLabel1.setText("HIGHEST SCORE");
	highestScoreLabel.setText(scoreText);
	FileWriter writer=new FileWriter("HighestScore.txt");

	FileReader nameReader=new FileReader("Name.txt");
	
	int nameNum=nameReader.read();
	String name="";
	while(nameNum!=-1) {
		
		name+=(char)nameNum+"";
		nameNum=nameReader.read();
	}
	//System.out.println(name);
	if(Integer.parseInt(scoreText )< (Integer.parseInt(scoreLabel.getText()))) { //<
		
		writer.write(scoreLabel.getText());
		highestScoreLabel.setText(scoreLabel.getText());
		
		
		
		int ans=JOptionPane.showConfirmDialog(null, "Game Over, you got the heights score! Would you like to save your name ?");
		
		if(ans==0) {
		name=	JOptionPane.showInputDialog("Enter your name please ^^");
		
		
		FileWriter nameWriter=new FileWriter("Name.txt");
		
		nameWriter.write(name);
		nameWriter.close();
		}
		else {

			FileWriter nameWriter1=new FileWriter("Name.txt");
			
			name="Anonymous";
			nameWriter1.write(name);
			
		}
		
	}
	else {
		writer.write(scoreText);
		highestScoreLabel.setText(scoreText);
		
	}
	
	writer.close();
	reader.close();
	nameReader.close();

	
		
	JFrame frame=new JFrame("Tetris");
	
	frame.setVisible(true);
	frame.setSize(1440,1000);
	
	
	JLabel nameLabel=new JLabel("by "+name);
	
	nameLabel.setFont(new Font("Consolas",Font.ITALIC,50));
	nameLabel.setForeground(new Color(0,225,100));
	

	highestScoreLabel.setBounds((scoreLabel.getX()-230), scoreLabel.getY()-400, 800, 800);
	highestScoreLabel1.setBounds((scoreLabel1.getX()-350), scoreLabel1.getY()-400, 800, 800);
	
	
	nameLabel.setBounds((highestScoreLabel.getX()-15), highestScoreLabel.getY()+80, 800, 800);
	
	
		narutoLabel.setIcon(new ImageIcon("tetrisSpace.png"));
		scoreLabel.setBounds(scoreLabel.getX()-210, scoreLabel.getY()-150, 800, 800);
		scoreLabel1.setBounds(scoreLabel1.getX()-310, scoreLabel1.getY()-150, 800, 800);
		scoreLabel1.setText(" YOUR SCORE ");
		frame.add(nameLabel);
		frame.add(highestScoreLabel);
		frame.add(highestScoreLabel1);
		frame.add(scoreLabel);
		frame.add(scoreLabel1);
		frame.add(narutoLabel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	
		frame.setVisible(true);
		
		Timer timer1=new Timer();
		TimerTask task2=new TimerTask() {
			public void run() {
				// TODO Auto-generated method stub
				System.exit(1);
			}
			
		};
		
		timer1.schedule(task2, 15000);
		
	
			


		
	}

      
      
      
      
}
