class TicTacToe{
  public static String[] welcome(){ //Here I am introducing the user to the board and telling them their symbol
    System.out.println("Welcome to Tic-Tac-Toe! As the user, your symbol will be 'o'.");
    System.out.println("Here is how the board will be laid out. Refer to this diagram during the game.");
    System.out.println("  A1  |  B1  |  C1  ");
    System.out.println("--------------------");
    System.out.println("  A2  |  B2  |  C2  ");
    System.out.println("--------------------");
    System.out.println("  A3  |  B3  |  C3  ");
    String[] board=new String[9];  //Here I am creating a string array to hold all the spaces in the board
    board[0]="A1";
    board[1]="A2";
    board[2]="A3";
    board[3]="B1";
    board[4]="B2";
    board[5]="B3";
    board[6]="C1";
    board[7]="C2";
    board[8]="C3";
    return board;}
  
  public static boolean[] userTurn(String[] board, boolean[] userOccupied, boolean[] compOccupied){ //This method is the user's turn.
    int x;
    boolean y;
    boolean h=false;
    do{
      x=0;
      y=false;
      System.out.println("What is your move?");
      String userString=In.getString();
      userString.trim();  //Here I am using various string methods to check if the user's string is 2 characters long,...
      if((userString.length()>2)||(Character.isLetter(userString.charAt(0))==false)|| //... and has a letter...
         (Character.isDigit(userString.charAt(1))==false)){  //...and a number
        do{  //Here I am asking the user for a string repeatedly until they give a string that meets the conditions
          System.out.println("Whoops! That's not quite what I asked for. Only the basics please. Try again!");
          userString=In.getString();}
        while((userString.length()>2)||(Character.isLetter(userString.charAt(0))==false)||
              (Character.isDigit(userString.charAt(1))==false));}
      System.out.println("Thank you!");  //This is to let the user know that their string is now satisfactory
      do{  //Here I am checking whether the user's string matches any of the spaces on the board (regardless of case)
        if(userString.equalsIgnoreCase(board[x])==true){ 
          y=true;} 
        else{
          x++;}}
      while((y==false)&&(x<board.length)); //The loop will continue to execute until the array ends or it finds the "board" element that matches userString
      if(y==false){  //If the user's string doesn't match any spaces on the board, print a message and let the turn loop again
        System.out.println("Uh-oh. That's not a space. Try again.");}
      else if((compOccupied[x]==false)&&(userOccupied[x]==false)){ //If this space wasn't previously occupied by the user or computer
        userOccupied[x]=true; //This means the space the user wanted to occupy is now occupied
        System.out.println(board[x] + " is now occupied by you.");
        h=true;}  //This tells the loop that, yes, the user has taken a valid turn and a new space is now occupied
      else{
        System.out.println("Oops! You can't take that space. It's occupied already. Try again.");}}
    while(h==false);
    return userOccupied;}
  
  public static boolean[] computerTurn(String[] board, boolean[] userOccupied, boolean[] compOccupied){
    System.out.println("Now it's my turn!");
    int rndmSpaceNum;
    boolean g=false;
    do{
      rndmSpaceNum=(int)(Math.round(8*(Math.random()))); //This generates a random number between 0 and 8 (corresponds to an element of "board") 
      if((userOccupied[rndmSpaceNum]==false)&&(compOccupied[rndmSpaceNum]==false)){ //If neither the user nor the computer occupy this space already...
        compOccupied[rndmSpaceNum]=true; //...the computer now occupies this space
        g=true;}}
    while(g==false);//The loop will continue to execute until the computer has occupied a new space
    System.out.println("I have chosen to occupy " + board[rndmSpaceNum]);
    return compOccupied;}
  
  public static void update(String[] board, boolean[] userOccupied, boolean[] compOccupied){ //Here, I am reminding the user what spaces they and the computer occupy
    System.out.println("Update: You now occupy ");
    for(int z=0; z<userOccupied.length; z++){  //For every space the user occupies, that space label is outputted
      if(userOccupied[z]==true){
        System.out.print(board[z] + ", ");}}
    System.out.println("and the computer occupies "); 
    for(int v=0; v<compOccupied.length; v++){   //For every space the computer occupies, that space label is outputted
      if(compOccupied[v]==true){
        System.out.print(board[v] + ", ");}}}
  
  //public static void checkWin(String[] board, boolean[] userOccupied, boolean[] compOccupied){
    
        
  public static void main(String[]args){
    String[] n;
    n=welcome();
    boolean[] userOccupied=new boolean[9]; //This array will store which spaces the user has occupied (each element corresponds to a space on the board)
    boolean[] compOccupied=new boolean[9]; //This array will do the same for the computer
    for(int r=1; r<=4; r++){
      userOccupied=userTurn(n, userOccupied, compOccupied); //Execute one user turn, and update the userOccupied array with the changes made
      compOccupied=computerTurn(n, userOccupied, compOccupied); //Do the same for the computer
      update(n, userOccupied, compOccupied);} //update the user on which spaces are occupied by whom
    System.out.println("Thanks for playing!");}}
    