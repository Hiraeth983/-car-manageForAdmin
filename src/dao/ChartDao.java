package dao;

import model.CarChart;
import model.ErrorTypeChart;
import model.StaffChart;

import java.util.ArrayList;

public interface ChartDao {

    /* 获取异常类型及数量根据时间（年月日） */
    ArrayList<ErrorTypeChart> loadErrorTypeList(String date, int num) throws Exception;

    /* 获取异常类型及数量根据时间（年月日） */
    ArrayList<CarChart> loadCarList(String date, int num) throws Exception;

    /* 获取异常类型及数量根据时间（年月日） */
    ArrayList<StaffChart> loadStaffList(String date, int num) throws Exception;

}
