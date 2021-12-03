package dao;

import model.Station;

import java.util.ArrayList;

public interface StationDao {

    /**
     * 查询所有检测站数据
     * @return 检测站数据数组
     * @throws Exception
     */
    ArrayList<Station> allStationQuery() throws Exception;

    /**
     * 查询某一检测站数据
     * @param stationId
     * @return 指定编号检测站数据
     * @throws Exception
     */
    Station selectStationById(String stationId) throws Exception;

    /**
     * 修改某一检测站数据
     * @param station
     * @return 修改是否成功
     * @throws Exception
     */
    boolean updateStation(Station station) throws Exception;

    /**
     * 删除某一检测站数据
     * @param stationId
     * @return 删除是否成功
     * @throws Exception
     */
    boolean deleteStationById(String stationId) throws Exception;

    /**
     * 添加一检测站数据
     * @param station
     * @return 添加是否成功
     * @throws Exception
     */
    boolean insertStation(Station station) throws Exception;

}
