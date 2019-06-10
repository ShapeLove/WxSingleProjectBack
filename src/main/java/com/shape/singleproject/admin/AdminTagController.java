package com.shape.singleproject.admin;

import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.service.TagService;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.TagPageQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台管理-标签管理
 */
@RestController
@RequestMapping("/admin/tag")
@Slf4j
public class AdminTagController {

    @Resource
    private TagService tagService;

    /**
     *
     * @param tagPageQuery
     * @return
     */
    @PostMapping("/pageList")
    public PageResult<Tags> pageList(@RequestBody TagPageQuery tagPageQuery) {
        return tagService.queryTagsByPage(tagPageQuery);
    }

    @PostMapping("/addTag")
    public Result addTag(@RequestBody Tags tags) {
        try {
            if (tags.getTagType() == null || StringUtils.isBlank(tags.getTagName())) {
                return Result.failtResult("标签类型或标签名字为空");
            }
            if (tags.getTagName().length() > 10) {
                return Result.failtResult("标签名字不能大于10个字符");
            }
            tagService.addTag(tags);
        } catch (DuplicateKeyException e) {
            return Result.failtResult("该标签已存在");
        }
        return Result.successResult();
    }

    @PostMapping("/deleteTag")
    public Result deleteTag(@RequestBody Tags tag) {
        tagService.deleteTag(tag.getId(), tag.getTagType());
        return Result.successResult();
    }

}
