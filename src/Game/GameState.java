package Game;


public class GameState {

    public enum State{
        TITLE,
        GAME,
        PAUSE
    }

    State currentState;

    public GameState(){
        this.currentState = State.TITLE;
    }

    public State getState(){
        return this.currentState;
    }

    public void setState(State state){
        this.currentState = state;
    }
}
