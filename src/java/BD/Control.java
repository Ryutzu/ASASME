package BD;

import encriptacion.DesEncrypter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control extends cDatos{
    String SERVPASS = ""; //llave
    String IDU="",PSW="",ticket="",IDS="Serviker";
    boolean oc=false;
    public Control() throws Exception{
        conectar();
    }
    public Control(String ID) throws Exception{
        conectar();
        this.IDU = ID;
    }
    public void setIDU(String nom) {
        this.IDU = nom;
    }
    
    public boolean PERMISO(String psw){
        try{
            ResultSet rs = consulta("call GetPassU('"+IDU+"')");
            if(rs.next()){
                PSW = rs.getString("PASS");
            }
            if(this.PSW.equals(psw)){
                oc = true;
            }
        }catch(Exception xD){
            System.out.println(xD.getMessage());
            oc = false;
        }
        return oc;
    }
    
    public void GenTicket(String Address,String vida){
        try{
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            ResultSet rs = consulta("call GetPassS('"+IDS+"')");
            if(rs.next()){
                SERVPASS = rs.getString("SERVPASS");
            }
            ticket = IDU+"&"+Address+"&"+IDS+"&"+TS+"&"+vida;
            DesEncrypter en = new DesEncrypter(SERVPASS);
            ticket = en.encrypt(ticket);
        }catch(Exception xD){
            System.out.println(xD.getMessage());
        }
    }
    
    public String GetTicket(){
        return ticket;
    }

    public String getIDU() {
        return IDU;
    }
}
