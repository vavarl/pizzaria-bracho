package br.com.pizzariatreze.tablemodel;

import br.com.pizzariatreze.dto.ClienteDto;
import br.com.pizzariatreze.dto.FuncionarioDto;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTableModel extends AbstractTableModel {
    /* Lista para armazenar os cabeçalhos da tabela */

    private Vector colunas;

    /* Lista para armazenar os dados da tabela */
    private Vector linhas;

    public FuncionarioTableModel() {
        /* Definição das colunas da tabela */
        colunas = new Vector();
        colunas.add("ID");
        colunas.add("Nome");
        colunas.add("Cargo");
        colunas.add("Salario");

        /* Definição dos dados da tabela */
        linhas = new Vector();
    }

    public int getRowCount() {
        /* Captura o total de linhas da tabela */
        int totalLinhas = linhas.size();

        /* Retorna o total de linhas */
        return totalLinhas;
    }

    public int getColumnCount() {
        /* Captura o total de colunas da tabela */
        int totalColunas = colunas.size();

        /* Retorna o total de colunas */
        return totalColunas;
    }

    public String getColumnName(int coluna) {
        /* Captura o nome da coluna */
        String nomeColuna = (String) colunas.get(coluna);

        /* Retorna o nome da coluna */
        return nomeColuna;
    }

    public Object getValueAt(int linha, int coluna) {
        /* Captura o registro informado */
        Vector registro = (Vector) linhas.get(linha);

        /* Dentro do registro captura a coluna selecionada */
        Object dado = registro.get(coluna);

        /* Retorna o valor capturado */
        return dado;
    }

    public void adicionar(List<Object> lista) {
        /* Reinicializa os dados da tabela */
        linhas = new Vector();

        /* Percorre a lista copiando os dados para a tabela */
        for (Object d : lista) {
            FuncionarioDto funcionario = new FuncionarioDto();
            funcionario = (FuncionarioDto) d;
            /* Cria uma linha da tabela */
            Vector<Object> linha = new Vector();
            linha.add(funcionario.getId());
            linha.add(funcionario.getNome());
            linha.add(funcionario.getCargo());
            linha.add(funcionario.getSalario());
            /* Adiciona a linha a tabela */
            linhas.add(linha);
        }

        /* Atualiza a tabela */
        fireTableDataChanged();
    }

}
