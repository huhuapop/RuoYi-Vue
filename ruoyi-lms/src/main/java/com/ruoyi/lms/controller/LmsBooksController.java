package com.ruoyi.lms.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lms.domain.LmsBooks;
import com.ruoyi.lms.service.ILmsBooksService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书Controller
 * 
 * @author ruoyi
 * @date 2022-10-28
 */
@RestController
@RequestMapping("/ruoyi-lms/books")
public class LmsBooksController extends BaseController
{
    @Autowired
    private ILmsBooksService lmsBooksService;

    /**
     * 查询书列表
     */
//    @PreAuthorize("@ss.hasPermi('ruoyi-lms:books:list')")
    @GetMapping("/list")
    public TableDataInfo list(LmsBooks lmsBooks)
    {
        startPage();
        List<LmsBooks> list = lmsBooksService.selectLmsBooksList(lmsBooks);
        return getDataTable(list);
    }

    /**
     * 导出书列表
     */
//    @PreAuthorize("@ss.hasPermi('ruoyi-lms:books:export')")
    @Log(title = "书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LmsBooks lmsBooks)
    {
        List<LmsBooks> list = lmsBooksService.selectLmsBooksList(lmsBooks);
        ExcelUtil<LmsBooks> util = new ExcelUtil<LmsBooks>(LmsBooks.class);
        util.exportExcel(response, list, "书数据");
    }

    /**
     * 获取书详细信息
     */
//    @PreAuthorize("@ss.hasPermi('ruoyi-lms:books:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lmsBooksService.selectLmsBooksById(id));
    }

    /**
     * 新增书
     */
//    @PreAuthorize("@ss.hasPermi('ruoyi-lms:books:add')")
    @Log(title = "书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LmsBooks lmsBooks)
    {
        lmsBooks.setCreateBy(getUsername());
        lmsBooks.setUpdateBy(getUsername());
        Date date = new Date();
        lmsBooks.setUpdateTime(date);
        return toAjax(lmsBooksService.insertLmsBooks(lmsBooks));
    }

    /**
     * 修改书
     */
//    @PreAuthorize("@ss.hasPermi('ruoyi-lms:books:edit')")
    @Log(title = "书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LmsBooks lmsBooks)
    {
        lmsBooks.setCreateBy(getUsername());
        lmsBooks.setUpdateBy(getUsername());
        Date date = new Date();
        lmsBooks.setUpdateTime(date);
        return toAjax(lmsBooksService.updateLmsBooks(lmsBooks));
    }

    /**
     * 删除书
     */
//    @PreAuthorize("@ss.hasPermi('ruoyi-lms:books:remove')")
    @Log(title = "书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lmsBooksService.deleteLmsBooksByIds(ids));
    }
}
