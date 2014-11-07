import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;


public class SerializerUtil<P> {

	/**
	 * @param args
	 */
	
	public void serializeArrayList(ArrayList<P> input, String fileName) {

		try {
			FileOutputStream out = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(input);
			oos.flush();
		} catch (Exception e) {
			System.out.println("Problem serializing: " + e);
		}

	}
	public ArrayList<P> deserializeArrayList(String fileName){
		
		ArrayList<P> output = null;

		    try {
		      FileInputStream in = new FileInputStream(fileName);
		      ObjectInputStream ois = new ObjectInputStream(in);
		      output = (ArrayList<P>) (ois.readObject());
		    } catch (Exception e) {
		      System.out.println("Problem serializing: " + e);
		    }
		return output;
	}
	
	
	public void serializeMap(Map<P, Boolean> input, String fileName) {

		try {
			FileOutputStream out = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(input);
			oos.flush();
		} catch (Exception e) {
			System.out.println("Problem serializing: " + e);
		}

	}
	
	public Map<P, Boolean> deserializeMap(String fileName) {

		Map<P, Boolean> output = null;

	    try {
	      FileInputStream in = new FileInputStream(fileName);
	      ObjectInputStream ois = new ObjectInputStream(in);
	      output = (Map<P, Boolean>) (ois.readObject());
	    } catch (Exception e) {
	      System.out.println("Problem serializing: " + e);
	    }
	return output;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
