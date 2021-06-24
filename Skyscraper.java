import org.joml.Vector2f;

public class Skyscraper extends GameObject {
    Sprite sprite;

    public Skyscraper(Vector2f pos, Vector2f size) {
        super(pos, size);

        this.sprite = new Sprite("Graphics/Textures/redstone.png", super.data);
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }
}