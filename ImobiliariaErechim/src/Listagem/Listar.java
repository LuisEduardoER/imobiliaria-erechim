/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listagem;
import Base.Locador;
import GUI.Login;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Suporte
 */
public class Listar {
    Connection conexao;
    public static List<Locador> listaLocadores = new ArrayList<Locador>();
    public static Locador locador = new Locador();
     public void ListarLocador(){
        String sql = "SELECT * FROM locador";
        this.conexao = (Connection) new Login().getConnection();
        String nome,sobrenome,rua,bairro,cidade,tel_res,tel_com,tel_cel,rg,cpf,comentarios;
        double renda;
        int status,codigo;
        
        try{
            
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                codigo = rs.getInt("CODIGO");
                nome = rs.getString("NOME");
                sobrenome = rs.getString("SOBRENOME");;
                rua = rs.getString("RUA");
                bairro = rs.getString("BAIRRO");
                cidade = rs.getString("CIDADE");
                tel_res = rs.getString("TELEFONE_RES");
                tel_com = rs.getString("TELEFONE_COM");
                tel_cel = rs.getString("TELEFONE_CEL");
                rg = rs.getString("RG");
                cpf = rs.getString("CPF");
                comentarios = rs.getString("COMENTARIOS");
                renda = rs.getDouble("RENDA");
                status =rs.getInt("STATUS");
                
                locador.setCodigo(codigo);
                locador.setNome(nome);
                locador.setSobrenome(sobrenome);
                locador.setRua(rua);
                locador.setBairro(bairro);
                locador.setCidade(cidade);
                locador.setTel_res(tel_res);
                locador.setTel_com(tel_com);
                locador.setTel_cel(tel_cel);
                locador.setRg(rg);
                locador.setCpf(cpf);
                locador.setComentarios(comentarios);
                locador.setRenda(renda);
                locador.setStatus(status);
                listaLocadores.add(locador);
            }
            
            
            
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
