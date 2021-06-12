import org.joml.Vector2f;

public class Wall extends GameObject {
    Sprite sprite;

    public Wall(Vector2f pos, Vector2f size) {
        super(pos, size);

        this.sprite = new Sprite("Graphics/Textures/wall.png", super.data);
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }
}