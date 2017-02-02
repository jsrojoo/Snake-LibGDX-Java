package Model;

/**
 * Created by rojo on 1/28/17.
 */
public interface Direction {
    int RIGHT = 0;
    int LEFT = 1;
    int UP = 2;
    int DOWN = 3;

    void changeDirection(int direction);
}
