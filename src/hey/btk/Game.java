package hey.btk;

import org.lwjgl.input.Keyboard;

public class Game {

    private Mesh mesh;
    private Shader shader;

    public Game() {
        mesh = new Mesh();
        shader = new Shader();
        Vertex[] data = new Vertex[]{
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0, 1, 0)),
                new Vertex(new Vector3f(1, -1, 0))
        };

        mesh.addVertices(data);

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.glsl"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.glsl"));
        shader.compileShader();

        shader.addUniform("uniformFloat");
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

    float temp = 0;

    public void update(){
        temp+=Time.getDelta();
        shader.setUniformF("uniformFloat",(float)Math.abs(Math.sin(temp)));
    }

    public void render(){
        shader.bind();
        mesh.draw();
    }
}
