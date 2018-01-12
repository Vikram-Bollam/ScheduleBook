package full.aw.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class DaoImpl implements UserCurdOperations {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	@Override
	public boolean checkUser(String userName) {
		Key k = KeyFactory.createKey("Users", userName);
		try {
			@SuppressWarnings("unused")
			Entity e = ds.get(k);
			return true;
		} catch (EntityNotFoundException e) {
			return false;
		}
	}
	@Override
	public boolean updateUser(String userid, String userName, String userEmail, String userPhone, String businessName,
			String userPass, String openTime, String closeTime) {
		Key k = KeyFactory.createKey("Users", userid);
		try {
			Entity e = ds.get(k);
			e.setProperty("UserName" , userName);
			e.setProperty("UserEmail" , userEmail);
			e.setProperty("UserPhone" , userPhone);
			e.setProperty("BusinessName" , businessName);
			e.setProperty("userPass" , userPass);
			e.setProperty("OpenTime" , openTime);
			e.setProperty("CloseTime" , closeTime);
			ds.put(e); 
			return true;
		} catch (EntityNotFoundException e) {
			return false;
		}

	}
	@Override
	public boolean deleteUser(String user) {
		// TODO Auto-generated method stub
		return false;
	}

}
