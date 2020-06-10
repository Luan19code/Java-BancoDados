/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luanl
 */
public class TableModel extends AbstractTableModel {

    private List<Models_Menbros> lista;
    private String[] colunas = {"Codigo", "Nome", "Telefone", "Status"};

    public TableModel(List<Models_Menbros> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        Models_Menbros menbros = lista.get(i);
        switch (i1) {
            case 0:
                menbros.setCodigo(Long.parseLong(o.toString()));
                break;
            case 1:
                menbros.setNome(o.toString());
                break;
            case 2:
                menbros.setTelefone(o.toString());
                break;
            case 3:
                menbros.setStatus(o.toString());
                break;
            default:
                System.err.println("Indice da coluna invalido");
                break;
        }
        fireTableCellUpdated(i, i1);
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Models_Menbros menbrosSelec = lista.get(i);
        Object valorObj = null;
        switch (i1) {
            case 0:
                valorObj = menbrosSelec.getCodigo();
                break;
            case 1:
                valorObj = menbrosSelec.getNome();
                break;
            case 2:
                valorObj = menbrosSelec.getTelefone();
                break;
            case 3:
                valorObj = menbrosSelec.getStatus();
                break;
            default:

                break;
        }
        return valorObj;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    public Object getSelec(int i) {
        if (lista.size() != 0) {
            return lista.get(i);
        } else {
            return null;
        }

    }

    public void atualizarDados(List<Models_Menbros> membros) {
        this.lista = membros;
        fireTableDataChanged();

    }

    public void Limpar() {
        lista.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
}
