package dao;

import model.DateStatusInfo;
import model.DetectionLineException;
import model.DetectionResult;
import model.ExceptionResult;

import java.util.ArrayList;

public interface DetectionDao {

    /* 当日检测总数 */
    int allDetectionCount(String detection_id) throws Exception;

    /* 当日检测正常数 */
    int normalDetectionCount(String detection_id) throws Exception;

    /* 当日检测异常数 */
    int abnormalDetectionCount(String detection_id) throws Exception;

    /* 当日检测线对应异常数 */
    ArrayList<DetectionLineException> detectionLineCount(String detection_id) throws Exception;

    /* 历史检测总数 */
    int historyAllDetectionCount(String detection_id) throws Exception;

    /* 历史检测正常数 */
    int historyNormalDetectionCount(String detection_id) throws Exception;

    /* 历史检测异常数 */
    int historyAbnormalDetectionCount(String detection_id) throws Exception;

    /* 历史检测线对应异常数 */
    ArrayList<DetectionLineException> historyDetectionLineCount(String detection_id) throws Exception;

    /* 当日检测结果 */
    ArrayList<DetectionResult> dailyDetectionInfo(String detection_id) throws Exception;

    ArrayList<DetectionResult> dailyDetectionInfo(String detection_id, String id) throws Exception;

    ArrayList<DetectionResult> dailyDetectionInfoByPlate(String detection_id, String id) throws Exception;


    /* 历史检测结果 */
    ArrayList<DetectionResult> historyDetectionInfo(String detection_id) throws Exception;

    ArrayList<DetectionResult> historyDetectionInfo(String detection_id, String id) throws Exception;

    ArrayList<DetectionResult> historyDetectionInfoByPlate(String detection_id, String id) throws Exception;

    ArrayList<DetectionResult> historyDetectionInfoByTime(String detection_id, java.sql.Date time) throws Exception;


    /* 当日异常结果 */
    ArrayList<ExceptionResult> dailyExceptionInfo(String detection_id) throws Exception;

    ArrayList<ExceptionResult> dailyExceptionInfo(String detection_id, String id) throws Exception;

    ArrayList<ExceptionResult> dailyExceptionInfoByPlate(String detection_id, String id) throws Exception;


    /* 历史异常结果 */
    ArrayList<ExceptionResult> historyExceptionInfo(String detection_id) throws Exception;

    ArrayList<ExceptionResult> historyExceptionInfo(String detection_id, String id) throws Exception;

    ArrayList<ExceptionResult> historyExceptionInfoByPlate(String detection_id, String id) throws Exception;

    ArrayList<ExceptionResult> historyExceptionInfoByTime(String detection_id, java.sql.Date time) throws Exception;


    /* 获取近一周时间及其事务状态列表（正常、未处理、处理中、已处理） */
    ArrayList<DateStatusInfo> processStatusInfo(String detection_id) throws Exception;


    /* 查询当前车辆历史异常结果 */
    ArrayList<ExceptionResult> historyExceptionCarIdInfo(String car_id) throws Exception;

    ArrayList<ExceptionResult> historyExceptionCarIdInfo(String car_id, String id) throws Exception;

    /* 查询当前车辆历史正常结果 */
    ArrayList<DetectionResult> historyNormalCarIdInfo(String car_id) throws Exception;

    ArrayList<DetectionResult> historyNormalCarIdInfo(String car_id, String id) throws Exception;

    /* 条件筛选 */
    ArrayList<ExceptionResult> infoSelected(String detection_id, String test_line, String error_type, String staff, String solve_progress, String beginTime, String endTime, String solveTime) throws Exception;

}
