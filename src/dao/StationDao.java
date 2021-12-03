package dao;

import model.Station;

import java.util.ArrayList;

public interface StationDao {

    /**
     *
     * 查询所有检测站数据
     * @return 检测站数据数组
     * @throws Exception
     */
    ArrayList<Station> allStationQuery() throws Exception;

}
