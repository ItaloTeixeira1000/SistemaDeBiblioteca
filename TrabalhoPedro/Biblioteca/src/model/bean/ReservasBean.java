package model.bean;

public class ReservasBean {
	private int idemprestimoLivro;
	private String nomeLivro;
	private String dataEmprestimo;
	private String nomeLeitor;
	private String dataDevolucao;
	public int getIdemprestimoLivro() {
		return idemprestimoLivro;
	}
	public void setIdemprestimoLivro(int idemprestimoLivro) {
		this.idemprestimoLivro = idemprestimoLivro;
	}
	public String getNomeLivro() {
		return  nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		
		this.nomeLivro =  nomeLivro;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Object getNomeLeitor() {
		return  nomeLeitor;
	}
	public void setNomeLeitor(String nomeLeitor) {
		
		this.nomeLeitor =  nomeLeitor;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	

}
