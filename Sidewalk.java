import org.joml.Vector2f;

public class Sidewalk extends GameObject {
    Sprite sprite;

    public Sidewalk(Vector2f pos, Vector2f size) {
        super(pos, size);

        this.sprite = new Sprite("Graphics/Textures/sidewalk.png", super.data);
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }
}