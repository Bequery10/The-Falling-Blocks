

abstract class Block {
	private int baseX=0;
	private int baseY=0;
String color=null;
	String image=null;
	
	int x=0;
	int y=0;
	
	int length=40;

	int column=0; //0-42
	int row=0;    //0-64
	
	boolean []triggers=new boolean[4];
	
	boolean mainPass=true;
	
	
Block[]blocks=new YellowBlock[4];

boolean pass=false;
	
	protected Block[] shape(int x,int y,int turn) {
		String color=this.color;
		
		switch(color) {
		case "yellow":
			
			return yellowShape(x,y,turn);
				
			
			
		case"red":
			
			return redShape(x,y,turn);
			
		
			
case "purple":
			
	return	purpleShape(x,y,turn);
				
			
			
		case"green":
			
			return greenShape(x,y,turn);
			
		
			
case "lightBlue":
			
	return	lightBlueShape(x,y,turn);
				
			
			
		case"orange":
			
			return orangeShape(x,y,turn);
			
			
			
		case"blue":
			
			return	blueShape(x,y,turn);
			
			default:
				
				return null;
			
		}
	}
	
	
	



	private Block[] purpleShape(int x, int y,int turn) {
		


		Block[] blocks=new PurpleBlock[4];

		if(mainPass==true) pass=false;


			if(turn==1) {
				
				
				if(pass && triggers[0]==false){
			
					x-=length;
					y-=length;
				}
				
				
				blocks[0]=new PurpleBlock(x,y);
				blocks[1]=new PurpleBlock(x+length,y);
				blocks[2]=new PurpleBlock(x+length,y-length);
				blocks[3]=new PurpleBlock(x+2*length,y);
				
				
			}
			
			else if(turn==2) { 
				
				if(triggers[1]==false) {
					x+=length;
					y-=length;
				}
				
//				Block imaginaryBlock;
//				
//				imaginaryBlock=new PurpleBlock(x,y);

				blocks[0]=new PurpleBlock(x,y);
				blocks[1]=new PurpleBlock(x,y+length);
				blocks[2]=new PurpleBlock(x+length,y+length);
				blocks[3]=new PurpleBlock(x,y+2*length);
				
				
			}
			
			else if(turn==3) { 
				
				if(triggers[2]==false) {
					x+=length;
					y+=length;
					
				}
				
				blocks[0]=new PurpleBlock(x,y);
				blocks[1]=new PurpleBlock(x-length,y);
				blocks[2]=new PurpleBlock(x-length,y+length);
				blocks[3]=new PurpleBlock(x-2*length,y);
				
				
			}
			else if(turn==4) { pass=true;
				
				if(triggers[3]==false) {
					x-=length;
				    y+=length;
					
				}
				
				
				blocks[0]=new PurpleBlock(x,y);
				blocks[1]=new PurpleBlock(x,y-length);
				blocks[2]=new PurpleBlock(x-length,y-length);
				blocks[3]=new PurpleBlock(x,y-2*length);
				
				
			}

			triggers=new boolean[4];
			triggers[turn-1]=true;
			
		return blocks;
				
	}

	private Block[]  greenShape(int x, int y, int turn) {



Block[] blocks=new GreenBlock[4];

if(mainPass==true) pass=false;


if(turn==1) {
	
	
	if(pass && triggers[0]==false){

		x-=length;
		
	}
	
	
	blocks[0]=new GreenBlock(x,y);
	blocks[1]=new GreenBlock(x+length,y);
	blocks[2]=new GreenBlock(x+length,y-length);
	blocks[3]=new GreenBlock(x+2*length,y-length);
	
	
}

else if(turn==2) { 
	
	if(triggers[1]==false) {
		
		y-=length;
	}
	
//	Block imaginaryBlock;
//	
//	imaginaryBlock=new GreenBlock(x,y);

	blocks[0]=new GreenBlock(x,y);
	blocks[1]=new GreenBlock(x,y+length);
	blocks[2]=new GreenBlock(x+length,y+length);
	blocks[3]=new GreenBlock(x+length,y+2*length);
	
	
}

else if(turn==3) { 
	
	if(triggers[2]==false) {
		x+=length;
		
		
	}
	
	blocks[0]=new GreenBlock(x,y);
	blocks[1]=new GreenBlock(x-length,y);
	blocks[2]=new GreenBlock(x-length,y+length);
	blocks[3]=new GreenBlock(x-2*length,y+length);
	
	
}
else if(turn==4) { pass=true;
	
	if(triggers[3]==false) {
		
	    y+=length;
		
	}
	
	
	blocks[0]=new GreenBlock(x,y);
	blocks[1]=new GreenBlock(x,y-length);
	blocks[2]=new GreenBlock(x-length,y-length);
	blocks[3]=new GreenBlock(x-length,y-2*length);
	
	
}

triggers=new boolean[4];
triggers[turn-1]=true;

return blocks;
	
	}

