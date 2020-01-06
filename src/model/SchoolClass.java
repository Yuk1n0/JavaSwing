package model;

/*
 * 班级实体
 */
public class SchoolClass {

    private int id;
    private String className;
    private String calssDesc;

    public SchoolClass() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SchoolClass(String className, String calssDesc) {
        super();
        this.className = className;
        this.calssDesc = calssDesc;
    }

    public SchoolClass(int id, String className, String calssDesc) {
        super();
        this.id = id;
        this.className = className;
        this.calssDesc = calssDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCalssDesc() {
        return calssDesc;
    }

    public void setCalssDesc(String calssDesc) {
        this.calssDesc = calssDesc;
    }

    @Override
    public String toString() {
        return className;
    }
}
