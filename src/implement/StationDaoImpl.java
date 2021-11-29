package implement;

import dao.BaseDao;
import dao.StationDao;
import model.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StationDaoImpl extends BaseDao implements StationDao {

    /* 查询所有检测站数据 */
    @Override
    public ArrayList<Site> allStationQuery() throws Exception {

        ArrayList<Site> siteList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM Detection_site";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Site site = new Site();
            site.setId(result.getString(1).trim());
            site.setName(result.getString(2).trim());
            site.setLatitude(result.getFloat(3));
            site.setLongitude(result.getFloat(4));
            site.setDescribe(result.getString(5).trim());
            siteList.add(site);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!siteList.isEmpty()) {
            return siteList;
        } else {
            return null;
        }

    }

    /* 查询某一检测站数据 */
    @Override
    public ArrayList<Site> allStationQuery(String detection_id) throws Exception {
        ArrayList<Site> siteList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM Detection_site where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Site site = new Site();
            site.setId(result.getString(1).trim());
            site.setName(result.getString(2).trim());
            site.setLatitude(result.getFloat(3));
            site.setLongitude(result.getFloat(4));
            site.setDescribe(result.getString(5).trim());
            siteList.add(site);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!siteList.isEmpty()) {
            return siteList;
        } else {
            return null;
        }
    }

    /* 修改某一检测站数据 */
    @Override
    public boolean updateStation(Site site) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "update Detection_site set Detection_name=?,Detection_latitude=?,Detection_longitude=?,Detection_describe=? where Detection_id=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, site.getName());
        pstmt.setFloat(2, site.getLatitude());
        pstmt.setFloat(3, site.getLongitude());
        pstmt.setString(4, site.getDescribe());
        pstmt.setString(5, site.getId());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /* 删除某一检测站数据 */
    @Override
    public boolean deleteStation(String detection_id) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "delete from Detection_site where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    /* 插入数据 */
    @Override
    public boolean insertStation(Site site) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "insert into Detection_site values(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(2, site.getName());
        pstmt.setFloat(3, site.getLatitude());
        pstmt.setFloat(4, site.getLongitude());
        pstmt.setString(5, site.getDescribe());
        pstmt.setString(1, site.getId());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

}
