// 01 - 05 - 2024
//this is the node class
package programacion2_pro4;
//@author Jesús Hernández
public class Child {
    private String Grade;
    private int Age;
    private int Id;
    private String Name;
    private String Gender;
    
    Child Sig;

    public Child () { }

    public void setGrade ( String Grade ) { this.Grade = Grade; }

    public void setAge ( int Age ) { this.Age = Age; }

    public void setId ( int Id ) { this.Id = Id; }

    public void setName ( String Name ) { this.Name = Name; }

    public void setGender ( String Gender ) { this.Gender = Gender; }

    
    public String getGrade ( ) { return Grade; }

    public int getAge ( ) { return Age; }

    public int getId ( ) { return Id; }

    public String getName ( ) { return Name; }

    public String getGender ( ) { return Gender; }
    

    public Child ( String Grade, int Age, int Id, String Name, String Gender ) {
        this.Grade = Grade;
        this.Age = Age;
        this.Id = Id;
        this.Name = Name;
        this.Gender = Gender;
        this.Sig = null;
    }
    

    @Override
    public String toString (  ) {
        return  "Grado: " + Grade + 
                "\nEdad: " + Age + 
                "\nIdentificacion: " + Id + 
                "\nNombre: " + Name + 
                "\nGenero: " + Gender;
    }
    
    public String ToString (  ) { return Grade + " || " + Age + " || " + Id + " || " + Name + " || " + Gender; }
}