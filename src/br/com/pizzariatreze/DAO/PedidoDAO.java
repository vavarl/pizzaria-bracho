package br.com.pizzariatreze.DAO;

import br.com.pizzariatreze.BD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.pizzariatreze.model.Cliente;
import br.com.pizzariatreze.model.Funcionario;
import br.com.pizzariatreze.model.Pedido;

public class PedidoDAO {

    private ArrayList<PedidoDAO> pedidos = null;
    private PedidoDAO pedido = null;
    private Connection con = null;
    
    public PedidoDAO getById(int id) {
        this.pedido = null;
        PreparedStatement ps = null;
        String produtos = null;
        String[] produtosSplit = null;
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT * FROM pedido WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.pedido = new PedidoDAO();
                this.pedido.setId(rs.getInt("id"));
                this.pedido.setData(rs.getString("data"));
                this.pedido.setStatus(rs.getInt("status"));
                this.pedido.setDescricao(rs.getString("descricao"));
                this.pedido.setTipo(rs.getInt("tipo"));
                this.pedido.setPreco(rs.getDouble("preco"));
                this.pedido.setIdCliente(rs.getInt("id_cliente"));
                this.pedido.setIdFuncionario(rs.getInt("id_funcionario"));
                produtos = rs.getString("composicao");
                produtosSplit = produtos.split(",");
                for (int i = 0; i < produtosSplit.length; i++) {
                    this.pedido.setComposicao(Integer.parseInt(produtosSplit[i]));
                }
                return this.pedido;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<PedidoDAO> getByData(String data) {
        this.pedido = null;
        this.pedidos.clear();
        PreparedStatement ps = null;
        String produtos = null;
        String[] produtosSplit = null;
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT * FROM pedido WHERE data = ?");
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()) {
                return null;
            }
            
            do {
                this.pedido = new PedidoDAO();
                this.pedido.setId(rs.getInt("id"));
                this.pedido.setData(rs.getString("data"));
                this.pedido.setStatus(rs.getInt("status"));
                this.pedido.setDescricao(rs.getString("descricao"));
                this.pedido.setTipo(rs.getInt("tipo"));
                this.pedido.setPreco(rs.getDouble("preco"));
                this.pedido.setIdCliente(rs.getInt("id_cliente"));
                this.pedido.setIdFuncionario(rs.getInt("id_funcionario"));
                produtos = rs.getString("composicao");
                produtosSplit = produtos.split(",");
                for (int i = 0; i < produtosSplit.length; i++) {
                    this.pedido.setComposicao(Integer.parseInt(produtosSplit[i]));
                }
                this.pedidos.add(this.pedido);
                return this.pedidos;
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<PedidoDAO> getByStatus(int status) {
        this.pedido = null;
        this.pedidos.clear();
        PreparedStatement ps = null;
        String produtos = null;
        String[] produtosSplit = null;
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT * FROM pedido WHERE status = ?");
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()) {
                return null;
            }
            
            do {
                this.pedido = new PedidoDAO();
                this.pedido.setId(rs.getInt("id"));
                this.pedido.setData(rs.getString("data"));
                this.pedido.setStatus(rs.getInt("status"));
                this.pedido.setDescricao(rs.getString("descricao"));
                this.pedido.setTipo(rs.getInt("tipo"));
                this.pedido.setPreco(rs.getDouble("preco"));
                this.pedido.setIdCliente(rs.getInt("id_cliente"));
                this.pedido.setIdFuncionario(rs.getInt("id_funcionario"));
                produtos = rs.getString("composicao");
                produtosSplit = produtos.split(",");
                for (int i = 0; i < produtosSplit.length; i++) {
                    this.pedido.setComposicao(Integer.parseInt(produtosSplit[i]));
                }
                this.pedidos.add(this.pedido);
                return this.pedidos;
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<PedidoDAO> getByTipo(int tipo) {
        this.pedido = null;
        this.pedidos.clear();
        PreparedStatement ps = null;
        String produtos = null;
        String[] produtosSplit = null;
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT * FROM pedido WHERE tipo = ?");
            ps.setInt(1, tipo);
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()) {
                return null;
            }
            
            do {
                this.pedido = new PedidoDAO();
                this.pedido.setId(rs.getInt("id"));
                this.pedido.setData(rs.getString("data"));
                this.pedido.setStatus(rs.getInt("status"));
                this.pedido.setDescricao(rs.getString("descricao"));
                this.pedido.setTipo(rs.getInt("tipo"));
                this.pedido.setPreco(rs.getDouble("preco"));
                this.pedido.setIdCliente(rs.getInt("id_cliente"));
                this.pedido.setIdFuncionario(rs.getInt("id_funcionario"));
                produtos = rs.getString("composicao");
                produtosSplit = produtos.split(",");
                for (int i = 0; i < produtosSplit.length; i++) {
                    this.pedido.setComposicao(Integer.parseInt(produtosSplit[i]));
                }
                this.pedidos.add(this.pedido);
                return this.pedidos;
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<PedidoDAO> getByCliente(int idCliente) {
        Cliente cliente = new Cliente();
        this.pedido = null;
        this.pedidos.clear();
        PreparedStatement ps = null;
        String produtos = null;
        String[] produtosSplit = null;
        
        try {
            cliente = cliente.getById(idCliente);
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT * FROM pedido WHERE id_cliente = ?");
            ps.setInt(1, cliente.getId());
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()) {
                return null;
            }
            
            do {
                this.pedido = new PedidoDAO();
                this.pedido.setId(rs.getInt("id"));
                this.pedido.setData(rs.getString("data"));
                this.pedido.setStatus(rs.getInt("status"));
                this.pedido.setDescricao(rs.getString("descricao"));
                this.pedido.setTipo(rs.getInt("tipo"));
                this.pedido.setPreco(rs.getDouble("preco"));
                this.pedido.setIdCliente(rs.getInt("id_cliente"));
                this.pedido.setIdFuncionario(rs.getInt("id_funcionario"));
                produtos = rs.getString("composicao");
                produtosSplit = produtos.split(",");
                for (int i = 0; i < produtosSplit.length; i++) {
                    this.pedido.setComposicao(Integer.parseInt(produtosSplit[i]));
                }
                this.pedidos.add(this.pedido);
                return this.pedidos;
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<PedidoDAO> getByFuncionario(int idFuncionario) {
        Funcionario funcionario = new Funcionario();
        this.pedido = null;
        this.pedidos.clear();
        PreparedStatement ps = null;
        String produtos = null;
        String[] produtosSplit = null;
        
        try {
            funcionario = funcionario.getById(idFuncionario);
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT * FROM pedido WHERE id_funcionario = ?");
            ps.setInt(1, funcionario.getId());
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()) {
                return null;
            }
            
            do {
                this.pedido = new PedidoDAO();
                this.pedido.setId(rs.getInt("id"));
                this.pedido.setData(rs.getString("data"));
                this.pedido.setStatus(rs.getInt("status"));
                this.pedido.setDescricao(rs.getString("descricao"));
                this.pedido.setTipo(rs.getInt("tipo"));
                this.pedido.setPreco(rs.getDouble("preco"));
                this.pedido.setIdCliente(rs.getInt("id_cliente"));
                this.pedido.setIdFuncionario(rs.getInt("id_funcionario"));
                produtos = rs.getString("composicao");
                produtosSplit = produtos.split(",");
                for (int i = 0; i < produtosSplit.length; i++) {
                    this.pedido.setComposicao(Integer.parseInt(produtosSplit[i]));
                }
                this.pedidos.add(this.pedido);
                return this.pedidos;
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public String save(PedidoDAO pedido) {
        String result = "Erro ao inserir/atualizar o cliente";
        String query = null;
        PreparedStatement ps = null;
        String produtos = null;
        if(pedido.getId() != 0) {
            PedidoDAO pedidoBD = this.getById(pedido.getId());
            if(pedidoBD != null) {
                query = "UPDATE pedido SET data = ?, status = ?, descricao = ?, tipo = ?, preco = ?, id_cliente = ?, id_funcionario = ?, composicao = ? WHERE id = ?";
                try {
                    ps = Conexao.getConexao().prepareStatement(query);
                    ps.setString(1, pedido.getData());
                    ps.setInt(2, pedido.getStatus());
                    ps.setString(3, pedido.getDescricao());
                    ps.setInt(4, pedido.getTipo());
                    ps.setDouble(5, pedido.getPreco());
                    ps.setInt(6, pedido.getIdCliente());
                    ps.setInt(7, pedido.getIdFuncionario());
                    produtos = String.valueOf(pedido.getComposicao().get(0));
                    for(int i = 1; i < pedido.getComposicao().size(); i++) {
                        produtos = produtos + "," + String.valueOf(pedido.getComposicao().get(i));
                    }
                    ps.setString(8, produtos);
                    ps.setInt(9, pedido.getId());
                    ps.executeUpdate();
                    
                    return "Pedido atualizado com sucesso.";
                } catch (SQLException ex) {
                    return "Erro ao atualizar pedido: " + ex.getMessage();
                }
            }
        }
        
        try {
            query = pedido.getId() != 0 ? "INSERT INTO pedido(data, status, descricao, tipo, preco, id_cliente, id_funcionario, composicao, id) VALUES (?,?,?,?,?,?,?,?,?)" : "INSERT INTO pedido(data, status, descricao, tipo, preco, id_cliente, id_funcionario, composicao) VALUES (?,?,?,?,?,?,?,?)";
            ps = Conexao.getConexao().prepareStatement(query);
            ps.setString(1, pedido.getData());
            ps.setInt(2, pedido.getStatus());
            ps.setString(3, pedido.getDescricao());
            ps.setInt(4, pedido.getTipo());
            ps.setDouble(5, pedido.getPreco());
            ps.setInt(6, pedido.getIdCliente());
            ps.setInt(7, pedido.getIdFuncionario());
            produtos = String.valueOf(pedido.getComposicao().get(0));
            for(int i = 1; i < pedido.getComposicao().size(); i++) {
                produtos = produtos + "," + String.valueOf(pedido.getComposicao().get(i));
            }
            ps.setString(8, produtos);
            ps.setInt(9, pedido.getId());
            ps.executeUpdate();
            result = "Pedido criado com sucesso.";
        } catch (SQLException ex) {
            return "Erro ao inserir pedido: " + ex.getMessage();
        }
        
        return result;
    }
}
