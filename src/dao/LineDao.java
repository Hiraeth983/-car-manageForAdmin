package dao;

import model.Line;

import java.util.ArrayList;

public interface LineDao {
    /* 查询当前检测站所有检测线 */
    ArrayList<String> allLineInfo(String detection_id) throws Exception;

    /* 查询所有检测线 */
    ArrayList<Line> queryLine(String detection_id) throws Exception;

    /* 查询某一检测线 */
    ArrayList<Line> queryLine(String detection_id, String test_line) throws Exception;

    /* 插入数据 */
    boolean insertLine(Line line) throws Exception;

    /* 删除某一条数据 */
    boolean deleteLine(String detection_id, String test_line) throws Exception;

    /* 更新某一条数据 */
    boolean updateLine(Line line) throws Exception;
}
