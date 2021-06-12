import org.joml.Vector2f;

public class CollisionDetection {

    public boolean check(GameObject obj1, GameObject obj2) {

        boolean collisionX = obj1.Position.x + obj1.Size.x >= obj2.Position.x &&
        obj2.Position.x + obj2.Size.x >= obj1.Position.x;

        boolean collisionY = obj1.Position.y + obj1.Size.y >= obj2.Position.y &&
        obj2.Position.y + obj2.Size.y >= obj1.Position.y;

        return collisionX && collisionY;
    }

    public boolean check_map(GameObject obj) {

        boolean collisionX = obj.Position.x + obj.Size.x > 64.0f || obj.Position.x < 0.0f;

        boolean collisionY = obj.Position.y + obj.Size.y > 64.0f || obj.Position.y < 0.0f;

        return collisionX || collisionY;
    }
}