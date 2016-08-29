//defines for game loop states
#define GAME_INIT //the game is initializing
#define GAME_MENU //the game is in the menu mode
#define GAME_STARTING //the game is about to run
#define GAME_RUN //the game is now running
#define GAME_RESTART //the game is going to restart
#define GAME_EXIT //the game is exiting

//game globals
int game_state = GAME_INIT;//start off in this state
int error=0;//used to send errors back to OS

//main begins here

void main()
{
	//implementation of main game loop
	while(game_state != GAME_EXIT)
	{
		//what state is game loop in 
		switch(game_state)
		{
		case GAME_INIT: //the game is initializing
			{ 
				//allocate all memory and resources
				Init();
				//move to menu state
				game_state =GAME_MENU;
			}break;
			
		case GAME_MENU://the game is in the menu mode
			{
				//call the main menu function and let it switch states
				game_state =Menu();
				//note:we could force a RUN state here
			}break;
			
		case GAME_STARTING://the game is about to RUN
			{
				//this state is optional,but usually used to
				//set things up right before the game is run
				//you might do a little more housekeeping here
				Setup_For_Run();
				//switch to run state
				game_state = GAME_RUN;
			}break;
			
		case GAME_RUN: //the game is now running
			{
				//this section contains the entire game logic loop
				//clear the display
				Clear();
				//get the input
				Get_Input();
				//perform logic and ai
				Do_Logic();
				//display the next frame of animation
				Render_Frame();
				//synchronize the display
				Wait();
				//the only way that state can be changed is
				//thru user interaction in the
				//input section or by maybe losing the game.
			}break;
			
		case GAME_RESTART: //the game is restarting
			{
				//this section is a cleanup state used to
				//fix up any loose ends before
				//running again
				Fixup();
				//switch states back to the menu
				game_state = GAME_MENU;
			}break;
			
		case GAME_EXIT: //the game is exiting
			{
				//if the game is in this state then
				//it's time to bail,kill everything
				//and cross your fingers
				Release_And_Cleanup();
				//set the error word to whatever
				error = 0;
				//note: we don't have to switch states
				//since we are already in this state
				//on the next loop iteration the code
				//will fall out of the main while and
				//exit back to the OS
			}break;
			
		default: break;
			
		}//end switch
	}//end while
	//return error code to operation system
	return(error);
}//end 
