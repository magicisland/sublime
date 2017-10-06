package test;

import java.util.List;

import model.Track;
import utils.HibernateUtils;

public class LoadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Track track=null;
		HibernateUtils hbUtils = new HibernateUtils();
		
		for (int i=0; i < 10 ; i++){
			track=new Track();
			track.setDetalle(" detalle numero " + i);
			track.setName("Marcelo " + i);
			hbUtils.save(track);
		}
		
		List<Object[]> query = hbUtils.get("select * from Track where id=2");
	
		for (Object[] o:query){
			Track t=new Track();
			t.setId((int)o[0]);
			t.setName((String)o[1]);
			t.setDetalle((String)o[2]);
			System.out.println(t);
			
		}
		
		
	}

}
