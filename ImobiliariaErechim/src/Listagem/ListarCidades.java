/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listagem;

import Base.Cidades;
import Base.Locador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Suporte
 */
public class ListarCidades extends AbstractTableModel{
    private List<Cidades> listarCidades = new ArrayList<Cidades>();
    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;
    public static final int COL_ESTADO = 2;
    

    public ListarCidades(List<Cidades> listarCidades) {
        this.listarCidades = new ArrayList<Cidades>();
    }

    public int getRowCount() {
        return listarCidades.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int linhas, int colunas) {
        Cidades cidades = this.listarCidades.get(linhas);
        if (colunas == COL_CODIGO) {
            return cidades.getId();
        }
        if (colunas == COL_NOME) {
            return cidades.getNome();
        }
        if (colunas == COL_ESTADO) {
            return cidades.getEstado();
        }
         
        return "";
    }

    
        public void setValueAt(Object aValue, int rowIndex, int colunas) {
        //pega o produto da linha
        Cidades l = this.listarCidades.get(rowIndex);
 
        //verifica qual valor vai ser alterado
        if (colunas == COL_CODIGO) {
            l.setId(Integer.parseInt(aValue.toString()));
        }
        if (colunas == COL_NOME) {
            l.setNome(aValue.toString());
        }
        if (colunas == COL_ESTADO) {
            l.setEstado(aValue.toString());
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
        if (colunas == COL_ESTADO) {
            return "Estado";
        }
        
        return "";
    }

    public void addCidades(Cidades cidades) {
        listarCidades.add(cidades);
        int ultimo_indice = getRowCount() - 1;
        fireTableRowsInserted(ultimo_indice, ultimo_indice);
    }


    public void addListaDeLocadores(List<Cidades> cidades_lista) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        listarCidades.addAll(cidades_lista);

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void inserir(Cidades c) {
        listarCidades.add(c);
 
        fireTableDataChanged();
    }
    
    public Cidades get(int linhas) {
        return listarCidades.get(linhas);
    }
    
}
