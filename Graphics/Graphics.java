import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33C.*;
import org.joml.Matrix4f;

public class Graphics {
    private int width;
    private int height;
    private boolean fullscreen;
    private String title;
    public long window;
    private int program;
    private Shader vertex_shader;
    private Shader fragment_shader;

    public Graphics(int width, int height, String title, boolean fullscreen) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.fullscreen = fullscreen;

        initWindow();
        createShaders();
        createProgram();
    }

    private void initWindow() {
        if(!glfwInit())
            System.out.println("GLFW failed to initialize!");

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        if(fullscreen) {
            long monitor = glfwGetPrimaryMonitor();
            this.window = glfwCreateWindow(glfwGetVideoMode(monitor).width(), glfwGetVideoMode(monitor).height(), this.title, glfwGetPrimaryMonitor(), 0);
        } else {
            this.window = glfwCreateWindow(this.width, this.height, this.title, 0, 0);
        }
        
        glfwMakeContextCurrent(this.window);

        glfwSwapInterval(1);

        GL.createCapabilities();
    }

    private void createShaders() {
        try
        {
            vertex_shader = new Shader("Graphics/Shaders/shader.vert");
            fragment_shader = new Shader("Graphics/Shaders/shader.frag");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        vertex_shader.setID(glCreateShader(GL_VERTEX_SHADER));
        fragment_shader.setID(glCreateShader(GL_FRAGMENT_SHADER));

        glShaderSource(vertex_shader.getID(), vertex_shader.getSrc());
        glShaderSource(fragment_shader.getID(), fragment_shader.getSrc());

        glCompileShader(vertex_shader.getID());
        glCompileShader(fragment_shader.getID());

        shaderCompileError(vertex_shader);
        shaderCompileError(fragment_shader);
    }

    void shaderCompileError(Shader obj) {
        String infoLog = glGetShaderInfoLog(obj.getID());
        if(infoLog.length() > 1)
            System.out.println(infoLog);
    }

    private void createProgram() {
        program = glCreateProgram();

        glAttachShader(program, vertex_shader.getID());
        glAttachShader(program, fragment_shader.getID());

        glLinkProgram(program);
        glUseProgram(program);
    }

    public void setMatrix4f(String name, Matrix4f mat) {
        float[] data = new float[16]; 
        mat.get(data);
        glUniformMatrix4fv(glGetUniformLocation(this.program, name), false, data);
    }
}