	private Block[]  lightBlueShape(int x, int y,int turn) {




Block[] blocks=new LightBlueBlock[4];

if(mainPass==true) pass=false;


if(turn==1) {
	
	
	if(pass && triggers[0]==false){

		x-=2*length;
		y-=length;
	}
	
	
	blocks[0]=new LightBlueBlock(x,y);
	blocks[1]=new LightBlueBlock(x+length,y);
	blocks[2]=new LightBlueBlock(x+2*length,y);
	blocks[3]=new LightBlueBlock(x+3*length,y);
	
	
}

else if(turn==2) { 
	
	if(triggers[1]==false) {
		x+=length;
		y-=2*length;
	}
	
//	Block imaginaryBlock;
//	
//	imaginaryBlock=new LightBlueBlock(x,y);

	blocks[0]=new LightBlueBlock(x,y);
	blocks[1]=new LightBlueBlock(x,y+length);
	blocks[2]=new LightBlueBlock(x,y+2*length);
	blocks[3]=new LightBlueBlock(x,y+3*length);
	
	
}

else if(turn==3) { 
	
	if(triggers[2]==false) {
		x+=2*length;
		y+=2*length;
		
	}
	
	blocks[0]=new LightBlueBlock(x,y);
	blocks[1]=new LightBlueBlock(x-length,y);
	blocks[2]=new LightBlueBlock(x-2*length,y);
	blocks[3]=new LightBlueBlock(x-3*length,y);
	
	
}
else if(turn==4) { pass=true;
	
	if(triggers[3]==false) {
		x-=length;
	    y+=2*length;
		
	}
	
	
	blocks[0]=new LightBlueBlock(x,y);
	blocks[1]=new LightBlueBlock(x,y-length);
	blocks[2]=new LightBlueBlock(x,y-2*length);
	blocks[3]=new LightBlueBlock(x,y-3*length);
	
	
}

triggers=new boolean[4];
triggers[turn-1]=true;

return blocks;
	
	}

	private Block[]  orangeShape(int x, int y, int turn) {
		 


	


Block[] blocks=new OrangeBlock[4];

if(mainPass==true) pass=false;


	if(turn==1) {
		
		
		if(pass && triggers[0]==false){
	
			x-=length;
			
		}
		
		
		blocks[0]=new OrangeBlock(x,y);
		blocks[1]=new OrangeBlock(x+length,y);
		blocks[2]=new OrangeBlock(x+2*length,y);
		blocks[3]=new OrangeBlock(x+2*length,y-length);
		
		
	}
	
	else if(turn==2) { 
		
		if(triggers[1]==false) {
			
			y-=length;
		}
		
//		Block imaginaryBlock;
//		
//		imaginaryBlock=new OrangeBlock(x,y);

		blocks[0]=new OrangeBlock(x,y);
		blocks[1]=new OrangeBlock(x,y+length);
		blocks[2]=new OrangeBlock(x,y+2*length);
		blocks[3]=new OrangeBlock(x+length,y+2*length);
		
		
	}
	
	else if(turn==3) { 
		
		if(triggers[2]==false) {
			x+=length;
			
			
		}
		
		blocks[0]=new OrangeBlock(x,y);
		blocks[1]=new OrangeBlock(x-length,y);
		blocks[2]=new OrangeBlock(x-2*length,y);
		blocks[3]=new OrangeBlock(x-2*length,y+length);
		
		
	}
	else if(turn==4) { pass=true;
		
		if(triggers[3]==false) {
			
		    y+=length;
			
		}
		
		
		blocks[0]=new OrangeBlock(x,y);
		blocks[1]=new OrangeBlock(x,y-length);
		blocks[2]=new OrangeBlock(x,y-2*length);
		blocks[3]=new OrangeBlock(x-length,y-2*length);
		
		
	}

	triggers=new boolean[4];
	triggers[turn-1]=true;
	
return blocks;
		
		
	}

