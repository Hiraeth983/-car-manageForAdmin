package dao;

import java.util.ArrayList;
import model.*;

public interface StationDao {

    /* 查询所有检测站数据 */
    ArrayList<Site> allStationQuery() throws Exception;

    /* 查询某一检测站数据 */
    ArrayList<Site> allStationQuery(String detection_id) throws Exception;

    /* 修改某一检测站数据 */
    boolean updateStation(Site site) throws Exception;

    /* 删除某一检测站数据 */
    boolean deleteStation(String detection_id) throws Exception;

    /* 插入数据 */
    boolean insertStation(Site site) throws Exception;


}
