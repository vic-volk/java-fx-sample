package model;

import java.util.HashSet;
import java.util.Set;

public class Scene {

    Set<SceneObject> sceneObjects;

    public Scene() {
        sceneObjects = new HashSet<>();
    }

    public void add(SceneObject sc) {
        sceneObjects.add(sc);
    }

    public Set<SceneObject> getSceneObjects() {
        return sceneObjects;
    }
}
