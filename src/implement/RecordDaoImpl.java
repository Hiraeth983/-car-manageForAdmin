package implement;

import dao.RecordDao;
import model.Record;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecordDaoImpl extends BaseDao implements RecordDao {
    /**
     * 查询所有检测数据
     * @return 检测数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<Record> getRecordList() throws Exception {
        ArrayList<Record> recordList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM record";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Record record = new Record();
            record.setOrderId(result.getString(1).trim());
            record.setIdCard(result.getString(2).trim());
            record.setFullName(result.getString(3).trim());
            record.setCarId(result.getString(4).trim());
            record.setAddress(result.getString(5).trim());
            record.setOrderTime(result.getString(6).trim());
            String checkTime = "待定";
            if(result.getString(7) != null){
                checkTime = result.getString(7);
            }
            record.setCheckTime(checkTime);
            String re = "待定";
            if(result.getString(8) != null){
                re = result.getString(8);
            }
            record.setResult(re);
            String staffName = "待定";
            if(result.getString(9) != null){
                staffName = result.getString(9);
            }
            record.setStaffName(staffName);
            String staffId = "待定";
            if(result.getString(10) != null){
                staffId = result.getString(10);
            }
            record.setStaffId(staffId);
            record.setScore(result.getInt(11));
            record.setProcess(result.getString(12).trim());
            record.setAvailable(result.getInt(13));
            recordList.add(record);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!recordList.isEmpty()) {
            return recordList;
        } else {
            return null;
        }
    }

    /**
     * 查询某一检测数据
     * @param order
     * @return 指定编号检测数据
     * @throws Exception
     */
    @Override
    public Record getRecordById(String order) throws Exception {
        Record record = null;
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM record where order=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, order);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            record = new Record();
            record.setOrderId(result.getString(1).trim());
            record.setIdCard(result.getString(2).trim());
            record.setFullName(result.getString(3).trim());
            record.setCarId(result.getString(4).trim());
            record.setAddress(result.getString(5).trim());
            record.setOrderTime(result.getString(6).trim());
            record.setCheckTime(result.getString(7).trim());
            record.setResult(result.getString(8).trim());
            record.setStaffName(result.getString(9).trim());
            record.setStaffId(result.getString(10).trim());
            record.setScore(result.getInt(11));
            record.setProcess(result.getString(12).trim());
            record.setAvailable(result.getInt(13));
        }
        BaseDao.closeAll(conn, pstmt, result);
        return record;
    }

    /**
     * 根据 orderId 分配任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Boolean assignTaskByOrderId(Record record) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "update record set checkTime=?,staffName=?,staffId=?,process=? where orderId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, record.getCheckTime());
        pstmt.setString(2, record.getStaffName());
        pstmt.setString(3, record.getStaffId());
        pstmt.setString(4, record.getProcess());
        pstmt.setString(5, record.getOrderId());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 查询某一车牌号检测数据
     *
     * @param carId
     * @return 返回某一车牌号检测数据列表
     * @throws Exception
     */
    @Override
    public ArrayList<Record> getRecordByCarId(String carId) throws Exception {
        ArrayList<Record> recordList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM record where binary carId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,carId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Record record = new Record();
            record.setOrderId(result.getString(1).trim());
            record.setIdCard(result.getString(2).trim());
            record.setFullName(result.getString(3).trim());
            record.setCarId(result.getString(4).trim());
            record.setAddress(result.getString(5).trim());
            record.setOrderTime(result.getString(6).trim());
            String checkTime = "待定";
            if(result.getString(7) != null){
                checkTime = result.getString(7);
            }
            record.setCheckTime(checkTime);
            String re = "待定";
            if(result.getString(8) != null){
                re = result.getString(8);
            }
            record.setResult(re);
            String staffName = "待定";
            if(result.getString(9) != null){
                staffName = result.getString(9);
            }
            record.setStaffName(staffName);
            String staffId = "待定";
            if(result.getString(10) != null){
                staffId = result.getString(10);
            }
            record.setStaffId(staffId);
            record.setScore(result.getInt(11));
            record.setProcess(result.getString(12).trim());
            record.setAvailable(result.getInt(13));
            recordList.add(record);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!recordList.isEmpty()) {
            return recordList;
        } else {
            return null;
        }
    }
}
