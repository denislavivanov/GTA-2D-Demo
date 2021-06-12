import org.joml.Vector2f;

public class Player extends GameObject {
    private float speed;
    private Sprite sprite;

    public Player(Vector2f size, Vector2f pos, float speed) {
        super(pos, size);

        this.speed = speed;

        this.sprite = new Sprite("Graphics/Textures/player.png", super.data);
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override
    public void draw(Vector2f pos) {
        sprite.draw(pos, super.Size);
    }

    public void move(Vector2f dist) {
        super.Position = Position.add(dist);
    }
}