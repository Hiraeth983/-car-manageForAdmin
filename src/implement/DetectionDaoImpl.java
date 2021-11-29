package implement;

import dao.BaseDao;
import dao.DetectionDao;
import model.DateStatusInfo;
import model.DetectionLineException;
import model.DetectionResult;
import model.ExceptionResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DetectionDaoImpl extends BaseDao implements DetectionDao {
    /* 获取过去 past 天时间 */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /* 当日检测总数 */
    @Override
    public int allDetectionCount(String detection_id) throws Exception {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM test_result where Detection_date=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sdf.format(date));//sdf.format(date)
        pstmt.setString(2, detection_id);
        ResultSet result = pstmt.executeQuery();
        int count = -1;
        while (result.next()) {
            count = result.getInt(1);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return count < 0 ? 0 : count;

    }

    /* 当日检测正常数 */
    @Override
    public int normalDetectionCount(String detection_id) throws Exception {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM test_result where Detection_date=? and Detection_result=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sdf.format(date));
        pstmt.setString(2, "正常");
        pstmt.setString(3, detection_id);
        ResultSet result = pstmt.executeQuery();
        int count = -1;
        while (result.next()) {
            count = result.getInt(1);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return count < 0 ? 0 : count;
    }

    /* 当日检测异常数 */
    @Override
    public int abnormalDetectionCount(String detection_id) throws Exception {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM test_result where Detection_date=? and Detection_result=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sdf.format(date));
        pstmt.setString(2, "异常");
        pstmt.setString(3, detection_id);
        ResultSet result = pstmt.executeQuery();
        int count = -1;
        while (result.next()) {
            count = result.getInt(1);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return count < 0 ? 0 : count;
    }

    /* 当日检测线对应异常数 */
    @Override
    public ArrayList<DetectionLineException> detectionLineCount(String detection_id) throws Exception {
        ArrayList<DetectionLineException> dleList = new ArrayList<>();
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT test_line,count(*) FROM test_result where Detection_date=? and Detection_id=? group by test_line;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sdf.format(date));
        pstmt.setString(2, detection_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionLineException dle = new DetectionLineException();

            dle.setLine(result.getString(1));
            dle.setExceptionCount(result.getInt(2));
            dleList.add(dle);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!dleList.isEmpty()) {
            return dleList;
        } else {
            return null;
        }
    }

    /* 历史检测总数 */
    @Override
    public int historyAllDetectionCount(String detection_id) throws Exception {

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM test_result where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        ResultSet result = pstmt.executeQuery();
        int count = -1;
        while (result.next()) {
            count = result.getInt(1);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return count < 0 ? 0 : count;

    }

    /* 历史检测正常数 */
    @Override
    public int historyNormalDetectionCount(String detection_id) throws Exception {

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM test_result where Detection_result=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "正常");
        pstmt.setString(2, detection_id);
        ResultSet result = pstmt.executeQuery();
        int count = -1;
        while (result.next()) {
            count = result.getInt(1);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return count < 0 ? 0 : count;
    }

    /* 历史检测异常数 */
    @Override
    public int historyAbnormalDetectionCount(String detection_id) throws Exception {

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM test_result where Detection_result=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "异常");
        pstmt.setString(2, detection_id);
        ResultSet result = pstmt.executeQuery();
        int count = -1;
        while (result.next()) {
            count = result.getInt(1);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return count < 0 ? 0 : count;
    }

    /* 历史检测线对应异常数 */
    @Override
    public ArrayList<DetectionLineException> historyDetectionLineCount(String detection_id) throws Exception {
        ArrayList<DetectionLineException> dleList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT test_line,count(*) FROM test_result where Detection_id=? group by test_line;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionLineException dle = new DetectionLineException();

            dle.setLine(result.getString(1));
            dle.setExceptionCount(result.getInt(2));
            dleList.add(dle);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!dleList.isEmpty()) {
            return dleList;
        } else {
            return null;
        }
    }

