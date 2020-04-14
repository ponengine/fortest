/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.service;

import com.test.company.domain.BaseResponse;
import com.test.company.domain.BaseRestApi;
import com.test.company.dto.ContentDTO;
import com.test.company.model.Content;
import com.test.company.repository.ContentRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OREOPON
 */
@Service
public class ContentService {
    
    private ContentRepository contentRepository;
    
    @Autowired
    private ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }
    
    public BaseRestApi get() {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<Content>> response = new BaseResponse<List<Content>>();
        List<Content> findAllData = contentRepository.findAll();
        response.setData(findAllData);
        baseapi.setResponse(response);
        baseapi.setSuccess(true);
        return baseapi;
    }
    
    public BaseRestApi register(ContentDTO content) {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<Content>> response = new BaseResponse<List<Content>>();
        Content newContent = new Content();
        BeanUtils.copyProperties(newContent, content);
        contentRepository.save(newContent);
        baseapi.setSuccess(true);
        return baseapi;
        
    }
    
    public BaseRestApi update(Long id, ContentDTO content) {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<Content>> response = new BaseResponse<List<Content>>();
        Content contentData = contentRepository.findById(id.toString());
        if (contentData != null) {
            response.setErrorCode("007");
            response.setErrorMessage("Content not found");
            baseapi.setResponse(response);
            baseapi.setSuccess(false);
            return baseapi;
        }
        contentData.setTitle(content.getTitle());
        contentData.setDetail(content.getDetail());
        contentRepository.save(contentData);
        baseapi.setSuccess(true);
        return baseapi;
        
    }
    
    public BaseRestApi delete(Long id) {
        BaseRestApi baseapi = new BaseRestApi();
        BaseResponse<List<Content>> response = new BaseResponse<List<Content>>();
        Content contentData = contentRepository.findById(id.toString());
        if (contentData != null) {
            response.setErrorCode("007");
            response.setErrorMessage("Content not found");
            baseapi.setResponse(response);
            baseapi.setSuccess(false);
            return baseapi;
        }
        contentRepository.delete(contentData);
        baseapi.setSuccess(true);
        return baseapi;
    }
    
}
