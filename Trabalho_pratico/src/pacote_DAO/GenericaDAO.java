package pacote_DAO;

public interface GenericaDAO<X> {
	public int insert(X obj);
	public int update(X obj);
	public int delete(X obj);
	//public java.util.List<X> listAll();
	public X findByID(int id);
	

}
