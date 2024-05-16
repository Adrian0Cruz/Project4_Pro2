//01 - 05 -2024
//esta clase era para ayudar a Hernán
package programacion2_pro4;
//@author Jesús Hernández
import java.awt.HeadlessException;
import java.io.*;
import javax.swing.JComboBox;
import javax.swing.*;
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
            JTextField JFTName, JComboBox JCBGender ) {
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
        } while ( p != Cab && p != null );
        tab.setModel ( Modelo );
    }
    
    private Child Previous ( Child P ) {
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
    
    public int CountChild ( String Grade, String Gender ) {
        int C = 0;
        Child D = Cab;
        do {
            if ( D.getGrade (  ).equals ( Grade ) && D.getGender (  ).equals ( Gender ) ) C++;
            D = D.Sig;
        } while ( D != Cab );
        return C;
    }
    
    public void ShowList ( JTextArea TA, String Grade ) {
        if ( Empty (  ) ) {
            JOptionPane.showMessageDialog (null,
                    "La Lista Esta Vacia");
            return;
        }
        Child G = Cab;
        TA.setText ( "" );
        TA.append ( """
                    Los Nombres De los Ni\u00f1os
                    Que Estan En El Grado 
                    """ + Grade + " Son: \n\n" );
        int P = 1;
        do{
            if ( G.getGrade().equals(Grade) ) {
                TA.append ( P + " - " + G.getName (  ) + "\n");
                ++P;
            }
            G = G.Sig; 
        } while ( G != Cab );
    }
    
    public double Promedio ( String Gender ) {
        Child E = Cab;
        int Cant = 0;
        int Edad = 0;
        do {
            if ( E.getGender (  ).equals ( Gender )  ) {
                Edad += E.getAge (  );
                Cant++;
            }
            E = E.Sig;
        } while ( E != Cab );
        if ( Cant == 0 ) return 0;
        return Edad / Cant;
    }
    
    public void Txt (  ) {
        String fileName = System.getProperty("user.home") + "\\Desktop\\Informe.txt";
        String encoding = "UTF-8";
        Child D = Cab;
        try {
            PrintWriter writer = new PrintWriter(fileName, encoding);
            if ( Empty (  ) ) writer.println("No Hay Nada En La Lista");
            do {
                writer.println ( D.ToString (  ) );
                D = D.Sig;
            } while (D != Cab);
            writer.close();
            /*File file = new File(fileName);
            file.setReadOnly();*/
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
    }
    
    public void Import(JTable tab) throws FileNotFoundException, IOException {
        File file = new File(System.getProperty("user.home") + "/Desktop\\Informe.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] split = line.split("\\|\\|");
                    String Grade = split[0];
                    int Age = Integer.parseInt(split[1]);
                    int Id = Integer.parseInt(split[2]);
                    String Name = split[3];
                    String Gender = split[4];
                    // Verifica si el ID ya ha sido procesado
                    if (SearchCod(Id) == null) {
                        Child nuevoElemento = new Child(Grade, Age, Id, Name, Gender);

                        if (nuevoElemento != null) {
                            if (Empty()) {
                                Cab = nuevoElemento;
                                Cab.Sig = Cab;
                            } else {
                                Child U = Lasted();
                                U.Sig = nuevoElemento;
                                nuevoElemento.Sig = Cab;
                            }
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,
                                """
                                Hay Codigos Iguales: 
                                Grado: """ + Grade
                                +"\nEdad: " + Age
                                +"\nId: " + Id
                                +"\nNombre: " + Name
                                +"\nGenero: " + Gender);
                    }
                    LLenarTabla(tab);
                }
            }
        }
    }
}