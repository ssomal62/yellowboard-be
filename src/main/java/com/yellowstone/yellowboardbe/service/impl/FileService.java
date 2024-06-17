package com.yellowstone.yellowboardbe.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String upload(MultipartFile file);
    Resource getImage(String fileName);
}
