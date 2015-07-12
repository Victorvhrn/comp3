package interfaces;

import java.util.Collection;


public interface RoteiroListagem<T> {
	
	public Collection<T> execute() throws Exception;
	
}