//    /* 当日检测结果 */
//    @Override
//    public ArrayList<DetectionResult> dailyDetectionInfo(String detection_id) throws Exception {
//        ArrayList<DetectionResult> drList = new ArrayList<>();
//        // 获取当前时间
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
//        Date date = new Date();// 获取当前时间
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
//                "FROM car_info,test_result where Detection_id = ? and Detection_date=? and test_result.id=car_info.id;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        pstmt.setString(2, sdf.format(date));
//
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            DetectionResult dr = new DetectionResult();
//
//            dr.setId(result.getString(1));
//            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
//            dr.setDetection_id(result.getString(3));
//            dr.setTest_line(result.getString(4));
//            dr.setEngine(result.getString(5));
//            dr.setExhaust_funnel_num(result.getInt(6));
//            dr.setExhaust_funnel_info(result.getInt(7));
//            dr.setExhaust_funnel_judge(result.getInt(8));
//            dr.setCar_id(result.getString(9));
//            dr.setSignal_tube(result.getInt(10));
//            dr.setDoor_info(result.getInt(11));
//            dr.setCar_color(result.getString(12));
//            dr.setCar_model(result.getString(13));
//            dr.setStaff_id(result.getString(14));
//            dr.setDetection_result(result.getString(15));
//            drList.add(dr);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return drList;
//    }
//
//    @Override
//    public ArrayList<DetectionResult> dailyDetectionInfo(String detection_id, String id) throws Exception {
//        ArrayList<DetectionResult> drList = new ArrayList<>();
//        // 获取当前时间
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
//        Date date = new Date();// 获取当前时间
//
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
//                "FROM car_info,test_result where Detection_id=? and Detection_date=? and test_result.id=? and test_result.id=car_info.id;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        pstmt.setString(2, sdf.format(date));
//        pstmt.setString(3, id);
//
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            DetectionResult dr = new DetectionResult();
//
//            dr.setId(result.getString(1));
//            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
//            dr.setDetection_id(result.getString(3));
//            dr.setTest_line(result.getString(4));
//            dr.setEngine(result.getString(5));
//            dr.setExhaust_funnel_num(result.getInt(6));
//            dr.setExhaust_funnel_info(result.getInt(7));
//            dr.setExhaust_funnel_judge(result.getInt(8));
//            dr.setCar_id(result.getString(9));
//            dr.setSignal_tube(result.getInt(10));
//            dr.setDoor_info(result.getInt(11));
//            dr.setCar_color(result.getString(12));
//            dr.setCar_model(result.getString(13));
//            dr.setStaff_id(result.getString(14));
//            dr.setDetection_result(result.getString(15));
//            drList.add(dr);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return drList;
//    }
//
//    /* 历史检测结果 */
//    @Override
//    public ArrayList<DetectionResult> historyDetectionInfo(String detection_id) throws Exception {
//        ArrayList<DetectionResult> drList = new ArrayList<>();
//
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
//                "FROM car_info,test_result where Detection_id=? and test_result.id=car_info.id;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            DetectionResult dr = new DetectionResult();
//
//            dr.setId(result.getString(1));
//            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
//            dr.setDetection_id(result.getString(3));
//            dr.setTest_line(result.getString(4));
//            dr.setEngine(result.getString(5));
//            dr.setExhaust_funnel_num(result.getInt(6));
//            dr.setExhaust_funnel_info(result.getInt(7));
//            dr.setExhaust_funnel_judge(result.getInt(8));
//            dr.setCar_id(result.getString(9));
//            dr.setSignal_tube(result.getInt(10));
//            dr.setDoor_info(result.getInt(11));
//            dr.setCar_color(result.getString(12));
//            dr.setCar_model(result.getString(13));
//            dr.setStaff_id(result.getString(14));
//            dr.setDetection_result(result.getString(15));
//            drList.add(dr);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return drList;
//    }
//
//    @Override
//    public ArrayList<DetectionResult> historyDetectionInfo(String detection_id, String id) throws Exception {
//        ArrayList<DetectionResult> drList = new ArrayList<>();
//
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
//                "FROM car_info,test_result where Detection_id=? and test_result.id=? and test_result.id=car_info.id;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        pstmt.setString(2, id);
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            DetectionResult dr = new DetectionResult();
//
//            dr.setId(result.getString(1));
//            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
//            dr.setDetection_id(result.getString(3));
//            dr.setTest_line(result.getString(4));
//            dr.setEngine(result.getString(5));
//            dr.setExhaust_funnel_num(result.getInt(6));
//            dr.setExhaust_funnel_info(result.getInt(7));
//            dr.setExhaust_funnel_judge(result.getInt(8));
//            dr.setCar_id(result.getString(9));
//            dr.setSignal_tube(result.getInt(10));
//            dr.setDoor_info(result.getInt(11));
//            dr.setCar_color(result.getString(12));
//            dr.setCar_model(result.getString(13));
//            dr.setStaff_id(result.getString(14));
//            dr.setDetection_result(result.getString(15));
//            drList.add(dr);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return drList;
//    }
//
//    /* 当日异常结果 */
//    @Override
//    public ArrayList<ExceptionResult> dailyExceptionInfo(String detection_id) throws Exception {
//        ArrayList<ExceptionResult> erList = new ArrayList<>();
//        // 获取当前时间
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
//        Date date = new Date();// 获取当前时间
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
//                "FROM error_info,test_result where Detection_id=? and Detection_date=? and test_result.id=error_info.id order by solve_progress ;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        pstmt.setString(2, sdf.format(date));
////        pstmt.setString(2, "2021-2-11");
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            ExceptionResult er = new ExceptionResult();
//
//            er.setId(result.getString(1));
//            er.setCar_id(result.getString(2));
//            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
//            er.setDetection_id(result.getString(4));
//            er.setTest_line(result.getString(5));
//            er.setError_type(result.getString(6));
//            er.setError_picture(result.getString(7));
//            er.setStaff_id(result.getString(8));
//            er.setSolve_progress(result.getInt(9));
//            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
//            er.setError_describe(result.getString(11));
//            erList.add(er);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return erList;
//    }
//
//    @Override
//    public ArrayList<ExceptionResult> dailyExceptionInfo(String detection_id, String id) throws Exception {
//        ArrayList<ExceptionResult> erList = new ArrayList<>();
//        // 获取当前时间
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
//        Date date = new Date();// 获取当前时间
//
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
//                "FROM error_info,test_result where Detection_id=? and Detection_date=? and test_result.id=? and test_result.id=error_info.id order by solve_progress;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        pstmt.setString(2, sdf.format(date));
////        pstmt.setString(2, "2021-2-11");
//        pstmt.setString(3, id);
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            ExceptionResult er = new ExceptionResult();
//
//            er.setId(result.getString(1));
//            er.setCar_id(result.getString(2));
//            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
//            er.setDetection_id(result.getString(4));
//            er.setTest_line(result.getString(5));
//            er.setError_type(result.getString(6));
//            er.setError_picture(result.getString(7));
//            er.setStaff_id(result.getString(8));
//            er.setSolve_progress(result.getInt(9));
//            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
//            er.setError_describe(result.getString(11));
//            erList.add(er);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return erList;
//    }
//
//    /* 历史异常结果 */
//    @Override
//    public ArrayList<ExceptionResult> historyExceptionInfo(String detection_id, String id) throws Exception {
//        ArrayList<ExceptionResult> erList = new ArrayList<>();
//
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
//                "FROM error_info,test_result where Detection_id=? and test_result.id=? and test_result.id=error_info.id order by solve_progress;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        pstmt.setString(2, id);
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            ExceptionResult er = new ExceptionResult();
//
//            er.setId(result.getString(1));
//            er.setCar_id(result.getString(2));
//            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
//            er.setDetection_id(result.getString(4));
//            er.setTest_line(result.getString(5));
//            er.setError_type(result.getString(6));
//            er.setError_picture(result.getString(7));
//            er.setStaff_id(result.getString(8));
//            er.setSolve_progress(result.getInt(9));
//            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
//            er.setError_describe(result.getString(11));
//            erList.add(er);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return erList;
//    }
//
//    @Override
//    public ArrayList<ExceptionResult> historyExceptionInfo(String detection_id) throws Exception {
//        ArrayList<ExceptionResult> erList = new ArrayList<>();
//
//        Connection conn = BaseDao.getConnection();
//        String sql = "SELECT\n" +
//                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
//                "FROM error_info,test_result where Detection_id=? and test_result.id=error_info.id order by solve_progress ;";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, detection_id);
//        ResultSet result = pstmt.executeQuery();
//        while (result.next()) {
//            ExceptionResult er = new ExceptionResult();
//
//            er.setId(result.getString(1));
//            er.setCar_id(result.getString(2));
//            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
//            er.setDetection_id(result.getString(4));
//            er.setTest_line(result.getString(5));
//            er.setError_type(result.getString(6));
//            er.setError_picture(result.getString(7));
//            er.setStaff_id(result.getString(8));
//            er.setSolve_progress(result.getInt(9));
//            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
//            er.setError_describe(result.getString(11));
//            erList.add(er);
//        }
//        BaseDao.closeAll(conn, pstmt, result);
//        return erList;
//    }
@Override
public ArrayList<DetectionResult> dailyDetectionInfo(String detection_id) throws Exception {
    ArrayList<DetectionResult> drList = new ArrayList<>();
    // 获取当前时间
    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
    sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
    Date date = new Date();// 获取当前时间
    Connection conn = BaseDao.getConnection();
    String sql = "SELECT\n" +
            "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
            "FROM car_info,test_result where Detection_id=? and Detection_date=? and test_result.id=car_info.id;";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, detection_id);
    pstmt.setString(2, sdf.format(date));

    ResultSet result = pstmt.executeQuery();
    while (result.next()) {
        DetectionResult dr = new DetectionResult();

        dr.setId(result.getString(1));
        dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
        dr.setDetection_id(result.getString(3));
        dr.setTest_line(result.getString(4));
        dr.setEngine(result.getString(5));
        dr.setExhaust_funnel_num(result.getInt(6));
        dr.setExhaust_funnel_info(result.getInt(7));
        dr.setExhaust_funnel_judge(result.getInt(8));
        dr.setCar_id(result.getString(9));
        dr.setSignal_tube(result.getInt(10));
        dr.setDoor_info(result.getInt(11));
        dr.setCar_color(result.getString(12));
        dr.setCar_model(result.getString(13));
        dr.setStaff_id(result.getString(14));
        dr.setDetection_result(result.getString(15));
        drList.add(dr);
    }
    BaseDao.closeAll(conn, pstmt, result);
    return drList;
}

    @Override
    public ArrayList<DetectionResult> dailyDetectionInfo(String detection_id, String id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where Detection_id=? and Detection_date=? and test_result.id like ? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, sdf.format(date));
        pstmt.setString(3, id+"%");

        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }

    @Override
    public ArrayList<DetectionResult> dailyDetectionInfoByPlate(String detection_id, String id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();
        System.out.println(123123);
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where Detection_id=? and Detection_date=? and test_result.car_id like ? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, sdf.format(date));
        pstmt.setString(3, id+"%");

        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }
    /* 历史检测结果 */
    @Override
    public ArrayList<DetectionResult> historyDetectionInfo(String detection_id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where Detection_id=? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);

        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }

    @Override
    public ArrayList<DetectionResult> historyDetectionInfo(String detection_id, String id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where Detection_id=? and test_result.id like ? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, id+"%");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }
    @Override
    public ArrayList<DetectionResult> historyDetectionInfoByPlate(String detection_id, String id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where Detection_id=? and test_result.car_id like ? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, id+"%");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }
    @Override
    public ArrayList<DetectionResult> historyDetectionInfoByTime(String detection_id, java.sql.Date time) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where Detection_id=? and test_result.Detection_date=? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setDate(2, time);

        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            String newtime = String.valueOf(result.getDate(2).getTime());
            System.out.println(newtime);
            System.out.println(time);
            System.out.println(time.equals(newtime));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }
    /* 当日异常结果 */
    @Override
    public ArrayList<ExceptionResult> dailyExceptionInfo(String detection_id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and Detection_date=? and test_result.id=error_info.id order by solve_progress ;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, sdf.format(date));
