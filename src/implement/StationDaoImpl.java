package implement;

import dao.StationDao;
import model.Station;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StationDaoImpl extends BaseDao implements StationDao {

    /**
     * 查询所有检测站数据
     *
     * @return 检测站数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<Station> allStationQuery() throws Exception {
        ArrayList<Station> siteList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM station";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Station site = new Station();
            site.setStationId(result.getString(1).trim());
            site.setLongitude(result.getFloat(2));
            site.setLatitude(result.getFloat(3));
            site.setAddress(result.getString(4).trim());
            site.setStationName(result.getString(5).trim());
            site.setPhone(result.getString(6).trim());
            site.setMaxNum(result.getInt(7));
            siteList.add(site);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!siteList.isEmpty()) {
            return siteList;
        } else {
            return null;
        }
    }

    /**
     * 查询某一检测站数据
     *
     * @param stationId
     * @return 指定编号检测站数据
     * @throws Exception
     */
    @Override
    public Station selectStationById(String stationId) throws Exception {
        Station station = null;
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM station where stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            station = new Station();
            station.setStationId(result.getString(1).trim());
            station.setLongitude(result.getFloat(2));
            station.setLatitude(result.getFloat(3));
            station.setAddress(result.getString(4).trim());
            station.setStationName(result.getString(5).trim());
            station.setPhone(result.getString(6).trim());
            station.setMaxNum(result.getInt(7));
        }
        BaseDao.closeAll(conn, pstmt, result);
        return station;
    }

    /**
     * 修改某一检测站数据
     *
     * @param station
     * @return 修改是否成功
     * @throws Exception
     */
    @Override
    public boolean updateStation(Station station) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "update station set latitude=?,longitude=?,address=?,stationName=?,phone=?,maxNum=? where stationId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setFloat(1, station.getLatitude());
        pstmt.setFloat(2, station.getLongitude());
        pstmt.setString(3, station.getAddress());
        pstmt.setString(4, station.getStationName());
        pstmt.setString(5, station.getPhone());
        pstmt.setInt(6, station.getMaxNum());
        pstmt.setString(7, station.getStationId());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 删除某一检测站数据
     *
     * @param stationId
     * @return 删除是否成功
     * @throws Exception
     */
    @Override
    public boolean deleteStationById(String stationId) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "delete from station where stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 添加一检测站数据
     *
     * @param station
     * @return 添加是否成功
     * @throws Exception
     */
    @Override
    public boolean insertStation(Station station) throws Exception {
        Connection conn = BaseDao.getConnection();

        // 获取最大编号，自动加一生成最新编号
        int stationId = 0;
        String sql = "select stationId from station order by stationId desc limit 1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            String temp = result.getString(1);
            stationId = Integer.parseInt(temp) + 1;
        }

        sql = "insert into station values(?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId + "");
        pstmt.setFloat(2, station.getLongitude());
        pstmt.setFloat(3, station.getLatitude());
        pstmt.setString(4, station.getAddress());
        pstmt.setString(5, station.getStationName());
        pstmt.setString(6, station.getPhone());
        pstmt.setInt(7, station.getMaxNum());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
