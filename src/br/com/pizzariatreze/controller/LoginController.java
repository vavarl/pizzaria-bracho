package br.com.pizzariatreze.controller;

import br.com.pizzariatreze.model.Funcionario;

public class LoginController {
    
    public LoginController(){
    }
    
    public boolean logar(String usuario, char[] senha){
        Funcionario funcionario = new Funcionario();
        
        return funcionario.login(usuario, senha);
    }
}
