package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;


@WebServlet("/ClienteUpdate")
public class ClienteFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClienteFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clienteIdCliente = Integer.parseInt(request.getParameter("clienteIdCliente"));
		Cliente cliente = ClienteDao.findByPk(clienteIdCliente);
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente()	;
		
		cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		cliente.setNome(request.getParameter("name"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setIdade(request.getParameter("idade"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setEmail(request.getParameter("email"));
		
		ClienteDao.update(cliente);
		
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
		
		
	}

}
