package data.hashmap;

public class Student {
    private String name;
    private int num;
    public Student(String name,int num){
        this.name = name;
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (obj.getClass()!=this.getClass()){
            return false;
        }
        Student newStu = (Student) obj;
        return this.name.equals(newStu.name) &&this.num==newStu.num;
    }

    @Override
    public int hashCode() {
        int hash = 0,B = 31;
        hash = hash*B+name.toLowerCase().hashCode();
        hash = hash*B+num;
        return hash;
    }
}