	private Block[]  blueShape(int x, int y, int turn) {
		


Block[] blocks=new BlueBlock[4];

if(mainPass==true) pass=false;


	if(turn==1) {
		
		
		if(pass && triggers[0]==false){
	
			x-=length;
			y-=2*length;
		}
		
		
		blocks[0]=new BlueBlock(x,y);
		blocks[1]=new BlueBlock(x,y+length);
		blocks[2]=new BlueBlock(x+length,y+length);
		blocks[3]=new BlueBlock(x+2*length,y+length);
		
		
	}
	
	else if(turn==2) { 
		
		if(triggers[1]==false) {
			x+=2*length;
			y-=length;
		}
		
//		Block imaginaryBlock;
//		
//		imaginaryBlock=new BlueBlock(x,y);

		blocks[0]=new BlueBlock(x,y);
		blocks[1]=new BlueBlock(x-length,y);
		blocks[2]=new BlueBlock(x-length,y+length);
		blocks[3]=new BlueBlock(x-length,y+2*length);
		
		
	}
	
	else if(turn==3) { 
		
		if(triggers[2]==false) {
			x+=length;
			y+=2*length;
			
		}
		
		blocks[0]=new BlueBlock(x,y);
		blocks[1]=new BlueBlock(x,y-length);
		blocks[2]=new BlueBlock(x-length,y-length);
		blocks[3]=new BlueBlock(x-2*length,y-length);
		
		
	}
	else if(turn==4) { pass=true;
		
		if(triggers[3]==false) {
			x-=2*length;
		    y+=length;
			
		}
		
		
		blocks[0]=new BlueBlock(x,y);
		blocks[1]=new BlueBlock(x+length,y);
		blocks[2]=new BlueBlock(x+length,y-length);
		blocks[3]=new BlueBlock(x+length,y-2*length);
		
		
	}

	triggers=new boolean[4];
	triggers[turn-1]=true;
	
return blocks;
		
	}

	private Block[] redShape(int x, int y, int turn) {
		
		
		Block[] blocks=new RedBlock[4];
		
if(mainPass==true) pass=false;
	
		
			if(turn==1) {
				
				
				if(pass && triggers[0]==false){
			
					x-=length;
					y-=length;
				}
				
				
				blocks[0]=new RedBlock(x,y);
				blocks[1]=new RedBlock(x+length,y);
				blocks[2]=new RedBlock(x+length,y+length);
				blocks[3]=new RedBlock(x+2*length,y+length);
				
				
			}
			
			else if(turn==2) { 
				
				if(triggers[1]==false) {
					x+=2*length;
					y-=length;
				}
				
//				Block imaginaryBlock;
//				
//				imaginaryBlock=new RedBlock(x,y);

				blocks[0]=new RedBlock(x,y);
				blocks[1]=new RedBlock(x,y+length);
				blocks[2]=new RedBlock(x-length,y+length);
				blocks[3]=new RedBlock(x-length,y+2*length);
				
				
			}
			
			else if(turn==3) { 
				
				if(triggers[2]==false) {
					
					y+=2*length;
					
				}
				
				blocks[0]=new RedBlock(x,y);
				blocks[1]=new RedBlock(x-length,y);
				blocks[2]=new RedBlock(x-length,y-length);
				blocks[3]=new RedBlock(x-2*length,y-length);
				
				
			}
			else if(turn==4) { pass=true;
				
				if(triggers[3]==false) {
					x-=length;
				
					
				}
				
				
				blocks[0]=new RedBlock(x,y);
				blocks[1]=new RedBlock(x,y-length);
				blocks[2]=new RedBlock(x+length,y-length);
				blocks[3]=new RedBlock(x+length,y-2*length);
				
				
			}
		
			triggers=new boolean[4];
			triggers[turn-1]=true;
		
			
		return blocks;
	}

