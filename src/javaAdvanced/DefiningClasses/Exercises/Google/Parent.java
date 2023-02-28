package javaAdvanced.DefiningClasses.Exercises.Google;

public class Parent {
    private String parent;
    private String parentBirthday;

    public Parent(String parent, String parentBirthday) {
        this.parent = parent;
        this.parentBirthday = parentBirthday;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    public void setParentBirthday(String parentBirthday) {
        this.parentBirthday = parentBirthday;
    }
}
