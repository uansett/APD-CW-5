import java.util.ArrayList;
import java.util.Collection;


public class Fold {

	public static<T,S> S fold(ArrayList<T> collection, Join<T,S> joiner, S currentVal){
		if(collection.size() == 0) 
			return currentVal;
		return joiner.join(collection.remove(0),fold(collection,joiner,currentVal));
		
	}
}