	public Block[] yellowShape(int x, int y,int turn) { //square
		
		
		

		
		Block[] blocks=new YellowBlock[4];
		
if(mainPass==true) pass=false;
	
		
			if(turn==1) {
				
				
				if(pass && triggers[0]==false){
			
					
					y-=length;
					
				}
				
				
				blocks[0]=new YellowBlock(x,y);
				blocks[1]=new YellowBlock(x+length,y);
				blocks[2]=new YellowBlock(x+length,y+length);
				blocks[3]=new YellowBlock(x,y+length);
				
				
			}
			
			else if(turn==2) { 
				
				if(triggers[1]==false) {
					
					x+=length;
				}
				
				
				
				blocks[0]=new YellowBlock(x,y);
				blocks[1]=new YellowBlock(x,y+length);
				blocks[2]=new YellowBlock(x-length,y+length);
				blocks[3]=new YellowBlock(x-length,y);
				
			
				
			}
			
			else if(turn==3) { 
				
           if(triggers[2]==false) {
	               

					y+=length;
				}
				
				
				
				blocks[0]=new YellowBlock(x,y);
				blocks[1]=new YellowBlock(x-length,y);
				blocks[2]=new YellowBlock(x-length,y-length);
				blocks[3]=new YellowBlock(x,y-length);
				
				
			}
			else if(turn==4) { pass=true;
				
				if(triggers[3]==false) {
					
					x-=length;
				}
				
				blocks[0]=new YellowBlock(x,y);
				blocks[1]=new YellowBlock(x,y-length);
				blocks[2]=new YellowBlock(x+length,y-length);
				blocks[3]=new YellowBlock(x+length,y);
				
				
				
			}
		
			triggers=new boolean[4];
			triggers[turn-1]=true;
			
		return blocks;
	}
		
//		
//		
//		
//		protected Block[] shape(int x,int y,int turn,boolean test) {
//			String color=this.color;
//			
//			switch(color) {
//			case "yellow":
//				
//				return yellowShape(x,y,turn,test);
//					
//				
//				
//			case"red":
//				
//				return redShape(x,y,turn,test);
//				
//			
//				
//	case "purple":
//				
//		return	purpleShape(x,y,test);
//					
//				
//				
//			case"green":
//				
//				return greenShape(x,y,test);
//				
//			
//				
//	case "light blue":
//				
//		return	lightBlueShape(x,y,test);
//					
//				
//				
//			case"orange":
//				
//				return orangeShape(x,y,test);
//				
//				
//				
//			case"blue":
//				
//				return	blueShape(x,y,turn,test);
//				
//				default:
//					
//					return null;
//				
//			}
//		}
//		
//		
//		
//
//
//
//		private Block[] purpleShape(int x2, int y2, boolean test) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		private Block[]  greenShape(int x, int y, boolean test) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		private Block[]  lightBlueShape(int x, int y, boolean test) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		private Block[]  orangeShape(int x, int y, boolean test) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		private Block[]  blueShape(int x, int y, int turn, boolean test) {
//			
//
//
//	Block[] blocks=new BlueBlock[4];
//
//	
//
//
//		if(turn==1) {
//			
//			
//		
//				x-=length;
//				y-=2*length;
//			
//			
//			
//			blocks[0]=new BlueBlock(x,y);
//			blocks[1]=new BlueBlock(x,y+length);
//			blocks[2]=new BlueBlock(x+length,y+length);
//			blocks[3]=new BlueBlock(x+2*length,y+length);
//			
//			
//		}
//		
//		else if(turn==2) { 
//			
//			x+=2*length;
//			y-=length;
//
//			blocks[0]=new BlueBlock(x,y);
//			blocks[1]=new BlueBlock(x-length,y);
//			blocks[2]=new BlueBlock(x-length,y+length);
//			blocks[3]=new BlueBlock(x-length,y+2*length);
//			
//			
//		}
//		
//		else if(turn==3) { 
//			
//			x+=length;
//			y+=2*length;
//			
//			blocks[0]=new BlueBlock(x,y);
//			blocks[1]=new BlueBlock(x,y-length);
//			blocks[2]=new BlueBlock(x-length,y-length);
//			blocks[3]=new BlueBlock(x-2*length,y-length);
//			
//			
//		}
//		else if(turn==4) { 
//			
//			x-=2*length;
//		    y+=length;
//			
//			blocks[0]=new BlueBlock(x,y);
//			blocks[1]=new BlueBlock(x+length,y);
//			blocks[2]=new BlueBlock(x+length,y-length);
//			blocks[3]=new BlueBlock(x+length,y-2*length);
//			
//			
//		}
//
//		
//		
//	return blocks;
//			
//		}
//
//		private Block[] redShape(int x, int y, int turn , boolean test) {
//			
//			
//			Block[] blocks=new RedBlock[4];
//		
//			
//				if(turn==1) {
//					
//					
//				
//				
//						x-=length;
//						y-=length;
//					
//					
//					
//					blocks[0]=new RedBlock(x,y);
//					blocks[1]=new RedBlock(x+length,y);
//					blocks[2]=new RedBlock(x+length,y+length);
//					blocks[3]=new RedBlock(x+2*length,y+length);
//					
//					
//				}
//				
//				else if(turn==2) { 
//					
//					
//						x+=2*length;
//						y-=length;
//					
//					
////					Block imaginaryBlock;
////					
////					imaginaryBlock=new RedBlock(x,y);
//
//					blocks[0]=new RedBlock(x,y);
//					blocks[1]=new RedBlock(x,y+length);
//					blocks[2]=new RedBlock(x-length,y+length);
//					blocks[3]=new RedBlock(x-length,y+2*length);
//					
//					
//				}
//				
//				else if(turn==3) { 
//					
//						
//						y+=2*length;
//						
//					
//					
//					blocks[0]=new RedBlock(x,y);
//					blocks[1]=new RedBlock(x-length,y);
//					blocks[2]=new RedBlock(x-length,y-length);
//					blocks[3]=new RedBlock(x-2*length,y-length);
//					
//					
//				}
//				else if(turn==4) { 
//					
//						x-=length;
//					
//						
//					
//					
//					
//					blocks[0]=new RedBlock(x,y);
//					blocks[1]=new RedBlock(x,y-length);
//					blocks[2]=new RedBlock(x+length,y-length);
//					blocks[3]=new RedBlock(x+length,y-2*length);
//					
//					
//				}
//			
//				
//			return blocks;
//		}
//
//		public Block[] yellowShape(int x, int y,int turn , boolean test) { //square
//			
//			
//			
//
//			
//			Block[] blocks=new YellowBlock[4];
//			
//		
//			
//				if(turn==1) {
//					
//					
//				
//						
//						y-=length;
//						
//					
//					
//					
//					blocks[0]=new YellowBlock(x,y);
//					blocks[1]=new YellowBlock(x+length,y);
//					blocks[2]=new YellowBlock(x+length,y+length);
//					blocks[3]=new YellowBlock(x,y+length);
//					
//					
//				}
//				
//				else if(turn==2) { 
//					
//					
//						
//						x+=length;
//					
//					
//					
//					
//					blocks[0]=new YellowBlock(x,y);
//					blocks[1]=new YellowBlock(x,y+length);
//					blocks[2]=new YellowBlock(x-length,y+length);
//					blocks[3]=new YellowBlock(x-length,y);
//					
//				
//					
//				}
//				
//				else if(turn==3) { 
//					
//
//		               
//
//						y+=length;
//					
//					
//					
//					
//					blocks[0]=new YellowBlock(x,y);
//					blocks[1]=new YellowBlock(x-length,y);
//					blocks[2]=new YellowBlock(x-length,y-length);
//					blocks[3]=new YellowBlock(x,y-length);
//					
//					
//				}
//				else if(turn==4) { pass=true;
//					
//						
//						x-=length;
//					
//					
//					blocks[0]=new YellowBlock(x,y);
//					blocks[1]=new YellowBlock(x,y-length);
//					blocks[2]=new YellowBlock(x+length,y-length);
//					blocks[3]=new YellowBlock(x+length,y);
//					
//					
//					
//				}
//			
//				
//				
//			return blocks;
//			
//			
//	}
//	
//	
}