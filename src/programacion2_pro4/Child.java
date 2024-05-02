// 01 - 05 - 2024
//this is the node class
package programacion2_pro4;
//@author Jesús Hernández
public class Child {
    String Grade;
    int Age;
    int Id;
    String Name;
    String Gender;
    
    Child Sig;

    public Child(String Grade, int Age, int Id, String Name, String Gender,
            Child Sig) {
        this.Grade = Grade;
        this.Age = Age;
        this.Id = Id;
        this.Name = Name;
        this.Gender = Gender;
        this.Sig = null;
    }
}