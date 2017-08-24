package formulario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Kaat
 */
public class Campos extends JFrame implements ActionListener {
    
    JTextField nombre, ap_pat, ap_mat, escuela;
    JLabel title, name, first, second, school;
    JButton guardar;
    
    Campos(){
        super(); 
        inicio();
        ventana();
    }
    
    public void inicio(){
        
        setTitle("Formulario");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void ventana(){
    
        title=new JLabel("Ingrese los siguientes datos:");
        title.setBounds(50, 40, 200, 30);
        add(title);
        title.setVisible(true);
        
        name=new JLabel("Nombre:");
        name.setBounds(50, 80, 150, 20);
        add(name);
        name.setVisible(true);
        
        nombre = new JTextField();
        nombre.setBounds(120, 80, 200, 20);
        add(nombre);
        nombre.setVisible(true);
        
        first=new JLabel("Apellido Paterno:");
        first.setBounds(50, 110, 150, 20);
        add(first);
        first.setVisible(true);
        
        ap_pat = new JTextField();
        ap_pat.setBounds(160, 110, 200, 20);
        add(ap_pat);
        ap_pat.setVisible(true);
        
        second=new JLabel("Apellido Materno:");
        second.setBounds(50, 140, 150, 20);
        add(second);
        second.setVisible(true);
        
        ap_mat = new JTextField();
        ap_mat.setBounds(160, 140, 200, 20);
        add(ap_mat);
        ap_mat.setVisible(true);
        
        school=new JLabel("Escuela:");
        school.setBounds(50, 170, 150, 20);
        add(school);
        school.setVisible(true);
        
        escuela = new JTextField();
        escuela.setBounds(120, 170, 200, 20);  
        add(escuela);
        escuela.setVisible(true);
        
        guardar= new JButton("Guardar datos");
        guardar.setBounds(50, 300, 200, 40);
        guardar.setFont(new Font("Arial", Font.BOLD, 13));
        guardar.addActionListener(this);
        add(guardar);
        guardar.setVisible(true);
        }
    
        @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==guardar){
            Conect c=new Conect();
            try {
                c.Guardar(nombre.getText(), ap_pat.getText(), ap_mat.getText(), escuela.getText());
                JOptionPane.showMessageDialog(this,"Datos guardados exitosamente","Listo",JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Campos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
        
    
    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        
//
//     if(e.getSource()==guardar){
////         String nom=nombre.getText();
////         String ap=ap_pat.getText();
////         String am=ap_mat.getText();
////         String sc=escuela.getText();
//         
//            
////            try {
////            Class.forName("com.mysql.jdbc.Driver").newInstance();
////            } 
////            catch (InstantiationException | IllegalAccessException | ClassNotFoundException error) {
////            error.printStackTrace();
////            }
//        
//         try {
//             String connectionUrl = "jdbc:sqlserver://;database=JavaDatos;integratedSecurity=true;";
//             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JavaDatos", "root", "n0m3l0");
//             System.out.println("Conectado.");
//         } catch (SQLException ex) {
//             System.out.println("Error.");
//         }
//            
//         
//         
////        Connection con=null;
////        Statement sta=null;
////        String URL = "";
////        
////        try {
////        URL="jdbc:mysql://localhost/JavaDatos";
////        con = DriverManager.getConnection(URL, "root", "n0m3l0");
////        sta= con.createStatement();
////        } 
////        catch (SQLException p) {
////        p.printStackTrace();
////        }
////
////        try { 
////        sta.executeQuery("INSERT INTO datos(nombre, apellidopat, apellidomat, escuela) VALUES('"+nom+"', '"+ap+"', '"+am+"', '"+sc+"')");
////        }
////        catch (SQLException error){
////            error.printStackTrace();
////        }
//
//
////        try (Connection connection = DriverManager.getConnection(
////            "jdbc:mysql://localhost/JavaDatos", "root", "n0m3l0");
////            Statement sta = connection.createStatement()) 
////            {
////        String query = "INSERT INTO datos(nombre, apellidopat, apellidomat, escuela) VALUES('"+nom+"', '"+ap+"', '"+am+"', '"+sc+"')";
////                try { 
////                    sta.executeUpdate(query);
////                }
////                catch (SQLException error) {
////                error.printStackTrace();
////                }
////            }
////        catch (SQLException error) {
////        error.printStackTrace();
////        }
//        
//        JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.", "¡Listo!" , JOptionPane.INFORMATION_MESSAGE);
//        
////         try{
////            
////            sta.close();
////            con.close();
////            } 
////         catch (SQLException error){
////            error.printStackTrace();
////        } 
//     }
//    }
//    
//    public void ejecutarConsulta(Connection con) {
//        String nom=nombre.getText();
//         String ap=ap_pat.getText();
//         String am=ap_mat.getText();
//         String sc=escuela.getText();
//        
//        try {
//            String SQL = "INSERT INTO datos(nombre, apellidopat, apellidomat, escuela) VALUES('"+nom+"', '"+ap+"', '"+am+"', '"+sc+"')";
//            Statement stmt = con.createStatement();
//            int count = stmt.executeUpdate(SQL);
//            System.out.println("filas afectadas: " + count);
//            stmt.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    
}
