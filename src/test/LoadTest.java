package test;

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
	}

}
