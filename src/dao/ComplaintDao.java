package dao;

import model.Application;
import model.Complaint;

import java.util.ArrayList;

public interface ComplaintDao {
    /**
     * 返回投诉指定站点员工数据
     * @param stationId
     * @return 投诉指定站点员工数据列表
     * @throws Exception
     */
    ArrayList<Complaint> getComplaintListByStationId(String stationId) throws Exception;

    /**
     * 修改人工审批意见
     * @param complaint
     * @return 修改是否成功
     * @throws Exception
     */
    Boolean examineComplaint(Complaint complaint) throws Exception;
}
