import org.joml.Vector2f;

public class GrassBlock extends GameObject {
    private Sprite sprite;

    public GrassBlock(Vector2f pos, Vector2f size) {
        super(pos, size);

        this.sprite = new Sprite("Graphics/Textures/grass.png", super.data);
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }
}