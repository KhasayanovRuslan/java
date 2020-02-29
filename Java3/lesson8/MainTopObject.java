package lesson8;

import java.util.ArrayList;
import java.util.List;

public class MainTopObject{
    static List<TopObject> topObjects = new ArrayList<>();

    public static void main(String[] args) {
        topObjects.add(new TopObject(1, null));
        topObjects.add(new TopObject(2, null));
        topObjects.add(new TopObject(3, "1"));
        topObjects.add(new TopObject(4, "3"));
        topObjects.add(new TopObject(5, "4"));
        topObjects.add(new TopObject(6, null));

        for (TopObject obj : topObjects) {
            if (obj.hasParent()){
                setChild(obj);
            }
        }

        for (TopObject obj : topObjects) {
            System.out.println("Parent: " + obj.getId() + " Children: ");
            obj.showChildren();
        }
    }

    private static void setChild(TopObject topObject) {
        int parentId;
        try{
            parentId = Integer.parseInt(topObject.getParentId());
        } catch (NumberFormatException e){
            System.out.println("Unknown parentId");
            return;
        }

        for (TopObject object : topObjects) {
            if(object.getId() == parentId){
                object.setChild(topObject);
            }
        }

    }

}

