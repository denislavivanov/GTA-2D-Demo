import static org.lwjgl.opengl.GL33C.*;
import org.joml.Vector2f;

public class Sprite {
    private int VAO;
    private int VBO;
    private int EBO;
    private float[] data;
    private short[] indices;
    private final int VERTEX_COUNT = 6;
    private Texture texture;

    public Sprite(String tex_path, float[] data) {
        this.texture = new Texture(tex_path);
        this.data = data;

        this.indices = new short[]{
            0, 1, 2,
            0, 2, 3
        };

        VAO = glGenVertexArrays();
        glBindVertexArray(VAO);

        VBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 20, 0);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(1, 2, GL_FLOAT, false, 20, 12);
        glEnableVertexAttribArray(1);

        EBO = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_DYNAMIC_DRAW);
    }

    public void update(Vector2f dist) {
        this.data[0] += dist.x;
        this.data[5] +=  dist.x;
        this.data[10] += dist.x;
        this.data[15] += dist.x;
        this.data[1] += dist.y;
        this.data[6] += dist.y;
        this.data[11] += dist.y;
        this.data[16] += dist.y;

        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        glBufferData(GL_ARRAY_BUFFER, this.data, GL_STATIC_DRAW);
    }

    public void draw(Vector2f pos, Vector2f size) {
        this.bind();
        texture.bind();

        this.data[0] = pos.x;
        this.data[1] = pos.y;
        this.data[5] = pos.x + size.x;
        this.data[6] = pos.y;
        this.data[10] = pos.x + size.x;
        this.data[11] = pos.y + size.y;
        this.data[15] = pos.x;
        this.data[16] = pos.y + size.y;

        glBindBuffer(GL_ARRAY_BUFFER, this.VBO);
        glBufferData(GL_ARRAY_BUFFER, this.data, GL_STATIC_DRAW);
        glDrawElements(GL_TRIANGLES, VERTEX_COUNT, GL_UNSIGNED_SHORT, 0);
    }

    public void bind() {
        glBindVertexArray(VAO);
    }

    public void unbind() {
        glBindVertexArray(0);
    }
}
