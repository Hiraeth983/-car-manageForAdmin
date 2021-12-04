package dao;

import model.Record;

import java.util.ArrayList;

public interface RecordDao {

    /**
     * 查询所有检测数据
     * @return 检测数据数组
     * @throws Exception
     */
    ArrayList<Record> getAllRecord() throws Exception;

    /**
     * 查询某一检测数据
     * @param order
     * @return 指定编号检测数据
     * @throws Exception
     */
    Record getRecordById(String order) throws Exception;


}
