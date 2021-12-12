package dao;

import model.Application;

import java.util.ArrayList;

public interface ApplicationDao {

    /**
     * 获取某一站点申请调度信息列表
     * @param stationId
     * @return 返回申请调度信息列表
     * @throws Exception
     */
    ArrayList<Application> getApplicationListByStationId(String stationId) throws Exception;

    /**
     * 审核申请（修改处理状态）
     * @param app
     * @return 修改是否成功
     * @throws Exception
     */
    Boolean examineApplication(Application app) throws Exception;
}
