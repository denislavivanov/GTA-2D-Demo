import org.joml.Vector2f;

public class Tower extends GameObject {
    Sprite sprite;

    public Tower(Vector2f pos, Vector2f size) {
        super(pos, size);

        this.sprite = new Sprite("Graphics/Textures/gold.png", super.data);
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }
}