//        pstmt.setString(2, "2021-2-11");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }

    @Override
    public ArrayList<ExceptionResult> dailyExceptionInfo(String detection_id, String id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and Detection_date=? and test_result.id like ? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, sdf.format(date));
//        pstmt.setString(2, "2021-2-11");
        pstmt.setString(3, id+"%");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }
    @Override
    public ArrayList<ExceptionResult> dailyExceptionInfoByPlate(String detection_id, String id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and Detection_date=? and car_id like ? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, sdf.format(date));
//        pstmt.setString(2, "2021-01-01");
        pstmt.setString(3, id+"%");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }
    /* 历史异常结果 */
    @Override
    public ArrayList<ExceptionResult> historyExceptionInfo(String detection_id, String id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and test_result.id like ? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, id+"%");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }

    @Override
    public ArrayList<ExceptionResult> historyExceptionInfo(String detection_id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and test_result.id=error_info.id order by solve_progress ;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }
    @Override
    public ArrayList<ExceptionResult> historyExceptionInfoByPlate(String detection_id, String id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and test_result.car_id like ? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, id+"%");
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }

    @Override
    public ArrayList<ExceptionResult> historyExceptionInfoByTime(String detection_id, java.sql.Date time) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where Detection_id=? and test_result.Detection_date=? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setDate(2, time);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }
    /* 获取近一周时间及其事务状态列表（正常、未处理、处理中、已处理） */
    @Override
    public ArrayList<DateStatusInfo> processStatusInfo(String detection_id) throws Exception {
        ArrayList<DateStatusInfo> dsiList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        for (int i = 6; i >= 0; i--) {
            int normal = 0;
            int untreated = 0;
            int processing = 0;
            int processed = 0;
            String time = getPastDate(i);

            /* 统计处理进度 */
            sql = "SELECT * FROM error_info,test_result where Detection_id=? and Detection_date=? and test_result.id=error_info.id;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, detection_id);
            pstmt.setString(2, time);
            result = pstmt.executeQuery();

            while (result.next()) {
                if (result.getInt("solve_progress") == 0) {
                    untreated++;
                } else if (result.getInt("solve_progress") == 1) {
                    processing++;
                } else if (result.getInt("solve_progress") == 2) {
                    processed++;
                }
            }

            /* 统计正常车辆 */
            sql = "SELECT count(*) FROM test_result where Detection_date=? and Detection_result=? and Detection_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, time);
            pstmt.setString(2, "正常");
            pstmt.setString(3, detection_id);
            result = pstmt.executeQuery();
            while (result.next()) {
                normal = result.getInt(1);
            }

            DateStatusInfo dsi = new DateStatusInfo(time, normal, untreated, processing, processed);
            dsiList.add(dsi);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!dsiList.isEmpty()) {
            return dsiList;
        } else {
            return null;
        }
    }

    /* 查询当前车辆历史异常结果 */
    @Override
    public ArrayList<ExceptionResult> historyExceptionCarIdInfo(String car_id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where car_id=? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, car_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }

    @Override
    public ArrayList<ExceptionResult> historyExceptionCarIdInfo(String car_id, String id) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result where car_id=? and test_result.id=? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, car_id);
        pstmt.setString(2, id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }

    /* 查询当前车辆历史正常结果 */
    @Override
    public ArrayList<DetectionResult> historyNormalCarIdInfo(String car_id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where car_id=? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, car_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }

    @Override
    public ArrayList<DetectionResult> historyNormalCarIdInfo(String car_id, String id) throws Exception {
        ArrayList<DetectionResult> drList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,Detection_date,Detection_id,test_line,`engine`,Exhaust_funnel_num,Exhaust_funnel_info,Exhaust_funnel_judge,car_id,signal_tube,door_info,car_color,car_model,staff_id,Detection_result\n" +
                "FROM car_info,test_result where car_id=? and test_result.id=? and test_result.id=car_info.id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, car_id);
        pstmt.setString(2, id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            DetectionResult dr = new DetectionResult();

            dr.setId(result.getString(1));
            dr.setDetection_date(new java.util.Date(result.getDate(2).getTime()));
            dr.setDetection_id(result.getString(3));
            dr.setTest_line(result.getString(4));
            dr.setEngine(result.getString(5));
            dr.setExhaust_funnel_num(result.getInt(6));
            dr.setExhaust_funnel_info(result.getInt(7));
            dr.setExhaust_funnel_judge(result.getInt(8));
            dr.setCar_id(result.getString(9));
            dr.setSignal_tube(result.getInt(10));
            dr.setDoor_info(result.getInt(11));
            dr.setCar_color(result.getString(12));
            dr.setCar_model(result.getString(13));
            dr.setStaff_id(result.getString(14));
            dr.setDetection_result(result.getString(15));
            drList.add(dr);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return drList;
    }

    /* 条件筛选 */
    @Override
    public ArrayList<ExceptionResult> infoSelected(String detection_id, String test_line, String error_type, String staff, String solve_progress, String beginTime, String endTime, String solveTime) throws Exception {
        ArrayList<ExceptionResult> erList = new ArrayList<>();

        Connection conn = BaseDao.getConnection();
        String sql = "SELECT\n" +
                "test_result.id,car_id,Detection_date,Detection_id,test_line,error_type,error_picture,staff_id,solve_progress,solve_time,error_describe\n" +
                "FROM error_info,test_result \n" +
                "where Detection_id=? and test_line like ? and error_type like ? and staff_id like ? and solve_progress like ? and Detection_date between ? and ? and solve_time like ? and test_result.id=error_info.id order by solve_progress;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        pstmt.setString(2, test_line);
        pstmt.setString(3, error_type);
        pstmt.setString(4, staff);
        pstmt.setString(5, solve_progress);
        pstmt.setString(6, beginTime);
        pstmt.setString(7, endTime);
        pstmt.setString(8, solveTime);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ExceptionResult er = new ExceptionResult();

            er.setId(result.getString(1));
            er.setCar_id(result.getString(2));
            er.setDetection_date(new java.util.Date(result.getDate(3).getTime()));
            er.setDetection_id(result.getString(4));
            er.setTest_line(result.getString(5));
            er.setError_type(result.getString(6));
            er.setError_picture(result.getString(7));
            er.setStaff_id(result.getString(8));
            er.setSolve_progress(result.getInt(9));
            er.setSolve_time(new java.util.Date(result.getDate(10).getTime()));
            er.setError_describe(result.getString(11));
            erList.add(er);
        }
        BaseDao.closeAll(conn, pstmt, result);
        return erList;
    }


}
