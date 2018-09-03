package restaurant.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import restaurant.dao.RestaurantDao;
import restaurant.entity.RestaurantEntity;
import common.Util.JdbcUtil;

public class RestaurantBiz {

	// 1. 	Show Restaurant List
	// 		- Show Restaurants searched by parameters : Address Gu, Address Dong, Category, Restaurant Name
	public ArrayList<RestaurantEntity> showRestaurantList(String addressGu, String addressDong, String category, String restaurantName) throws SQLException {
		Connection conn = null;
		ArrayList<RestaurantEntity> restaurantList = new ArrayList<>();
		RestaurantDao dao = new RestaurantDao();
		try {
			conn = JdbcUtil.getConnection();
			restaurantList = dao.showRestaurantList(addressGu, addressDong, category, restaurantName, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return restaurantList;
	}
    
    /*
    public int insertDelivery(DeliveryEntity delivery) throws SQLException{
    
    	// TODO 
    	//배송 요청 등록
    	
    	DeliveryDao dao = new DeliveryDao();
    	Connection conn = null;
    	int result = 0;
    	
    	try {
    		conn = getConnection();
			result = dao.insertDelivery(delivery, conn);
			
			commit(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback(conn);
			throw e;
		} finally{
			close(conn);
		}
	
    	return result;
    	
    	
    }
    */
}
