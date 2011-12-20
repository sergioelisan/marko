package br.ufrpe.bcc.ibusiness.venda;

import br.ufrpe.bcc.ibusiness.funcionario.Funcionario;
import br.ufrpe.bcc.ibusiness.cliente.Cliente;
import br.ufrpe.bcc.idatabase.Conexao;
import br.ufrpe.bcc.idatabase.DAOUtil;
import java.sql.*;
import java.util.*;

/**
 *
 * @author douglas
 */
public class DAOVenda implements IVenda {

    @Override
    public void inserirVenda(Venda venda) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Venda> listarVendas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Venda buscarVendaId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Venda buscarVendaCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Venda buscarVendaFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
