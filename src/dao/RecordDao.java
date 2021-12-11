package dao;

import model.Record;

import java.util.ArrayList;

public interface RecordDao {

    /**
     * 查询所有检测数据
     *
     * @return 检测数据数组
     * @throws Exception
     */
    ArrayList<Record> getRecordList() throws Exception;

    /**
     * 查询某一检测数据
     *
     * @param order
     * @return 指定编号检测数据
     * @throws Exception
     */
    Record getRecordById(String order) throws Exception;

    /**
     * 根据 orderId 分配任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    Boolean assignTaskByOrderId(Record record) throws Exception;

    /**
     * 查询某一车牌号检测数据
     *
     * @param carId
     * @return 返回某一车牌号检测数据列表
     * @throws Exception
     */
    ArrayList<Record> getRecordByCarId(String carId) throws Exception;
}
