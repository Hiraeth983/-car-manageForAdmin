package implement;

import dao.BaseDao;
import dao.ChartDao;
import model.CarChart;
import model.ErrorTypeChart;
import model.StaffChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChartDaoImpl implements ChartDao {
    /* 获取过去 past 天时间 */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    @Override
    public ArrayList<ErrorTypeChart> loadErrorTypeList(String date, int num) throws Exception {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date nowDate = new Date();// 获取当前时间
        String beginDate = null;
        if (date.equals("year")) {
            beginDate = getPastDate(365);
        } else if (date.equals("month")) {
            beginDate = getPastDate(30);
        } else if (date.equals("week")) {
            beginDate = getPastDate(7);
        }

        ArrayList<ErrorTypeChart> errorTypeChartList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "select error_type,count(test_result.id) num from error_info,test_result where test_result.id = error_info.id and Detection_date between ? and ? group by error_type order by num desc limit ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, beginDate);
        pstmt.setString(2, sdf.format(nowDate));
        pstmt.setInt(3, num);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            ErrorTypeChart etc = new ErrorTypeChart();
            etc.setError_type(result.getString(1));
            etc.setCount(result.getInt(2));

            errorTypeChartList.add(etc);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!errorTypeChartList.isEmpty()) {
            return errorTypeChartList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<CarChart> loadCarList(String date, int num) throws Exception {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date nowDate = new Date();// 获取当前时间
        String beginDate = null;
        if (date.equals("year")) {
            beginDate = getPastDate(365);
        } else if (date.equals("month")) {
            beginDate = getPastDate(30);
        } else if (date.equals("week")) {
            beginDate = getPastDate(7);
        }

        ArrayList<CarChart> carChartList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        //String sql = "select car_id,count(test_result.id) num from test_result,error_info where test_result.id = error_info.id and Detection_date between ? and ? group by car_id order by num desc limit ?;";
        String sql = "select car_id,count(test_result.id) num from test_result,error_info where test_result.id = error_info.id group by car_id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // pstmt.setString(1, beginDate);
        // pstmt.setString(2, sdf.format(nowDate));
        // pstmt.setInt(3, num);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            CarChart etc = new CarChart();
            etc.setCar_id(result.getString(1));
            etc.setError_count(result.getInt(2));

            carChartList.add(etc);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!carChartList.isEmpty()) {
            return carChartList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<StaffChart> loadStaffList(String date, int num) throws Exception {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date nowDate = new Date();// 获取当前时间
        String beginDate = null;
        if (date.equals("year")) {
            beginDate = getPastDate(365);
        } else if (date.equals("month")) {
            beginDate = getPastDate(30);
        } else if (date.equals("week")) {
            beginDate = getPastDate(7);
        }

        ArrayList<StaffChart> staffChartList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "select staff_id,count(test_result.id) num from error_info,test_result where test_result.id = error_info.id and Detection_date between ? and ? group by staff_id ORDER BY num desc limit ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, beginDate);
        pstmt.setString(2, sdf.format(nowDate));
        pstmt.setInt(3, num);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            StaffChart sc = new StaffChart();
            sc.setStaff_name(result.getString(1));
            sc.setNumber(result.getInt(2));

            staffChartList.add(sc);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!staffChartList.isEmpty()) {
            return staffChartList;
        } else {
            return null;
        }
    }
}
