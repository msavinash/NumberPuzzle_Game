import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		Button emptyButton=new Button();
		int buttonClickedId=0,emptyButtonId=0;
		for(int i=0;i<buttons.length;i++) {
			if(buttons[i].getLabel()=="  ") {
				emptyButton=buttons[i];
				emptyButtonId=i;
			}
		}
		for(int i=0;i<buttons.length;i++) {	
			if(buttons[i]==buttonClicked)
				if(i==emptyButtonId+1 || i==emptyButtonId-1 || i==emptyButtonId+4 || i==emptyButtonId-4) {
					buttonClickedId=Integer.valueOf(buttons[i].getLabel());
					swapButton(emptyButton, buttonClicked);	
					emptyCellId=buttonClickedId;}
			
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			int a = getRandomNumber()%15;
			if(a<0)
				a=a*-1;
			temp=arr[i];
			arr[i]=arr[a];
			arr[a]=temp;
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		// Your Logic here
		int arr[]=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				winner=false;
				break;
			}
		}
		getIntegerArrayOfButtonIds(buttons);

		return winner;
	}
}