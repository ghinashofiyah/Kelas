
package kelas;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class user {
    String user_name, user_email, user_password, user_fullname;
    int user_status;
    
    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public user() throws SQLException{
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDB();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public Connection getKonek() {
        return konek;
    }

    public void setKonek(Connection konek) {
        this.konek = konek;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
  
public void tambahUser(){
        query = "INSERT INTO user VALUES(?,?,MD5(?),?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, user_name);
            ps.setString(2, user_email);
            ps.setString(3, user_password);
            ps.setString(4, user_fullname);
            ps.setInt(5, user_status);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "User Gagal");
        }
    }

public ResultSet tampilUser(){
        query = "SELECT * FROM user";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }



    public void hapusdata(){
        query = "DELETE FROM user_name = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, user_name);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "User Gagal Dihapus");

}

}

    public void ubahData(){
        if (user_password.equals("")) {
            query = "UPDATE user SET "
                    + "user_email = ?, "
                    + "user_fullname = ?, "
                    + "user_status= ? "
                    + "WHERE user_name = ?";
            
            try {
            ps = konek.prepareStatement(query);
            ps.setString(1, user_email);
            ps.setString(2, user_fullname);
            ps.setInt(3, user_status);
            ps.setString(4, user_name);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User berhasil Diubah");
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "User Gagal Diubah");
        }        
        }else{
        query = "UPDATE user SET "
                    + "user_email = ?, "
                    + "user_fullname = ?, "
                    + "user_status= ?,"
                    + "user_password = MD5(?)"
                    + "WHERE user_name = ?";
            
            try {
            ps = konek.prepareStatement(query);
            
            ps.setString(1, user_email);
            ps.setString(2, user_fullname);
            ps.setInt(3, user_status);
            ps.setString(4, user_password);
            ps.setString(5, user_name);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User berhasil Diubah");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "User Gagal Diubah");
        }    
        }
}
}