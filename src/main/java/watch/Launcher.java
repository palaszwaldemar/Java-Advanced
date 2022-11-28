package watch;

public class Launcher {
    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine(new Display("Watch"), new Gameplay());
        gameEngine.start();
    }
}
