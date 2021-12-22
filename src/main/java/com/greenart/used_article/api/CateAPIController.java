package com.greenart.used_article.api;



import java.util.Map;

import com.greenart.used_article.data.CateVO;
import com.greenart.used_article.service.CateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CateAPIController {
    @Autowired
    CateService service;

    @PostMapping("/cate/add")
    public Map<String, Object> postaddCate(@RequestBody CateVO data){
        return service.addCate(data);
    }
    @DeleteMapping("/cate/delete")
    public Map<String, Object> deleteCate(@RequestParam Integer seq){
        return service.deleteCate(seq);
    }
    @GetMapping("/cate/get")
    public Map<String, Object> getCate(@RequestParam Integer seq){
        return service.getCateInfoBySeq(seq);
    }
    @PatchMapping("/cate/update")
    public Map<String, Object> patchCateInfo(@RequestBody CateVO data){
        return service.updateCateInfo(data);
    }     
    @GetMapping("/cate/keyword")
    public Map<String, Object> getCateByKeyword(@RequestParam @Nullable String keyword){
        return service.getCateByKeyowrd(keyword);

        
    }
}
