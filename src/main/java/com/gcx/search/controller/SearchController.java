package com.gcx.search.controller;

import com.gcx.search.manager.SearchFacade;
import com.gcx.search.model.dto.search.SearchRequest;
import com.gcx.search.model.vo.SearchVO;
import com.gcx.search.service.PictureService;
import com.gcx.search.service.PostService;
import com.gcx.search.service.UserService;
import com.gcx.search.common.BaseResponse;
import com.gcx.search.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图片接口
 *
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }

}
