package com.ruoyi.lms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书对象 lms_books
 * 
 * @author ruoyi
 * @date 2022-10-28
 */
public class LmsBooks extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 书名 */
    @Excel(name = "书名")
    private String bName;

    /** 作者 */
    @Excel(name = "作者")
    private String bAuthor;

    /** 出版社 */
    @Excel(name = "出版社")
    private String bPublisher;

    /** 版本 */
    @Excel(name = "版本")
    private String bVersion;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setbName(String bName) 
    {
        this.bName = bName;
    }

    public String getbName() 
    {
        return bName;
    }
    public void setbAuthor(String bAuthor) 
    {
        this.bAuthor = bAuthor;
    }

    public String getbAuthor() 
    {
        return bAuthor;
    }
    public void setbPublisher(String bPublisher) 
    {
        this.bPublisher = bPublisher;
    }

    public String getbPublisher() 
    {
        return bPublisher;
    }
    public void setbVersion(String bVersion) 
    {
        this.bVersion = bVersion;
    }

    public String getbVersion() 
    {
        return bVersion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bName", getbName())
            .append("bAuthor", getbAuthor())
            .append("bPublisher", getbPublisher())
            .append("bVersion", getbVersion())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
