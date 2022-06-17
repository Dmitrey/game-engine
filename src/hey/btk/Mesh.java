package hey.btk;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Mesh {
    private int vbo;
    private int vao;
    private int size;

    public Mesh(){
        vao = glGenVertexArrays();
        vbo = glGenBuffers();
        size = 0;
    }

    public void addVertices(Vertex[] vertices){
        glBindVertexArray(vao);
        size = vertices.length * Vertex.SIZE;
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
        glVertexAttribPointer(0,3,GL_DOUBLE,false,Vertex.SIZE * 8,0);
        glEnableVertexAttribArray(0);
    }

    public void draw(){
//        glEnableVertexAttribArray(0);
        glBindVertexArray(vao);
//        glBindBuffer(GL_ARRAY_BUFFER,vbo);
//
//        glVertexAttribPointer(0,3,GL_DOUBLE,false,Vertex.SIZE * 8,0);

        glDrawArrays(GL_TRIANGLES,0,size);
//        glDrawArrays(GL_LINE_STRIP,0,size);
//        glDisableVertexAttribArray(0);
    }
}
