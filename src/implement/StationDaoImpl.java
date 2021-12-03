package implement;

import utils.BaseDao;
import dao.StationDao;
import model.Station;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StationDaoImpl extends BaseDao implements StationDao {
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
}
