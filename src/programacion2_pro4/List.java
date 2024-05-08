//01 - 05 -2024
//esta clase era para ayudar a Hernán
package programacion2_pro4;
//@author Jesús Hernández
import java.awt.HeadlessException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class List {
    Child Cab;
    public List (  ) { Cab = null; }
    private boolean Empty (  ) { return Cab == null; }

    private Child SearchCod ( int Cod ) {
        if ( Empty(  ) ) return null;
        else {
            Child A = Cab;
            do {
                if ( Cod == A.getId(  ) ) return A;
                else A = A.Sig;
            } while ( A != Cab );
            return null;
        }
    }
    
    public void ShowInfo ( int Cod ) {
        Child B = SearchCod ( Cod );
        if ( B == null )JOptionPane.showMessageDialog(null,
                "El código buscado no existe!!");
        else{
            JOptionPane.showMessageDialog(null,
                    "El Niño Con El Id" + Cod + " Es:\n" + B.toString (  ) );
        }
    }

    private Child Created ( JComboBox JCBGrade, JLabel JLAge, JTextField JJTFId,
            JTextField JFTName, JComboBox JCBGender ) {
        try {
            Child Cod = SearchCod ( Integer.parseInt ( JJTFId.getText ( ) ) );
            do {
                if ( Cod != null ) {
                    JOptionPane.showMessageDialog(null,
                            "Ese Codigo Ya Se Ha Registrado", "ERROR",JOptionPane.ERROR_MESSAGE);
                    JJTFId.setText ( "" );
                    JJTFId.grabFocus (  );
                    return null;
                }
            } while ( Cod != null );
            
            String Grade = JCBGrade . getSelectedItem (  ) . toString (  ) ;
            int Age = Integer.parseInt ( JLAge.getText (  ) ) ;
            int Id = Integer.parseInt ( JJTFId.getText (  ) ) ;
            String Name = JFTName . getText (  ) ;
            String Gender = JCBGender . getSelectedItem (  ) . toString (  ) ;
            
            Child Info = new Child ( Grade, Age, Id, Name, Gender) ;
            JOptionPane.showMessageDialog(null,
                    "Registro Exitoso");
            return Info;
        } catch ( HeadlessException | NumberFormatException E ) {
            JOptionPane.showMessageDialog(null,
                    "No Se Pudo Añadir Al Niño" + E, "Error", JOptionPane.ERROR_MESSAGE);
            JJTFId.setText ( "" );
            JJTFId.grabFocus (  );
            return null;
        }
    }
    
    private Child Lasted (  ) {
        if( Empty (  ) ) return null;
        else{
            Child P = Cab;
            while( P.Sig != Cab ) P = P.Sig;
            return P;
        }
    }
    
    public void AddS ( JComboBox JCBGrade, JLabel JLAge, JTextField JJTFId,
            JTextField JFTName, JComboBox JCBGender ) {
        Child Info = Created (  JCBGrade, JLAge, JJTFId, JFTName, JCBGender);
        if ( Info != null ){
            if( Empty (  ) ){
                Cab = Info;
                Cab.Sig = Cab;
                JOptionPane.showMessageDialog(null,
                    "Elemento registrado, la lista estaba vacía.");
            }else{
                Child U = Lasted (  ) ;
                Info.Sig = Cab;
                Cab = Info;
                U.Sig = Cab;
                JOptionPane.showMessageDialog(null,
                    "Elemento registrado al inicio.");
            }
        }
    }
    
    public void AddF ( JComboBox JCBGrade, JLabel JLAge, JTextField JJTFId,
            JTextField JFTName, JComboBox JCBGender ){
        Child Info = Created (  JCBGrade, JLAge, JJTFId, JFTName, JCBGender);
        if ( Info != null ){
            if ( Empty (  ) ) {
                Cab = Info;
                Cab.Sig = Cab;
                JOptionPane.showMessageDialog(null,
                    "Elemento registrado, la lista estaba vacía.");
            } else {
                Child U = Lasted (  );
                U.Sig = Info;
                Info.Sig = Cab;
                JOptionPane.showMessageDialog(null,
                    "Elemento registrado al final.");
            }
        }
    }
    
    private void RegistrarTable ( DefaultTableModel Model, int Ft, Child P ) {
        Model.setValueAt ( P.getGrade (  ), Ft, 0 );
        Model.setValueAt ( P.getAge (  ), Ft, 1 );
        Model.setValueAt ( P.getId (  ), Ft, 2 );
        Model.setValueAt ( P.getName (  ), Ft, 3 );
        Model.setValueAt ( P.getGender (  ), Ft, 4 );
    }
    
    public void LLenarTabla( JTable tab ) {
        int posFilaT = 0; //Este índice recorre los elementos de la fila Tabla
        Child p = Cab;  //Este nodo me mueve posición x posición en la lista
        DefaultTableModel Modelo = new DefaultTableModel (  ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Modelo.addColumn ( "Grado" );
        Modelo.addColumn ( "Edad" );
        Modelo.addColumn ( "Identificación" );
        Modelo.addColumn ( "Nombre" );
        Modelo.addColumn ( "Genero" );

        if ( p == null ) {
            tab.setModel ( Modelo );
            return;
        }
        do{
            
            Modelo.addRow ( new Object [ ] { "", "", "", "", "" } );
            RegistrarTable ( Modelo, posFilaT, p );
            p = p.Sig;
            posFilaT++;
        } while ( p != Cab && p != null);
        tab.setModel ( Modelo );
    }
    
    public Child Previous ( Child P ) {
        if ( Empty (  ) ) return null;
        else{
            Child Q = Cab;
            while ( Q.Sig != P ) Q = Q.Sig;
            return Q;
        }    
    }
    
    public void EliminatedCod( int cod ) {
        Child B = SearchCod ( cod ), U, A;
        if ( B == null )
            JOptionPane.showMessageDialog(null, 
                "El código a eliminar no existe!");
        else{
            if ( B == Cab  &&  Cab.Sig == Cab ) {
                Cab = null;
                JOptionPane.showMessageDialog(null,
                    "Elemento eliminado, la lista esta vacía");
            } else if ( B == Cab  &&  Cab.Sig != Cab ) {
                U = Lasted (  );
                Cab = Cab.Sig;
                U.Sig = Cab;
                B.Sig = null;
                B = null;
                JOptionPane.showMessageDialog(null,
                    "Elemento eliminado del Inicio De La Lista");
            } else if ( B.Sig == Cab ) {
                A = Previous ( B );
                A.Sig = Cab;
                B.Sig = null;
                B = null;
                JOptionPane.showMessageDialog(null,
                    "Elemento eliminado dek Final De La Lista");
            } else {
                A = Previous ( B );
                A.Sig = B.Sig;
                B.Sig = null;
                B = null;
                JOptionPane.showMessageDialog(null,
                    "Elemento eliminado entre dos nodos.");
            }
        }
    }
}