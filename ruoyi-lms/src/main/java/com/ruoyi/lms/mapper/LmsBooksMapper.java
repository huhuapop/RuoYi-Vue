package com.ruoyi.lms.mapper;

import java.util.List;
import com.ruoyi.lms.domain.LmsBooks;

/**
 * 书Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-28
 */
public interface LmsBooksMapper 
{
    /**
     * 查询书
     * 
     * @param id 书主键
     * @return 书
     */
    public LmsBooks selectLmsBooksById(Long id);

    /**
     * 查询书列表
     * 
     * @param lmsBooks 书
     * @return 书集合
     */
    public List<LmsBooks> selectLmsBooksList(LmsBooks lmsBooks);

    /**
     * 新增书
     * 
     * @param lmsBooks 书
     * @return 结果
     */
    public int insertLmsBooks(LmsBooks lmsBooks);

    /**
     * 修改书
     * 
     * @param lmsBooks 书
     * @return 结果
     */
    public int updateLmsBooks(LmsBooks lmsBooks);

    /**
     * 删除书
     * 
     * @param id 书主键
     * @return 结果
     */
    public int deleteLmsBooksById(Long id);

    /**
     * 批量删除书
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLmsBooksByIds(Long[] ids);
}
