package hey.btk;

import org.lwjgl.input.Keyboard;

public class Game {

    private Mesh mesh;
    private Shader shader;
    private Transform transform;

    public Game() {

        mesh = ResourceLoader.loadMesh("box.obj");
//        mesh = new Mesh();

//        Vertex[] data = new Vertex[]{
//                new Vertex(new Vector3f(-1, -1, 0)),
//                new Vertex(new Vector3f(0, 1, 0)),
//                new Vertex(new Vector3f(1, -1, 0)),
//                new Vertex(new Vector3f(0, -1, 1))
//        };
//
//        int[] indices = new int[]{
//                0,1,3,
//                3,1,2,
//                2,1,0,
//                0,2,3};
//
//        mesh.addVertices(data,indices);
        shader = new Shader();
        transform = new Transform();
        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.glsl"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.glsl"));
        shader.compileShader();

        shader.addUniform("transform");
    }

    public void input() {
        if (Input.getKeyDown(Keyboard.KEY_UP)) {
            System.out.println("KEY_UP pressed");
        }
        if (Input.getKeyUp(Keyboard.KEY_UP)) {
            System.out.println("KEY_UP released");
        }
        if (Input.getMouseDown(0)) { //left button
            System.out.println("mouse 0 pressed" + Input.getMousePosition().toString());
        }
        if (Input.getMouseUp(0)) {
            System.out.println("mouse 0 released" + Input.getMousePosition().toString());
        }
        if (Input.getMouseDown(1)) { //right button
            System.out.println("mouse 1 pressed " + Input.getMousePosition().toString());
        }
        if (Input.getMouseUp(1)) {
            System.out.println("mouse 1 released " + Input.getMousePosition().toString());
        }
    }

    float temp = 0;

    public void update() {
        temp += Time.getDelta();
//        shader.setUniformF("uniformFloat",(float)Math.abs(Math.sin(temp)));
        float sin = (float) Math.sin(temp);
//        transform.setTranslation(sin, 0, 0);
        transform.setRotation(100 * sin, 100 * sin,0);
//        transform.setScale(sin, sin,sin);
    }

    public void render() {
        shader.bind();
        shader.setUniform("transform", transform.getTransformation());
        mesh.draw();
    }
}
