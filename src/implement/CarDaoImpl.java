package implement;

import dao.BaseDao;
import dao.CarDao;
import model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarDaoImpl implements CarDao {

    /* 查询车辆相关信息 根据车牌 */
    @Override
    public Car queryInfo(String car_id) throws Exception {
        Car car = new Car();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM car_annual_inspection where car_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,car_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            car.setCar_id(result.getString(1));
            car.setCar_modle(result.getString(2));
            car.setCar_age(result.getString(3));
            car.setEndorsement_YorN(result.getString(4));
            car.setRecently_AS(result.getString(5));
        }
        BaseDao.closeAll(conn, pstmt, result);
        return car;
    }
}
