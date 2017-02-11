package Entities.Snake;

import Entities.Base.BodyPart;
import Entities.Base.Position;

import java.util.ArrayList;

/**
 * Created by rojo on 2/4/17.
 */
public class Snake {
    private BodyPart head;
    private ArrayList<BodyPart> bodyParts;
    private final float size = 20;

    public Snake() {
        head = new BodyPart(size);
        bodyParts = new ArrayList<BodyPart>();
    }

    public BodyPart getHead() {
        return head;
    }

    public ArrayList<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public int getLength() {
        return bodyParts.size();
    }

    public void moveTo(Position position) {
        Position headOldPosition = head.getPosition();

        head.setPosition(position);

        BodyPart tail = bodyParts.remove(bodyParts.size() - 1);
        tail.setPosition(headOldPosition);
        bodyParts.add(tail);
    }

}
