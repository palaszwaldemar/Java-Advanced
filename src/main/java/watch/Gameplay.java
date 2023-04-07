package watch;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {
    WatchDisplay watchDisplay = new WatchDisplay();

    public Gameplay() {
    }

    public void tick() {
    }

    public void render(Graphics g) {
        watchDisplay.render(g);
    }
}