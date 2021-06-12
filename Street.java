import org.joml.Vector2f;

public class Street extends GameObject {
    Sprite sprite;

    public Street(Vector2f pos, Vector2f size) {
        super(pos, size);

        this.sprite = new Sprite("Graphics/Textures/street.png", super.data);
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }
}