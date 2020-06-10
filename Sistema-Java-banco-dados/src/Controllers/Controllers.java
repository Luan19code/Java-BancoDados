/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conexao.ConexaoBD;
import Models.Models_Menbros;
import Telas.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luanl
 */
public class Controllers {
    
    Conexao.ConexaoBD con = new ConexaoBD();
    
    public void inserir(Models.Models_Menbros membro) {
        try {
            Connection con = Conexao.ConexaoBD.conectar();
            String sql = "insert into membros (nome, telefone, status, imagem, img_arq ) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, membro.getNome());
            prep.setString(2, membro.getTelefone());
            prep.setString(3, membro.getStatus());
            prep.setString(4, "imagem");
            if (membro.getImg_arq() != null) {
                prep.setBytes(5, membro.getImg_arq());
            }else{
                prep.setBytes(5, null);
            }
            prep.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Models_Menbros membro) {
        try {
            try (Connection con = Conexao.ConexaoBD.conectar()) {
                String sql = "delete from membros where codigo = ?";
                try (PreparedStatement prep = con.prepareStatement(sql)) {
                    prep.setLong(1, membro.getCodigo());
                    
                    prep.execute();
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Models_Menbros membro) {
        try {
            Connection con = Conexao.ConexaoBD.conectar();
            String sql = "UPDATE membros SET nome = ?, telefone = ?, status = ?,imagem = ?, img_arq = ? WHERE codigo = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, membro.getNome());
            prep.setString(2, membro.getTelefone());
            prep.setString(3, membro.getStatus());
            prep.setString(4, membro.getImagem());
            prep.setBytes(5, membro.getImg_arq());
            prep.setLong(6, membro.getCodigo());
            
            prep.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Models_Menbros> listar() {
        String sql = "select * from membros";
        List<Models_Menbros> lista_membros = new ArrayList<>();
        try {
            Connection con = Conexao.ConexaoBD.conectar();
            
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                Models_Menbros membro = new Models_Menbros();
                membro.setCodigo(rs.getLong("codigo"));
                membro.setNome(rs.getString("nome"));
                membro.setTelefone(rs.getString("telefone"));
                membro.setStatus(rs.getString("status"));
                membro.setImagem(rs.getString("imagem"));
                membro.setImg_arq(rs.getBytes("img_arq"));
                lista_membros.add(membro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_membros;
    }
    
    public void fecharCon() {
        try {
            Connection con = Conexao.ConexaoBD.conectar();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
