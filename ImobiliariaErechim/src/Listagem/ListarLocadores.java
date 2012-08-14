/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listagem;

import Base.Locador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Suporte
 */
public class ListarLocadores extends AbstractTableModel{
   private List<Locador> listarLocador = new ArrayList<Locador>();
    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;
    public static final int COL_SOBRENOME = 2;
    public static final int COL_RUA = 3;
    public static final int COL_BAIRRO = 4;
    public static final int COL_CIDADE = 5;
    public static final int COL_TEL_RES = 6;
    public static final int COL_TEL_COM = 7;
    public static final int COL_TEL_CEL = 8;
    public static final int COL_RG = 9;
    public static final int COL_CPF = 10;
    public static final int COL_RENDA = 11;
    public static final int COL_STATUS = 12;
    public static final int COL_COMENTARIOS = 13;
    

    public ListarLocadores(List<Locador> listarSerial) {
        this.listarLocador = new ArrayList<Locador>();
    }

    public int getRowCount() {
        return listarLocador.size();
    }

    public int getColumnCount() {
        return 13;
    }

    public Object getValueAt(int linhas, int colunas) {
        Locador locador = this.listarLocador.get(linhas);
        if (colunas == COL_CODIGO) {
            return locador.getCodigo();
        }
        if (colunas == COL_NOME) {
            return locador.getNome();
        }
        if (colunas == COL_SOBRENOME) {
            return locador.getSobrenome();
        }
        if (colunas == COL_RUA){
            return locador.getRua();
        }
        if (colunas == COL_BAIRRO){
            return locador.getBairro();
        }
        if (colunas == COL_CIDADE){
            return locador.getCidade();
        }
        if (colunas == COL_TEL_RES){
            return locador.getTel_res();
        }
        if (colunas == COL_TEL_COM){
            return locador.getTel_com();
        }
        if (colunas == COL_TEL_CEL){
            return locador.getTel_cel();
        }
        if (colunas == COL_RG){
            return locador.getRg();
        }
        if (colunas == COL_CPF){
            return locador.getCpf();
        }
        if (colunas == COL_RENDA){
            return locador.getRenda();
        }
        if (colunas == COL_STATUS){
            return locador.getStatus();
        }
        if (colunas == COL_COMENTARIOS){
            return locador.getComentarios();
        }
        
        
        return "";
    }

    
        public void setValueAt(Object aValue, int rowIndex, int colunas) {
        //pega o produto da linha
        Locador l = this.listarLocador.get(rowIndex);
 
        //verifica qual valor vai ser alterado
        if (colunas == COL_CODIGO) {
            l.setCodigo(Integer.parseInt(aValue.toString()));
        }
        if (colunas == COL_NOME) {
            l.setNome(aValue.toString());
        }
        if (colunas == COL_SOBRENOME) {
            l.setSobrenome(aValue.toString());
        }
        if (colunas == COL_RUA){
            l.setRua(aValue.toString());
        }
        if (colunas == COL_BAIRRO){
            l.setBairro(aValue.toString());
        }
        if (colunas == COL_CIDADE){
            l.setCidade(aValue.toString());
        }
        if (colunas == COL_TEL_RES){
            l.setTel_res(aValue.toString());
        }
        if (colunas == COL_TEL_COM){
            l.setTel_com(aValue.toString());
        }
        if (colunas == COL_TEL_CEL){
            l.setTel_cel(aValue.toString());
        }
        if (colunas == COL_RG){
            l.setRg(aValue.toString());
        }
        if (colunas == COL_CPF){
            l.setCpf(aValue.toString());
        }
        if (colunas == COL_RENDA){
            l.setRenda(Double.parseDouble(aValue.toString()));
        }
        if (colunas == COL_STATUS){
            l.setCodigo(Integer.parseInt(aValue.toString()));
        }
        
        //avisa que os dados mudaram
        fireTableDataChanged();
    }
    
    public String getColumnName(int colunas) {
        if (colunas == COL_CODIGO) {
            return "Código";
        }
        if (colunas == COL_NOME) {
            return "Nome";
        }
        if (colunas == COL_SOBRENOME) {
            return "Sobrenome";
        }
        if (colunas == COL_RUA){
            return "Rua";
        }
        if (colunas == COL_BAIRRO){
            return "Bairro";
        }
        if (colunas == COL_CIDADE){
            return "Cidade";
        }
        if (colunas == COL_TEL_RES){
            return "Telefone Res";
        }
        if (colunas == COL_TEL_COM){
            return "Telefone Com";
        }
        if (colunas == COL_TEL_CEL){
            return "Telefone Cel";
        }
        if (colunas == COL_RG){
            return "RG";
        }
        if (colunas == COL_CPF){
            return "CPF";
        }
        if (colunas == COL_RENDA){
            return "Renda";
        }
        if (colunas == COL_STATUS){
            return "Status";
        }
        if (colunas == COL_COMENTARIOS){
            return "Comentarios";
        }
        
        return "";
    }

    public void addLocador(Locador locador) {
        listarLocador.add(locador);
        int ultimo_indice = getRowCount() - 1;
        fireTableRowsInserted(ultimo_indice, ultimo_indice);
    }


    public void addListaDeLocadores(List<Locador> clientes_lista) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        listarLocador.addAll(listarLocador);

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void inserir(Locador l) {
        listarLocador.add(l);
 
        fireTableDataChanged();
    }
    
    public Locador get(int linhas) {
        return listarLocador.get(linhas);
    }
} 

