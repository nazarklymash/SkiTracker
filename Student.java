public class Student{

    private int age;
    private String name;
    private int level;
    private int objLevel;

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public int getObjLevel(){
        return objLevel;
    }

    public void setAge(int age){
        if (age <= 0){
            throw new IllegalArgumentException("Age has to be > 0");
        }
        this.age = age;
    }

    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setLevel(int level){
        if (level <= 0 || level > 10){
            throw new IllegalArgumentException("Level has to be from 1 to 10");
        }
        this.level = level;
    }

    public void setObjLevel(int objLevel){
        if (objLevel <= 0 || objLevel > 10){
            throw new IllegalArgumentException("Objective Level has to be from 1 to 10");
        }
        this.objLevel = objLevel;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + 
                    ", age=" + age +
                    ", level=" + level +
                    ", objLevel=" + objLevel +
                    "}";
    }
}