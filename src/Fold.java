import java.util.Collection;


public class Fold {

	public static<T,S> S fold(Collection<T> collection, Join<T,S> joiner){
		S currentValue = null;
		for(T elm:collection){
			currentValue = joiner.join(elm, currentValue);
		}
		
		return currentValue;
	}
}
