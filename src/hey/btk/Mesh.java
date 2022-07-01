package hey.btk;

import org.lwjgl.BufferUtils;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Mesh {
    private int vbo;
    private int vao;
    private int ibo;
    private int size;

    public Mesh(){
        vao = glGenVertexArrays();
        vbo = glGenBuffers();
        ibo = glGenBuffers();
        size = 0;
    }

    public void addVertices(Vertex[] vertices, int[] indices){
        glBindVertexArray(vao);
        size = indices.length;
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Util.createFlippedBuffer(indices),GL_STATIC_DRAW);

        glVertexAttribPointer(0,3,GL_FLOAT,false,Vertex.SIZE * 4,0);
        glEnableVertexAttribArray(0);
    }

    public void draw(){

        glBindVertexArray(vao);
        glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);

    }
}
