package com.shape.singleproject.admin;

import com.shape.singleproject.dto.Tags;
import com.shape.singleproject.service.TagService;
import com.shape.singleproject.vo.PageResult;
import com.shape.singleproject.vo.Result;
import com.shape.singleproject.vo.TagPageQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/tag")
@Slf4j
public class AdminTagController {

    @Resource
    private TagService tagService;

    @PostMapping("/pageList")
    public PageResult<Tags> pageList(@RequestBody TagPageQuery tagPageQuery) {
        return tagService.queryTagsByPage(tagPageQuery);
    }

    @PostMapping("/addTag")
    public Result addTag(@RequestBody Tags tags) {
        try {
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
