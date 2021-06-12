import org.joml.Vector2f;

public abstract class GameObject {
    Vector2f Position;
    Vector2f Size;
    float[] data;

    public GameObject(Vector2f pos, Vector2f size) {
        this.Position = pos;
        this.Size = size;

        this.data = new float[] {
            pos.x, pos.y, 0.0f, 1.0f, 1.0f,                    //0
            pos.x + size.x, pos.y, 0.0f, 0.0f, 1.0f,           //1
            pos.x + size.x, pos.y + size.y, 0.0f, 0.0f, 0.0f,  //2
            pos.x, pos.y + size.y, 0.0f, 1.0f, 0.0f            //3
        };
    }

    public abstract void draw(Vector2f pos);
}