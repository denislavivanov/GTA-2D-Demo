import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.opengl.GL33C.*;
import java.nio.ByteBuffer;

public class Texture {
    private int ID;
    private int[] width = new int[1];
    private int[] height = new int[1];
    private int[] nrChannels = new int[1];
    private ByteBuffer data;

    public Texture(String path) {
        stbi_set_flip_vertically_on_load(true);
        data = stbi_load(path, width, height, nrChannels, 0);

        if(data == null || data.remaining() == 0)
            System.out.println("Texture failed to load!");

        ID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, ID);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width[0], height[0], 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
        glGenerateMipmap(GL_TEXTURE_2D);

        stbi_image_free(data);
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, this.ID);
    }

    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }
}
