package dao;

import model.Car;

public interface CarDao {

    /* 查询车辆相关信息 根据车牌 */
    Car queryInfo(String car_id) throws Exception;
}
