package hey.btk;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Game {
    public Game() {
    }

    public void input() {
        if (Input.getKeyDown(Keyboard.KEY_UP)){
            System.out.println("KEY_UP pressed");
        }
        if (Input.getKeyUp(Keyboard.KEY_UP)){
            System.out.println("KEY_UP released");
        }
        if (Input.getMouseDown(0)){ //left button
            System.out.println("mouse 0 pressed"+ Input.getMousePosition().toString());
        }
        if (Input.getMouseUp(0)){
            System.out.println("mouse 0 released"+ Input.getMousePosition().toString());
        }
        if (Input.getMouseDown(1)){ //right button
            System.out.println("mouse 1 pressed " + Input.getMousePosition().toString());
        }
        if (Input.getMouseUp(1)){
            System.out.println("mouse 1 released " + Input.getMousePosition().toString());
        }
    }

    public void update(){}

    public void render(){}
}
