package hey.btk;

import org.lwjgl.BufferUtils;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public class Util {

    private static DoubleBuffer createDoubleBuffer(int size){
        return BufferUtils.createDoubleBuffer(size);
    }

    public static DoubleBuffer createFlippedBuffer(Vertex[] vertices){
        DoubleBuffer buffer = createDoubleBuffer(vertices.length * Vertex.SIZE);
        for (int i = 0; i < vertices.length; i++) {
            buffer.put(vertices[i].getPos().getI());
            buffer.put(vertices[i].getPos().getJ());
            buffer.put(vertices[i].getPos().getK());
        }

        buffer.flip();
        return buffer;
    }

    public static FloatBuffer createFlippedBuffer(Matrix4f matrix4f){
        FloatBuffer floatBuffer  = BufferUtils.createFloatBuffer(4*4);
        for (float[] row: matrix4f.getMatrix()) {
            floatBuffer.put(row);
        }
        floatBuffer.flip();
        return floatBuffer;
    }
}
