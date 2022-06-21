package hey.btk;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

public class Shader {
    private int program;
    private Map<String, Integer> uniforms;

    public Shader() {
        program = glCreateProgram();
        uniforms = new HashMap<>();
        if (program == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location in constructor (my custom error:))");
            System.exit(1);
        }
    }

    public void bind() {
        glUseProgram(program);
    }

    public void addUniform(String uniform) {
        int uniformLocation = glGetUniformLocation(program, uniform);
        if (uniformLocation == -1) {
            System.err.println("uniform zdoh");
            System.exit(1);
        }
        uniforms.put(uniform, uniformLocation);
    }

    public void addVertexShader(String text) {
        addProgram(text, GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text) {
        addProgram(text, GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text) {
        addProgram(text, GL_FRAGMENT_SHADER);
    }

    public void compileShader() {
        glLinkProgram(program);

        if (glGetProgram(program, GL_LINK_STATUS) == 0) {
            System.err.println(glGetProgramInfoLog(program, 1024));
            System.exit(1);
        }

        glValidateProgram(program);

        if (glGetProgram(program, GL_VALIDATE_STATUS) == 0) {
            System.err.println(glGetProgramInfoLog(program, 1024));
            System.exit(1);
        }
    }

    private void addProgram(String text, int type) {
        int shader = glCreateShader(type);

        if (shader == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location when adding shader (my custom error:))");
            System.exit(1);
        }

        glShaderSource(shader, text);
        glCompileShader(shader);

        if (glGetShader(shader, GL_COMPILE_STATUS) == 0) {
            System.err.println(glGetShaderInfoLog(shader, 1024));
            System.exit(1);
        }

        glAttachShader(program, shader);
    }

    public void setUniformI(String name, int value) {
        glUniform1i(uniforms.get(name), value);
    }

    public void setUniformF(String name, float value) {
        glUniform1f(uniforms.get(name), value);
    }

    public void setUniform(String name, Vector3f value) {
        glUniform3f(uniforms.get(name), (float) value.getI(), (float) value.getJ(), (float) value.getK());
    }

    public void setUniform(String name, Matrix4f value) {
        glUniformMatrix4(uniforms.get(name), true, Util.createFlippedBuffer(value));
    }
}
