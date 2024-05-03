//01 - 05 -2024
//esta clase era para ayudar a Hernán
package programacion2_pro4;
//@author Jesús Hernández
public class List {
    Child Cab;
    
    List ( ) { Cab = null; }
    
    private boolean Empty ( ) { return Cab == null; } 
    
    private Child SearchCod ( int Cod ){
        if ( Empty ( ) ) return null;
        else {
            Child A = Cab;
            do{
                if ( Cod == A.getId ( ) ) return A;
                else A = A.Sig;
            }while ( A != Cab );
            return null;
        }
    }
    
    /*private Child Created ( String Grade, int Age, int Id, String Name,
            String Gender ) {
        
    }*/
}