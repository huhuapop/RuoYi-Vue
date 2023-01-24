package com.ruoyi.lms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lms.mapper.LmsBooksMapper;
import com.ruoyi.lms.domain.LmsBooks;
import com.ruoyi.lms.service.ILmsBooksService;

/**
 * 书Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-28
 */
@Service
public class LmsBooksServiceImpl implements ILmsBooksService 
{
    @Autowired
    private LmsBooksMapper lmsBooksMapper;

    /**
     * 查询书
     * 
     * @param id 书主键
     * @return 书
     */
    @Override
    public LmsBooks selectLmsBooksById(Long id)
    {
        return lmsBooksMapper.selectLmsBooksById(id);
    }

    /**
     * 查询书列表
     * 
     * @param lmsBooks 书
     * @return 书
     */
    @Override
    public List<LmsBooks> selectLmsBooksList(LmsBooks lmsBooks)
    {
        return lmsBooksMapper.selectLmsBooksList(lmsBooks);
    }

    /**
     * 新增书
     * 
     * @param lmsBooks 书
     * @return 结果
     */
    @Override
    public int insertLmsBooks(LmsBooks lmsBooks)
    {
        lmsBooks.setCreateTime(DateUtils.getNowDate());
        return lmsBooksMapper.insertLmsBooks(lmsBooks);
    }

    /**
     * 修改书
     * 
     * @param lmsBooks 书
     * @return 结果
     */
    @Override
    public int updateLmsBooks(LmsBooks lmsBooks)
    {
        lmsBooks.setUpdateTime(DateUtils.getNowDate());
        return lmsBooksMapper.updateLmsBooks(lmsBooks);
    }

    /**
     * 批量删除书
     * 
     * @param ids 需要删除的书主键
     * @return 结果
     */
    @Override
    public int deleteLmsBooksByIds(Long[] ids)
    {
        return lmsBooksMapper.deleteLmsBooksByIds(ids);
    }

    /**
     * 删除书信息
     * 
     * @param id 书主键
     * @return 结果
     */
    @Override
    public int deleteLmsBooksById(Long id)
    {
        return lmsBooksMapper.deleteLmsBooksById(id);
    }
}
